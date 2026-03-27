import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { loginPost } from "../api/memberApi";

const initState = {
  email: "",
};

export const loginPostAsync = createAsyncThunk(
  "loginPostAsync",
  async (param, { rejectWithValue }) => {
    try {
      const data = await loginPost(param);
      return data;
    } catch (err) {
      return rejectWithValue(err.response?.data || { error: "ERROR_LOGIN" });
    }
  },
);

const loginSlice = createSlice({
  name: "LoginSlice",
  initialState: initState,
  reducers: {
    login: (state, action) => {
      //action 파라미터 받는다
      console.log("login....");
      const data = action.payload; // 아이디가 담겨진다
      return { email: data.email };
    },
    logout: (state, action) => {
      console.log("logout....");
      return { ...initState };
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(loginPostAsync.fulfilled, (state, action) => {
        console.log("fulfilled");
        const payload = action.payload;
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
