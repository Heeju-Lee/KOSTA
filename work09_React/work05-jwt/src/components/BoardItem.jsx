import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { Link } from 'react-router-dom';

const BoardItem = (props)=> {
  const {id, title, content, regDate, member} = props.board;
  return (
    <Card>
      <Card.Body>
        <Card.Title>
          제목 :  {title} /
           작성자 : {props.board.member.name}
        </Card.Title>
        
        <Link  className='btn btn-primary' to={"/board/"+id}>상세보기</Link>
        
      </Card.Body>
      </Card> 
  );
}

export default BoardItem;