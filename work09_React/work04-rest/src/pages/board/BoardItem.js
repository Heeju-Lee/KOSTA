import React from 'react';
import { Card, Container } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const BoardItem = (props) => {//{id, title, author:}
    const {id, title, author} = props.board;//
    return (
        <Container>
            <Card>
                <Card.Body>
                    <Card.Title>{title}</Card.Title>
                    <Link to={`/board/${id}`} className='btn btn-primary'>상세보기</Link>
                </Card.Body>
            </Card>
        </Container>
    );
};

export default BoardItem;