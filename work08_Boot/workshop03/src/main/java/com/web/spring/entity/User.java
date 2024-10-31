package com.web.spring.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(length = 15)
	private String password;
	
	@Column(length = 30)
	private String name;

	//추가...다대다....중간에 다대다 관계를 해소하기 위한 joinTable/joinColumns(단방향)
	@ManyToMany(fetch = FetchType.EAGER)//findAll LAZY
	@JoinTable(name="orders", 
			   joinColumns = @JoinColumn(name="user_id"), 
			   inverseJoinColumns = @JoinColumn(name="pro_no"))
	Set<Product> Products = new HashSet<>();
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + "]";
	}
}
