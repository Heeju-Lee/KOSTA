package com.web.spring.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
//@ToString
public class Board {

	@Id
	@Column(name = "board_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardId;
	
	@Column(length = 100)
	private String title;
	
	@Lob
	private String content;//text Type
	
	private int count;
	
	@CreationTimestamp
	private LocalDateTime regDate;//글 입력되는 시간을 자동적으로 생성

	//연관관계 추가 
	//Custom 추가
	//한명의 회원이 여러개의 게시물을 작성
	//Board(N) -------- custom(1)
	//fetchType :: EAGER preLoading 과 비슷함(연관된 객체까지 찾음)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="custom_id")//붙여줘야 custom_custom_id가 안됨.
	private Custom custom;

//	@Override
//	public String toString() {
//		return "Board [boardId=" + boardId + ", title=" + title + ", content=" + content + ", count=" + count
//				+ ", regDate=" + regDate + ", custom=" + custom + "]";
//	}
	
	//연관된 객체는 제외
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", title=" + title + ", content=" + content + ", count=" + count
				+ ", regDate=" + regDate + "]";
	}
	
	
	
}


