import React from 'react';
import { useParams , useLocation} from 'react-router-dom';
import styled from 'styled-components';

//Styled Component다.
// 이를 쓰면 html custom tag만으로 css 효과를 바로 연결한다.
// 이름은 Component 이기에 반드시 대문자로 시작해야 한다.
const StyledLogin = styled.div`
    color: violet;
    padding: 30px 0px 30px;
    
`

//const Login = (props) => {
const Login = (props) => {
    //10/30
    const param = useParams (); // 페이지 링크로 이동할 때, 주소창 값 전달 받기
    const location = useLocation(); // 링크를 통해서 데이터를 받아올 때 사용
    const user = location.state.user; // state로 전달된 user 객체

    return (
        <div>
            <StyledLogin>
                <h1>로그인 페이지 입니다.</h1>
                {/* <h3>ID : {props.id}</h3>
                <h3>PWD : {props.pwd}</h3> */}

                <h3>User ID : {param.id}</h3>
                <h3> User : {user.name}, {user.pwd}, {user.id}</h3>
                
            </StyledLogin>
        </div>
    );
}


export default Login;