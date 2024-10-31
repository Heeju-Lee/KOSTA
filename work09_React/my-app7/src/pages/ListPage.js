import React, { useState } from 'react';
import Footer from '../components/commons/Footer';
import {styled} from 'styled-components';

const StyledList = styled.div`
    border: 1px solid darkgreen;
    width: 600px;
    margin: 0 auto;
    padding: 10px;
    height: 80px;
    display: flex;
    justify-content: space-between;
    align-items: center;
`

const ListPage = () => {
const [boards, setBoards]=useState([
    {id:1, title:'제목1', content: '내용1'},
    {id:2, title:'제목2', content: '내용2'},
    {id:3, title:'제목3', content: '내용3'},
    {id:4, title:'제목4', content: '내용4'},
    {id:5, title:'제목5', content: '내용5'},
]);

const [board, setBoard]=useState({
    id: 0,
    title: "",
    content: ""
});

const handleWrite=(e)=>{
    e.preventDefault();// action에 걸린 페이지로 이동하는 것을 막아버려야 함.
    //전개연산자 사용됨....
    /*
     ...boards 기존 배열에 모든 boards를 복사해서 새로운 배열을 하나 생성한다.
     {...board, id:newid} --> 현재 새롭게 입력된 게시글 board 모든 속성값(title, content)을 새로운 배열에 추가
     이때 추가되는 객체는 title: board.title, content: board.content, id: newid
    */
    let newid;
    newid = boards[boards.length-1].id +1;
    setBoards([...boards,{...board, id:newid}]);
    // setBoard({
    //     ...board,//현재 board 상태를 그대로 복사 ... id:0, title:"", content:"".. 새로운 board 생성
    //     [e.target.name]:e.target.value
    // });
}

/* 사용자가 제목 또는 내용을 입력할때마다 호출되는 함수
...board --> 현재의 board를 그대로 복사하는 전개연산자
현재의 board를 그대로 복사하는 전개연산자
id:0, title: "", content: "" 이걸 가져와서 새로운 Board를 생성
[e.target.name]:e.target.value} -->
현재 name에 해당하는 폼의 속성값 title, value 값을 가져와서 이값으로 board를 업데이트 시킨다.
*/
const handleForm = (e)=>{
    console.log(e.target.name);
    console.log(e.target.value);

    //동적으로 키값을 할당하는 방법 !! 중요
    setBoard({...board, [e.target.name]:e.target.value})
}
    return (
        <div>
            <h1>ListPage....</h1>
            <form onSubmit={handleWrite}>
                <input type='text' placeholder='제목을 입력..' 
                onChange={handleForm} value={board.title} name="title"
                />
                <input type='text' placeholder='글 내용을 입력..' 
                onChange={handleForm} value={board.content} name="content"
                />
                <button type='submit'>글쓰기</button>
            </form>
            <p></p>
            <hr/>
            <p></p>
            {
                boards.map((board)=>
                <StyledList>
                    <div>
                        ID: {board.id} &nbsp;|&nbsp;
                        TITLE : {board.title} &nbsp;|&nbsp;
                        CONTENT : {board.content}
                    </div>
                    <div>
                        <button>삭제</button>
                    </div>
                </StyledList>
                )
            }
            <Footer />
        </div>
    );
};

export default ListPage;