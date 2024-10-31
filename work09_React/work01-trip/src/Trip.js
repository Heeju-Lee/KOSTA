import Img1 from "./assets/1.jpg"
import Img2 from "./assets/2.jpg"
import Img3 from "./assets/3.jpg"
import Img4 from "./assets/4.jpg"
import Img5 from "./assets/5.jpg"
import Img6 from "./assets/6.jpg"
import'./App.css';

function Trip(){
    return(
        <>
            <div className="images">
                <img src={Img1} width={250} height={250}/>
                <img src={Img3} width={250} height={250}/>  
                <img src={Img5} width={250} height={250}/>
            </div>
        </>
    )
}

export default Trip;