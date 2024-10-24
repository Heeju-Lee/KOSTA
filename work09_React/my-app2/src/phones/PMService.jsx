import Phone from "./Phone";

function PMS(props){
    return(
        <div>
            <Phone model={"IPhone-16"} made={"Apple"}/>
            <Phone model={"갤럭시-S23"} made={"Samsung"}/>
            <Phone model={"갤럭시-S24"} made={"Samsung"}/>
        </div>
    )
}

export default PMS;