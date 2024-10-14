package com.web.spring.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
//@ToString  
public class Custom {
	
	@Id//유일한 값..PK
	@Column(name="custom_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment 
	private Integer customId; 
	
	@Column(length= 500)
	private String password;
	
	@Column(length= 50)
	private String name;
	
	@Column(length=200)
	private String email;
	
	@CreationTimestamp
	private LocalDateTime regDate;
	
	//추가...다대다....중간에 다대다 관계를 해소하기 위한 joinTable/joinColumns
	@ManyToMany
	@JoinTable(name="custom_role", 
			   joinColumns = @JoinColumn(name="custom_id"), 
			   inverseJoinColumns = @JoinColumn(name="role_id"))
	Set<Role> roles = new HashSet<>();

	/*
	  toString 함수는 직접 구현한다.
	  이때 연관된 객체는 제외하고 오버라이딩 시킨다.
	 */
	@Override
	public String toString() {
		return "Custom [customId=" + customId + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", regDate=" + regDate + "]";
	}

}
