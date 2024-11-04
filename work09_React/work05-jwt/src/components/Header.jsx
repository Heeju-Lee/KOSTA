import { useContext } from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Link, useNavigate } from 'react-router-dom';
import { LogingedContext } from '../App';
import { Button } from 'react-bootstrap';

import "../style.css";

const Header = ()=>{

  let logingedCon = useContext(LogingedContext);
  
  const navigator = useNavigate();
  const logoutCheck = ()=>{
    localStorage.removeItem("memberNo");
    localStorage.removeItem("id");
    localStorage.removeItem("name");
    localStorage.removeItem("address");
    localStorage.removeItem("Authorization");

    logingedCon.onLoggedChange(false);

    navigator("/");
  }

  return (
    <Navbar bg="primary" data-bs-theme="dark">
      <Container>
      <Link to="/" className="navbar-brand">Home</Link>
      <Nav className="me-auto">
      { logingedCon.isLoggedIn && 
             <Link to="/saveForm" className="nav-link">글쓰기</Link>}

      {!logingedCon.isLoggedIn && 
      <Link to="/joinForm" className="nav-link">회원가입</Link>}

      { logingedCon.isLoggedIn ? 
        <Button onClick={logoutCheck} className="nav-link" >
        Logout 
        </Button>
      :
         (<Link to="/loginForm" className="nav-link" >로그인</Link>)
      }

     {'        '}
    { 
    logingedCon.isLoggedIn && 
        <span>{localStorage.getItem("name")}님</span>
    }
   </Nav> 
  </Container>
  </Navbar>
  );
}

export default Header;