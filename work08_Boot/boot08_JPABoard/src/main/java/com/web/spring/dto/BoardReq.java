package com.web.spring.dto;


import com.web.spring.entity.Board;
import com.web.spring.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString //JPA와 연관이 없기 때문에 TOSTRING 사용함
public class BoardReq {
    private String title;//제목
    private String content;//내용
    private Long memberNo;//작성자

    public Board toBoard(BoardReq boardReq){

        return Board.builder().title(boardReq.getTitle()).content(boardReq.getContent())
                .member(Member.builder().memberNo(boardReq.memberNo).build())
                .build();
    }

}
