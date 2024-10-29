import React from 'react';
import Header from '../components/commons/Header';
import Footer from '../components/commons/Footer';
import Login from '../components/login/Login';

// 페이지는 컴포넌트의 결합니다.
// common 컴포넌트  + 특정 컴포넌트
const LoginPage = (props) => {
    return (
        <div>
            <Header id="Header입니다"/>
            <Login id="kosta" pwd ="1234"/>
            <Footer />
        </div>
    );
};

export default LoginPage;
