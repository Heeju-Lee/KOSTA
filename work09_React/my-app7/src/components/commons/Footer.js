import React from 'react';
import {styled} from 'styled-components';

const bear = "https://w7.pngwing.com/pngs/0/787/png-transparent-cool-bear-bear-in-hoodie-with-eyeglasses-thumbnail.png";
const styles = {'width':'150px','height':'150px'}
const StyledFooter = styled.div`

`

const Footer = () => {
    return (
        <div>
            <StyledFooter>
                <img src={bear} style={styles}/>
            </StyledFooter>
        </div>
    );
};

export default Footer;