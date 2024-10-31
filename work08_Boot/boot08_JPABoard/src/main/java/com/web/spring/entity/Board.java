package com.web.spring.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;//글번호
	
	private String title;

	@Column(length = 100)
	private String content;
	
	@CreationTimestamp
	private LocalDateTime regDate;//등록일
	@UpdateTimestamp
	private LocalDateTime updateDatel;//수정일
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_no")
	private Member member;//게시글 작성자

	//연관된 객체는 제외하고 만든다. 직접..
	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", updateDatel=" + updateDatel + "]";
	}
	
}
