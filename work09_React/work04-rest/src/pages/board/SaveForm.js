import React, { useState } from 'react';
import {Button, Container, Form } from 'react-bootstrap';
import axios from 'axios';
import {useNavigate} from 'react-router-dom';

const SaveForm = () => {
    const navigate = useNavigate();
    const [board, setBoard] = useState({
        title:'',
        author:'',
    })
    const changeForm=(e)=>{
        //setBoard...board를 새로 만들고 폼에 입력된 값으로 그 객체를 채운다.
        setBoard({
            ...board, 
            [e.target.name]:e.target.value
        })
    }

    const submitBoard=(e)=>{
        //폼에 걸린 액션으로 가는 걸 막고 axios 비동기 통신을 탄다.
        e.preventDefault();
        //비동기 통신으로 폼에 입력된 값으로 board를 생성... 이거를 서버에 전달하면 ..디비에 입력된다.
        axios ({
            url:'http://localhost:9000/boards',
            method: 'post',
            data: board,
        })
        .then((res)=>{
            console.log(res.data);
            if(res.status===201){
                navigate("/");
            }else{
                alert("게시글 쓰기 실패.")
            }
        }).catch((err)=>{
            console.log(err);
        })
    }

    return (
        <div>
            <Container style={{marginTop:'100px'}}>
                <Form onSubmit={submitBoard}> 
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Title</Form.Label>
                        <Form.Control type="text" name="title" onChange={changeForm}/>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Author</Form.Label>
                        <Form.Control type="text" name="author" onChange={changeForm}/>
                    </Form.Group>
                    <Button variant="primary" type="submit">
                        Submit
                    </Button>
                </Form>
            </Container>
        </div>
    );
};

export default SaveForm;