import React, { useEffect, useState } from 'react';
import {Button, Container, Form } from 'react-bootstrap';
import axios from 'axios';
import {useNavigate, useParams} from 'react-router-dom';

const UpdateForm = () => {
    const {id} = useParams();
    const navigate = useNavigate();
    //비동기 호출
    const [board, setBoard] = useState({
        id:0,
        title:'',
        author:'',
    });

    useEffect(()=>{
        axios({
            url:'http://localhost:9000/boards/'+id,
            method: 'get',
        })
        .then((res)=>{
            setBoard(res.data);
        })
    },[])

    const changeForm=(e)=>{
        setBoard({
            ...board,
            [e.target.name]:e.target.value
        },);
    }

    const submitBoard=(e)=>{
        //폼에 걸린 액션으로 가는 걸 막고 axios 비동기 통신을 탄다.
        e.preventDefault();
        //비동기 통신으로 폼에 입력된 값으로 board를 생성... 이거를 서버에 전달하면 ..디비에 입력된다.
        axios ({
            url:'http://localhost:9000/boards/'+id,
            method: 'put',
            data: board,
        },)
        .then((res)=>{
            console.log(res.data);
            if(res.status === 200){
                navigate("/board/"+id);
            }else{
                alert("게시글 수정 실패.")
            }
        }).catch((err)=>{
            console.log(err);
        })
    }
    
    return (
        <div>
            <h1>글 수정하기</h1>
                <Container style={{marginTop:'100px'}}>
                    <Form onSubmit={submitBoard}> 
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Title</Form.Label>
                            <Form.Control type="text" name="title" value={board.title} onChange={changeForm}/>
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Author</Form.Label>
                            <Form.Control type="text" name="author" value={board.author}  onChange={changeForm}/>
                        </Form.Group>
                        <Button variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form>
                </Container>
        </div>
    );
};

export default UpdateForm;