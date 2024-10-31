import React from 'react';
import styled from 'styled-components';

//변수명 대문자로.
const StyledHeader = styled.div`
    border: 1px solid black;
    //height: 50px;
    width: 800px;
    margin: 0 auto;
    padding: 20px 0px;
    margin-top: 50px;
`

const Header = (props) => {
    return (
        <div>
            <StyledHeader>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
            </StyledHeader>
        </div>
    );
};

export default Header;