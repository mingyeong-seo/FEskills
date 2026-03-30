import { useEffect } from "react";
import { useSearchParams } from "react-router-dom";
import { getAccessToken } from "../../api/kakaoApi";

const KakaoRedirectPage = () => {
  const [searchParams] = useSearchParams();
  const code = searchParams.get("code");

  useEffect(() => {
    if (!code) return;

    getAccessToken(code)
      .then((data) => {
        console.log("토큰 성공:", data);
      })
      .catch((err) => {
        console.log("에러 전체:", err);
        console.log("에러 내용:", err.response?.data);
      });
  }, [code]);

  return <div>Kakao Login Processing...</div>;
};

export default KakaoRedirectPage;
