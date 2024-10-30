import React from 'react';

const TextColor = {color:'magenta'}

const Home = (props) => {
// const boards = props.boards;
const {boards, setBoards} = props;//구조분할 할당
    return (
        <div>
            <h1 style={TextColor}>Home Page....</h1>           
            <button onClick={()=>{setBoards([])}}>🚀전체삭제🚀</button>
            {boards.map((board)=>(
                <h3>
                    Title : {board.title} &nbsp;&nbsp;
                    Content : {board.content}
                </h3>
            ))
            }
        </div>
    );
};

export default Home;