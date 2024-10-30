import './App.css';
import Login from './components/login/Login';
import { Title } from './css/MyTitle'; 
import BoardPage from './pages/BoardPage';
import HomePage from './pages/HomePage';
import LoginPage from './pages/LoginPage';
import {BrowserRouter, Link, NavLink, Route, Routes} from 'react-router-dom';


function App() {
  return (
    <div className="App">
        <BrowserRouter>
        {/* 화면에 보이는 부분은 Link로 표시한다. */}
          <nav>
            <NavLink to={"/"} >Home</NavLink>
            <NavLink to={"/loginPage"}>Login</NavLink>
            <NavLink to={"/board"}>Board</NavLink>
          </nav>
          <Routes>
            <Route path='/' element={ <HomePage/> } />
            {/* http://localhost:3000/login/kosta */}
            <Route path='/login/:id' element={ <Login/> } />
            <Route path='/loginPage' element={ <LoginPage/> } />
            <Route path='/board' element={ <BoardPage/> } />
          </Routes>
        </BrowserRouter>
    </div> 
  );
}

export default App;
