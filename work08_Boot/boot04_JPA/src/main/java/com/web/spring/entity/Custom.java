package com.web.spring.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //DB테이블과 매핑되는 객체...자동으로 테이블명은 custom
@Table(name="custom") // Entity 클래스명과 테이블명이 다를 때 지정
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Custom {
	
	@Id//유일한 값..PK
	@Column(name="custom_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment 
	private Integer customId; //custom_id로 자동으로 컬럼명이 잡힌다..
	
	@Column(length= 500)
	private String password;
	
	@Column(length= 50)
	private String name;
	
	@Column(length=200)
	private String email;
	
	@CreationTimestamp
	private LocalDateTime regDate;// 고객이 등록될 대 시간이 자동으로 생성
}
