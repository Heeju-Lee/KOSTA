import React from 'react';
import {Route, Routes} from 'react-router-dom'
import Home from './pages/board/Home';
import SaveForm from './pages/board/SaveForm';
import UpdateForm from './pages/board/UpdateForm';
import Detail from './pages/board/Detail';
import LoginForm from './pages/user/LoginForm';
import JoinForm from './pages/user/JoinForm';

const Navirouter = () => {
    return (
        <div>
            <Routes>
                <Route path='/' element={<Home/>} />
                <Route path='/saveForm' element={<SaveForm/>} />
                <Route path='/board/:id' element={<Detail />} />
                <Route path='/updateForm/:id' element={<UpdateForm/>} />
                
                <Route path='/loginForm' element={<LoginForm/>} />
                <Route path='/joinForm' element={<JoinForm/>} />
            </Routes>  
        </div>
    );
};

export default Navirouter;