import { useState } from "react";
import { Button, InputGroup } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import axios from "axios";
import { useNavigate } from "react-router-dom";


const JoinForm = () => {
  //
  const [member, setMember] = useState({
    id: "",
    name: "",
    pwd: "",
    address: "",
  });

  // 중복체크 결과 값을 저장 할 idCheckResult
 const [idCheckResult , setIdCheckResult] = useState("");

// 아이디 중복여부에 따른 css 를 적용하기 위해 상태 변수
 const [isCheckResult , setIsCheckResult] = useState(false);


  //각 text 박스에 값이 변경되었을 때
  const changeValue = (e) => {    
    setMember({ ...member, [e.target.name]: e.target.value }); 
      
    //id 입력박스에 값이 입력될때마다 axios를 이용해서 비동기통신 - 중복여부 체크
    if (e.target.name === "id" && e.target.value !== "") {
      axios({
        method: "GET",
        url: "http://localhost:9000/members/" + e.target.value,
        // data : {"id" : e.target.value},
      })
        .then((res) => {
          //console.log(res);
          setIdCheckResult(res.data);
           res.data==="중복입니다." ? setIsCheckResult(true) : setIsCheckResult(false); 
        })
        .catch((err) => {
          //실패
          let errMessage = err.response.data.type + "\n";
          errMessage += err.response.data.title + "\n";
          errMessage += err.response.data.detail + "\n";

          errMessage += err.response.data.status + "\n";
          errMessage += err.response.data.instance + "\n";
          errMessage += err.response.data.timestamp;
          alert(errMessage);
        });
    }
  };

  const navigator = useNavigate();

  //가입하기
  const submitJoin = (e)=>{
      axios({
      method:"POST",
      url : "http://localhost:9000/members",
      data : member,
      })
      .then((res)=>{
      console.log(res);
       navigator("/")
      })
      .catch((err)=>{
        console.log(err)
        let errMessage = err.response.data.type +"\n";
        errMessage += err.response.data.title +"\n";
        errMessage += err.response.data.detail +"\n";
        errMessage += err.response.data.status +"\n";
        errMessage += err.response.data.instance +"\n";
        errMessage += err.response.data.timestamp;
        alert(errMessage);
      }); 
  };

  return (
    <>
      <h2 style={{ padding: "20px", color: "red" }}>회원가입</h2>
      <Form>
        <Form.Label htmlFor="id">아이디</Form.Label>
        <InputGroup className="mb-3">
          <Form.Control type="text" id="id" name="id" onChange={changeValue} />
          <InputGroup.Text style={ isCheckResult ? {color: "red"} : {color: "blue" } } >
               {idCheckResult}
          </InputGroup.Text>
        </InputGroup>
        <Form.Label htmlFor="name">이름</Form.Label>
        <Form.Control
          type="text"
          id="name"
          name="name"
          onChange={changeValue}
        />
        <Form.Label htmlFor="pwd">비밀번호</Form.Label>
        <Form.Control
          type="password"
          id="pwd"
          name="pwd"
          onChange={changeValue}
        />
        <Form.Label htmlFor="address">주소</Form.Label>
        <Form.Control
          type="text"
          id="address"
          name="address"
          onChange={changeValue}
        />
        <p>
          <Button variant="primary" onClick={submitJoin}>
            회원가입
          </Button>
        </p>
      </Form>
    </>
  );
};
export default JoinForm;
