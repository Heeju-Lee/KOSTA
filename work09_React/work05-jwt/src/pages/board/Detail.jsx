import React, { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";

const Detail = () => {
  //파라미터를 받는다.
  const { id } = useParams(); //

  const [board, setBoard] = useState({
    id: "",
    title: "",
    content: "",
    member: {},
    regDate:""
  });

  const navigator = useNavigate();
  useEffect(() => {
    axios
      .get("http://localhost:9000/boards/" + id, {
        headers: {
          Authorization: localStorage.getItem("Authorization"),
        },
      })
      .then((res) => {
        setBoard(res.data);
      })
      .catch((err) => {
          errFun(err);
      });
  }, []);

  //에러 출력 함수
  const errFun = (err) => {
    if (err.response.status === 403) {
      alert("로그인하고 이용해주세요.");
    } else {
      let errMessage = "오류 = " + err.response.data.type + "\n";
      errMessage += err.response.data.title + "\n";
      errMessage += err.response.data.status + "\n";
      errMessage += err.response.data.instance + "\n";
      errMessage += err.response.data.timestamp;
      alert(errMessage);
    }

    navigator("/");
  };

  //삭제
  const deleteBoard = (id) => {
    axios({
        method:"DELETE",
        headers: {
        Authorization: localStorage.getItem("Authorization"),
        },
        url : "http://localhost:9000/boards/"+id,
        })
        .then((res)=>{
        if(res.data ==="ok")
             navigator("/") ;
        else
         alert("삭제되지 않았습니다.");
     })
    .catch((err)=>{
         errFun(err);
    });       
  };//삭제끝

  //수정 클릭
  const updateBoard = () => {
    navigator("/updateForm/"+id);

  };

  return (
    <div>
      <h1>상세보기</h1>
      <Button
        variant="warning"
        onClick={updateBoard}
        disabled={
            board.member.name === localStorage.getItem("name") ? false : true
        }
      >
        수정
      </Button>
       {"     "}
      <Button
        variant="danger"
        onClick={() => deleteBoard(board.id)}
        disabled={board.member.id === localStorage.getItem("id") ? false : true}
      >
        삭제
      </Button>
      <hr />
      <h2>글번호 : {board.id}</h2>
      <h2>제목 : {board.title}</h2>
      <h2>작성자 : {board.member.name}</h2>
      <h2>내용 : {board.content}</h2>
      <h2>등록일 : {board.regDate}</h2>
    </div>
  );
};

export default Detail;
