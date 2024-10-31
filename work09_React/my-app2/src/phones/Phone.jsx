//props를 통해서 컴포넌트의 상태값을 전달...

function Phone(props){
    return(
        <div>
            <h2>{`Phone Model - ${props.model}`}</h2>
            <h2>{`Phone Made - ${props.made}`}</h2>
        </div>
    )
}

export default Phone; 