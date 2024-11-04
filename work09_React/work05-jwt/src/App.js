import "./App.css";

import { Route, Routes } from "react-router-dom";
import { Container } from "react-bootstrap";
import Header from "./components/Header";
import Home from "./pages/board/Home";
import Detail from "./pages/board/Detail";
import LoginForm from "./pages/user/LoginForm";
import JoinForm from "./pages/user/JoinForm";
import UpdateForm from "./pages/board/UpdateForm";
import SaveForm from "./pages/board/SaveForm";
import { createContext, useEffect, useState } from "react";

/*useContext 를 이용해서 하위 컴포넌트들이 데이터 공유하기*/
export const LogingedContext = createContext();

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  //컴포넌트가 mount or update 될때 로그인 여부에 따른 상태값 변경
  useEffect(() => {
    localStorage.getItem("id") != null ? setIsLoggedIn(true) : setIsLoggedIn(false);
    console.log("App useEffect isLoggeedIn = ", isLoggedIn);
  });

  /*
로그인(LoginForm.jsx) or 로그아웃(Header.jsx) 될 때 로그인여부 상태값을 변경할 이벤트
handleLoggedChange 와 isLoggedIn 를 사용해야 하는 컴포넌트들이 여럿이기에createContex 를 이용하여 서로 공유할수 있도록 한다.
*/
  const handleLoggedChange = (isLoggedIn) => {
    setIsLoggedIn(isLoggedIn);
  };
  return (
    <LogingedContext.Provider 
    value={ {isLoggedIn:isLoggedIn , 
             onLoggedChange:handleLoggedChange } }>
    <div>
      <Container>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/saveForm" element={<SaveForm />} />
          <Route path="/board/:id" element={<Detail />} />
          <Route path="/updateForm/:id" element={<UpdateForm />} />
          <Route path="/loginForm" element={<LoginForm />} />
          <Route path="/joinForm" element={<JoinForm />} />
        </Routes>
      </Container>
    </div>
    </LogingedContext.Provider>
  );
}

export default App;
