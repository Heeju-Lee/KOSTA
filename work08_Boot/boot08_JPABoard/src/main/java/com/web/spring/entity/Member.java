package com.web.spring.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 :: 생성자 패턴..(에러 활률이 커짐, 순서가 바뀌기 쉽다)
 Blog blog = new Blog(0,0,0,0,0,0);
 
 :: 빌더 패턴...(정확도가 높고 가독성이 좋다)
 Blog blog = Blog.builder()
 				 .name("kosta")
 				 .id("1234")
 				 .memo("Good~~!)
 				 .build();
 				 
 1. 빌더의 각 값들이 생성자 말고 빌더를 통해서 주입 ... 정확도가 높다
 2. 생성자보다 가독력도 좋다.
 3. 다양한 인자값으로객체를 생성시.....생성자 오버로딩시...빌드 패턴으로 많이하는 추세다.
  >>>> 알아두기
 */


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder//추가!!
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberNo;
	
	@Column(unique = true)
	private String id;
	
	@Column(length = 20)
	private String pwd;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 60)
	private String address;
	
	@CreationTimestamp
	private LocalDateTime regDate;
	
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", address="
				+ address + ", regDate=" + regDate + "]";
	}
}
