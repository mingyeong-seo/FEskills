package com.example.demo.util;

import java.io.UnsupportedEncodingException;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.WeakKeyException;
import lombok.extern.log4j.Log4j2;

@Log4j2

public class JWTUtil {

	// 토큰을 생성할 때 사용되는 key 값은 최소 30자 이상이어야 함
	private static String key = "12345678901234567890123456789012345678901234567890";
	public static String generateToken(Map<String, Object> valueMap, int min) {
		SecretKey key = null;
		
		try {
			key = Keys.hmacShaKeyFor(JWTUtil.key.getBytes("UTF-8"));
		} catch (WeakKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String jwtStr = Jwts.builder()
				.setHeader(Map.of("typ","JWT"))
				.setClaims(valueMap)
				.setIssuedAt(Date.from(ZonedDateTime.now().toInstant()))
				.setExpiration(Date.from(ZonedDateTime.now().plusMinutes(min).toInstant()))
				.signWith(key)
				.compact();
		
		return jwtStr;
	}
	
	public static Map<String, Object> validateToken(String token){
		Map<String, Object> claim = null;
		
		try {
			SecretKey key = Keys.hmacShaKeyFor(JWTUtil.key.getBytes("UTF-8"));
			
			claim = Jwts.parserBuilder()
					.setSigningKey(key)
					.build()
					.parseClaimsJws(token)
					.getBody();
		} catch (WeakKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return claim;
	}
	
}