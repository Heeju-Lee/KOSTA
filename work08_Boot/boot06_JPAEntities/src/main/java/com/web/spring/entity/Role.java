package com.web.spring.entity;


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
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

//@Table(name="role") // Entity 클래스명과 테이블명이 다를 때 지정
//@ToString

public class Role {
	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;//role_id
	
	@Column(length = 20)
	private String name;
	/*
	 Lombok을 사용해서 toString을 하면 내부적으로 계속해서 select문이 호출되는 일이 발생한다.
	 재귀호출이 일어난다...
	 그래서 JPA에서는 롬복을 사용하지 않고 직접 toString을 오버라이딩 해주는 것이 좋다.
	 */
	@Override
	public String toString() {
		return "Role [roleId="+roleId+", roleName="+name+"]";
	}
}

/*
 * 회원과 권한 관계는 N : N
 * 회원이 권한을 가지고
 * 권한은 회원을 가지는 양방향 관계
 * 권한이 회원을 가지는 관계로 안만들었다.
 * Custom 을 필드로 가지고 있지 않다.
 * Role을 통해서 Custom정보를 획득할 수 없다.
 * 
 * 결과적으로 Custom을 통해서만 Role 정보를 받아오도록 할 것이다.
 * --> 단방향 코드로 작성할 것이다.
 */
