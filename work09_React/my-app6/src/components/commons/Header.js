import React from 'react';
import styled from 'styled-components';

//변수명 대문자로.
const StyledHeader = styled.div`
    border: 1px solid black;
    height: 50px;
    display: flex;
    justify-content: space-around;
    width: 800px;
    margin: 0 auto;
    padding-top: 20px;
    list-style: none;
`

const Header = (props) => {
    return (
        <div>
            <h3>{props.id}</h3>
            <StyledHeader>
                <li>Home</li>
                <li>Sign Up</li>
                <li>Sign In</li>
            </StyledHeader>
        </div>
    );
};

export default Header;