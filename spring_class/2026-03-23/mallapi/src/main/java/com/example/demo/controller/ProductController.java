package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mallapi.dto.PageRequestDTO;
import com.example.demo.mallapi.dto.PageResponseDTO;
import com.example.demo.mallapi.dto.ProductDTO;
import com.example.demo.service.ProductService;
import com.example.demo.util.CustomFileUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/products")
public class ProductController {

	private final CustomFileUtil fileUtil;
	private final ProductService productService;

	@GetMapping("/view/{fileName}")
	public ResponseEntity<Resource> viewFileGet(@PathVariable(name = "fileName") String fileName) {
		return fileUtil.getFile(fileName);
	}

	// 목록 조회
	@GetMapping("/list")
	public PageResponseDTO<ProductDTO> list(PageRequestDTO pageRequestDTO) {
		return productService.getList(pageRequestDTO);
	}

	// 상세 조회
	@GetMapping("/{pno}")
	public ProductDTO get(@PathVariable(name="pno") Long pno) {
		log.info("상세 조회 요청: " + pno);
		return productService.get(pno);
	}

	// 등록
	@PostMapping("/")
	public Map<String, Long> register(ProductDTO dto) {
		log.info("등록: " + dto);

	    Long pno = productService.register(dto);

	    return Map.of("result", pno);
	}

	// 수정
	@PutMapping("/{pno}")
	public Map<String, String> modify(@PathVariable("pno") Long pno, ProductDTO productDTO) {

		productDTO.setPno(pno);

		productService.modify(productDTO);

		return Map.of("RESULT", "SUCCESS");
	}

	// 삭제
	@DeleteMapping("/{pno}")
	public Map<String, String> remove(@PathVariable("pno") Long pno) {
		log.info("상품 삭제 요청: " + pno);

		productService.remove(pno);

		return Map.of("RESULT", "SUCCESS");

	}

}
