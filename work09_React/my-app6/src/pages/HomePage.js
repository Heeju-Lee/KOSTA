import React from 'react';
import Home from '../components/home/Home';
import Header from '../components/commons/Header';
import Footer from '../components/commons/Footer';
import {useEffect, useState} from 'react';

const HomePage = (props) => {
const [boards, setBoards] = useState([]);
useEffect(()=>{
    //1. 디비에서 데이타 받아오는 비동기 통신...데이타 받았다 치고(blocking 일어남.)
    let datas = [
        {id:1,title:"첫번째 글", content: "첫번째 내용"},
        {id:2,title:"두번째 글", content: "두번째 내용"},
        {id:3,title:"세번째 글", content: "세번째 내용"},
    ]; 
    setBoards(datas); // 받아온 데이터를 상태에 반영
},[]);
    return (
        <div>
            <Header />
            <Home boards={boards} setBoards={setBoards}/>  
            <Footer/>          
        </div>
    );
};
            
export default HomePage;
