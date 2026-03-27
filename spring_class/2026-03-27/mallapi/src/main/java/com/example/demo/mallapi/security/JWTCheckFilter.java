package com.example.demo.mallapi.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.mallapi.dto.MemberDTO;
import com.example.demo.util.JWTUtil;
import com.google.gson.Gson;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2

public class JWTCheckFilter extends OncePerRequestFilter {
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {	
		if(request.getMethod().equals("OPTIONS")) {
			return true;
		}
		String path = request.getRequestURI();
		log.info("check uri........." + path);
		
		// api/member 경로의 호출은 체크안함
		if(path.startsWith("/api/member")) {
			return true;
		}
		
		// 이미지 조회 경로는 체크안함
		if(path.startsWith("/api/products/view")) {
			return true;
		}
		return false;
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("******************************");
		
		String authHeaderStr = request.getHeader("Authorization");
		
		try {
			// 요청 헤더의 인증 헤더의 7index부터 토큰 정보임
			String accessToken = authHeaderStr.substring(7);	
			// 토큰 검증
			Map<String, Object> claims = JWTUtil.validateToken(accessToken);
			
			log.info("JWT claims: " + claims);
			
//			filterChain.doFilter(request, response);
			
			String email = (String)claims.get("email");
			String pw = (String)claims.get("pw");
			Boolean social = (Boolean)claims.get("social");
			String nickname = (String)claims.get("nickname");
			
			List<String> roleNames = (List<String>)claims.get("roleNames");
			
			MemberDTO memberDTO = new MemberDTO(email, pw, nickname, social.booleanValue(), roleNames);
			
			log.info("&&&&&&&&&&&&&&&&&&&&&&&&&");
			log.info(memberDTO);
			log.info(memberDTO.getAuthorities());
			
			UsernamePasswordAuthenticationToken authenticationToken =
					new UsernamePasswordAuthenticationToken
					(memberDTO, pw, memberDTO.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			
			filterChain.doFilter(request, response);
			
		} catch (Exception e) {
			log.error("JWT Check 에러 발생함...");
			log.error(e.getMessage());
			
			Gson gson = new Gson();
			String msg = gson.toJson(Map.of("error","ERROR_ACCESS_TOKEN"));
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(msg);
			pw.close();
		}
		
		filterChain.doFilter(request, response);
		
	}

}
