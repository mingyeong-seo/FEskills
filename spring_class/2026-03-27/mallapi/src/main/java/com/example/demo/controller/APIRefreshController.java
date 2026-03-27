package com.example.demo.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.CustomJWTException;
import com.example.demo.util.JWTUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class APIRefreshController {
	
	@RequestMapping("/api/member/refresh")
	public Map<String, Object> refresh(@RequestHeader("Authorization") String authHeader, @RequestParam(value="refreshToken") String refreshToken){
		if(refreshToken == null) {
			throw new CustomJWTException("NULL_REFRESH");
		}
		
		if(authHeader == null || authHeader.length() < 7) {
			throw new CustomJWTException("INVAILD_STRING");
		}
		
		String accessToken = authHeader.substring(7);
		
		// 토큰이 만료 전이라면
		if(checkExpiredToken(accessToken) == false) {
			return Map.of("accesstoken", accessToken,"refreshToken", refreshToken);
		}
		
		// Refresh 토큰 검증
		Map<String, Object> clains = JWTUtil.validateToken(accessToken);
		log.info("refresh...clains..."+clains);
		
		String newAccessToken = JWTUtil.generateToken(clains, 10);
		String newRefreshToken = checkTime((Integer)clains.get("exp"))==true ?
				JWTUtil.generateToken(clains, 60*24): refreshToken;
		
		return Map.of("accessToken",newAccessToken,"refreshToken", newRefreshToken);
	}
	
	// 1시간 미만 남은 토큰 처리 
	private boolean checkTime(Integer exp) {
		Date extDate = new Date((long)(exp*1000));
		long gap = extDate.getTime() - System.currentTimeMillis();
		
		long leftMin = gap / (1000*60);
		
		return leftMin < 60; // 한 시간 미만 여부 리턴 
	}
	
	private boolean checkExpiredToken(String token) {
		try {
			JWTUtil.validateToken(token);
		} catch (Exception e) {
			if(e.getMessage().equals("Expired")) {
				return true;
			}
		}
		return false;
	}
	
}
