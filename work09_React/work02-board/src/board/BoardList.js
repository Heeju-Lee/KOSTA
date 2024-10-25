import Board from "./Board";

const comments = [
    {
        writer:"홍종각",
        comment:"금요일 쌀쌀한 아침공기",//trial comma(해야함)
    },
    {
        writer:"Tomas",
        comment:"여기는 시카고 입니다.",//trial comma(해야함)
    },
    {
        writer:"제시",
        comment:"물의를 일으켜 죄송합니다.",//trial comma(해야함)
    },
    {
        writer:"절미",
        comment:"귀여운 절미",//trial comma(해야함)
    },
]
function BoardList(props){
    return(
        <>
            {comments.map((comment)=>{
                return(
                    <Board writer={comment.writer} comment={comment.comment}/>
                )
            })}
        </>
    )
}

export default BoardList;
