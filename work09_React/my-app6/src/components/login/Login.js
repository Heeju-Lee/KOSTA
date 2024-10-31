import React from 'react';
import { useLocation, useParams } from 'react-router-dom';
import styled from "styled-components";

// styled-component....html custom tag 만으로 css 효과를 바로 연결 
// 컴포넌트이기 때문에 반드시 대문자로 시작해야한다.
const StyledLogin = styled.div`
    color: cadetblue;
    padding: 30px 0px;
`

const Login = () => {
const param = useParams();//페이지 링크로 이동할 때 주소창 값 전달 받기 
const location = useLocation();// Link를 통해서 데이터를 통으로 받아올 때 사용 한다.
const user = location.state.user;
    return (
        <div>
            <StyledLogin>
                <h1>Login페이지 입니다.</h1>
                <h3>User ID : {param.id}</h3>
                <h3>User : {user.name}, {user.pwd}  </h3>
            </StyledLogin>
        </div>
    );
};

export default Login;