package com.example.demo.dto;

import java.net.URLEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadResultDTO {
	
	private String fileName;
	private String uuid;
	private String folderPath;
	
	
	// 이 메서드를 호출하면 img 태그에서 사용할 수 있는 url 정보를 리턴하도록 정의한다
	public String getImageUrl() {
		try {
			return URLEncoder.encode(folderPath + "/" + uuid + "_" + fileName, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	// 썸네일 이미지의 URL을 리턴하도록 메서드 정의한다 
	public String getTumbnailURL() {
		try {
			return URLEncoder.encode(folderPath + "/" + "s_"+ uuid + "_" + fileName, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
