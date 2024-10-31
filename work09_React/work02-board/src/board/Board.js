import '../Board.css'


function Board(props){
    return(
        <>
            <div className='wrapper'>
                <div>
                    <img src="https://contents.pauline.or.kr/data/editor/1705/92e3df299e496a5cef491bf57c5db680_1494403184_05.JPG" width={50} height={50}/>
                </div>
                <div className='content'>
                    <span className='writer'>{props.writer}</span>
                    <span>{props.comment}</span>
                </div>
            </div>
        </>
    )
}

export default Board;

