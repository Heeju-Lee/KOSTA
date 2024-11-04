import React, { useEffect, useState } from 'react';
import BoardItem from '../../components/BoardItem';
import axios from 'axios';

const Home = () => {
    //DB 목록을 저장해서 관리 할 useState
   const [boards , setBoards] = useState([]);

     //서버에서 데이터 조회   - axios
     useEffect(()=>{
        axios
        .get("http://localhost:9000/boards", {
        headers: {
        Authorization: localStorage.getItem("Authorization"),
        },})
        .then((res)=>{
            //console.log(res);

           setBoards(res.data);//state에서 관리되는 변수가 변경되어 update(re-rendering)
        })
        .catch((err)=>{
            
            let errMessage = err.response.data.type +"\n";
            errMessage += err.response.data.title +"\n";
            errMessage += err.response.data.detail +"\n";
            errMessage += err.response.data.status +"\n";
            errMessage += err.response.data.instance +"\n";
            errMessage += err.response.data.timestamp;
            alert(errMessage);          
       }); 
     }, []);


    return (
        <div>
            <h1 style={{padding:"20px"}}>전체 게시물</h1>
            {
             boards.map( (board)=> <BoardItem key={board.id} board={board}/> )
            }

        </div>
    );
};

export default Home;