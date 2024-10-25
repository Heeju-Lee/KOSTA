import './Movie.css';

function Movie({reservation}){
    const movie = "듄 파트2.";
    const header = "100만 관객 동원";
    const content =  movie+header;
    const url = "https://i.namu.wiki/i/EBnXxQjDFnQRItujvTQ61BBkgCb5-rqskUO9uhVXncxZU_I_gkzd3FBN2VDwCYo637zDjzJtdmdAHj_g7l9mow.webp";

    return(
        
        <>
            <div className='container'>
                <h2 className='title'>{content}</h2><br/>
                <img src={url} width={300} height={300}/><br/>
                <button onClick={reservation}>영화 예매 확정</button>
            </div>
        </>

    )
}

export default Movie;
