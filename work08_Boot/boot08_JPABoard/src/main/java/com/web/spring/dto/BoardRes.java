package com.web.spring.dto;

import com.web.spring.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BoardRes {
    private Long id;//글번호
    private String title;//제목
    private String content;//내용
    private MemberRes member;//작성자
    private String regDate;//등록일

    public BoardRes(Board board) {
         id = board.getId();
         title=board.getTitle();
         content=board.getContent();
         regDate=board.getRegDate().toString();
         member=new MemberRes(board.getMember().getMemberNo(),
                 board.getMember().getId() , board.getMember().getName());

    }

    /*public BoardRes toBoardRes(Board board){
       return BoardRes.builder()
               .id(board.getId())
               .title(board.getTitle())
               .content(board.getContent())
               .regDate(board.getRegDate().toString())
               .member(new MemberRes(board.getMember().getId() , board.getMember().getName()))
               .build();
   }*/
}
