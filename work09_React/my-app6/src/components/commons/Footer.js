import React from 'react';
import styled from 'styled-components';

const StyledFooter = styled.div`
    border: 1px solid black;
    height: 50px;
    width: 800px;
    margin: 0 auto;
    list-style: none;
    padding-top: 40px;
    padding-bottom: 40px;
`

const Footer = () => {
    return (
        <div>
            <StyledFooter>
                <li>오시는 길 : 서울 종로구 우정국로 대왕빌딩 7층</li>
                <li>전화번호 : 02 - 111 - 1123</li>
            </StyledFooter>
        </div>
    )
};

export default Footer;