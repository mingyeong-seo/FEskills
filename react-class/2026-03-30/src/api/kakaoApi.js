import axios from 'axios';

const REDIRECT_URI = 'http://localhost:3000/member/kakao';

const AUTH_URL = 'https://kauth.kakao.com/oauth/authorize';
const TOKEN_URL = 'https://kauth.kakao.com/oauth/token';

// 1. 로그인 링크 생성
export const getKakaoLoginLink = () => {
  return `${AUTH_URL}?client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URI}&response_type=code`;
};

// 2. access token 요청
export const getAccessToken = async (authCode) => {
  const params = new URLSearchParams();
  params.append('grant_type', 'authorization_code');
  params.append('client_id', REST_API_KEY);
  params.append('redirect_uri', REDIRECT_URI);
  params.append('code', authCode);

  const res = await axios.post(TOKEN_URL, params, {
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8',
    },
  });

  return res.data;
};
