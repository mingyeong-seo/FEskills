import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { loginPost } from "../api/memberApi";
import { getCookie, removeCookies, setCookie } from "../util/cookieUtils";
import { parsePath } from "react-router-dom";

const initState = {
  email: "",
};

// 쿠키에서 로그인 정보 로딩..
const loadMemberCookie = () => {
  const memberInfo = getCookie("member");

  if (memberInfo && memberInfo.nickname) {
    memberInfo.nickname = decodeURIComponent(memberInfo.nickname);
  }
  return memberInfo;
};
export const loginPostAsync = createAsyncThunk("loginPostAsync", (param) => {
  return loginPost(param);
});

// async (param, { rejectWithValue }) => {
//     try {
//       const data = await loginPost(param);
//       return data;
//     } catch (err) {
//       return rejectWithValue(err.response?.data || { error: "ERROR_LOGIN" });
//     }
//   },

const loginSlice = createSlice({
  name: "LoginSlice",
  initialState: loadMemberCookie() || initState,
  reducers: {
    login: (state, action) => {
      //action 파라미터 받는다
      console.log("login....");
      const data = action.payload; // 아이디가 담겨진다
      return { email: data.email };
    },
    logout: (state, action) => {
      console.log("logout reducer 실행");
      removeCookies("member");
      console.log("쿠키 삭제 실행");
      return { ...initState };
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(loginPostAsync.fulfilled, (state, action) => {
        console.log("login payload:", action.payload);
        console.log("fulfilled");
        const payload = action.payload;

        if (!payload.error) {
          setCookie("member", JSON.stringify(payload), 1);
        }
        return payload;
      })
      .addCase(loginPostAsync.pending, (state, action) => {
        console.log("pending"); // API
      })
      .addCase(loginPostAsync.rejected, (state, action) => {
        console.log("rejected");
      });
  },
});

export const { login, logout } = loginSlice.actions;
export default loginSlice.reducer;
