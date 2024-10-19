package com.web.spring.entity;

import java.time.LocalDateTime;

/*
 b.board_id, b.title, b.custom_id, c.name 
 이 컬럼들을 읽어오는 템플릿 기능을 GETTER로 만들어 놓는다.
 
 Spring Data JPA가 해당 템플릿을 구현체 클래스로 알아서 생성한다.
 */
public interface BoardIF {
	Long getBoardId();
	String getTitle();
	String getContent();
	String getName();
	LocalDateTime getRegDate();
	int getCount();
	Integer getCustomId();

}
