package com.web.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.Product;

@RestController
public class TestController {
	
	//1. No가 1234인 상품을 검색하는 요청을 작성 – 파라미터로 넘어온 값을 받는다.(v)
	@GetMapping("/product")
	public ResponseEntity<?> findProduct(@RequestParam String no) {
		Product product = new Product("1234", "갤럭시워치", "삼성", 123456);
		return ResponseEntity
				.status(200)
				.body(product);
	}
	
	//2. No가 1234인 상품을 검색하는 요청을 작성 – 요청시 주소창에 바로 입력된다 (v)
	@GetMapping("/product/{no}")
	public ResponseEntity<?> findProduct2(@PathVariable String no) {
		Product product = new Product("2345", "갤럭시워치", "삼성", 123456);
		return ResponseEntity
				.status(200)
				.body(product);
	}
	
	//3. 모든 상품의 정보를 가져오는 요청을 작성 (v) 
	@GetMapping("/products")
	public ResponseEntity<?> productList(){
		List<Product> list = new ArrayList<>();
			list.add(new Product("2345", "갤럭시워치", "삼성", 123456));
			list.add(new Product("2346", "갤럭시워치2", "삼성", 123456));
		return ResponseEntity
				.status(200)
				.body(list);
	}
	
	//4. 하나의 상품을 등록하는 요청을 작성 (v)
	@PostMapping("/regproduct")
	public ResponseEntity<?> regProduct(@RequestBody Product pvo){
		return ResponseEntity
				.status(201)
				.body(pvo);
	}
	
	//5. 특정한 상품정보를 수정하는 요청을 작성 (v)
	@PutMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestBody Product pvo){
		return ResponseEntity
				.status(200)
				.body(pvo);
	}
	
	//6. 특정한 상품정보를 삭제하는 요청을 작성 (v)
	@DeleteMapping("/delete/{no}")
	public ResponseEntity<?> deleteProduct(@PathVariable String no){
		return ResponseEntity
				.status(200)
				.body("[상품번호 "+no+"] 삭제 완료");
	}
}
