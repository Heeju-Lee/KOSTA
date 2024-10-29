import React from 'react';
import styled from "styled-components";

const StyledLogin = styled.div`
    color: cadetblue;
    padding: 30px 0px;
`

const Login = (props) => {
    return (
        <div>
            <StyledLogin>
                <h1>Login페이지 입니다.</h1>
                <h3>ID : {props.id}</h3>
                <h3>PASSWORD : {props.pwd}</h3>
            </StyledLogin>
        </div>
    );
};

export default Login;