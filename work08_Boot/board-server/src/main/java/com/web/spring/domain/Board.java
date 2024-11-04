package com.web.spring.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //서버 실행시에 해당 객체로 테이블 매핑생성
public class Board {
	
	@Id//pk를 해당 필드로 한다	
	@GeneratedValue(strategy = GenerationType.IDENTITY)//해당 디비 번호증가 전략을 따라가겠다.
	private Long id;
	
	private String title;
	
	@Column(length = 20)
	private String author;			
}


