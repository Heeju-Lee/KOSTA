import './App.css';
import {useState} from 'react';

// 서버에서 받아 온 데이타 ... 비동기 통신
//let location = "인도";
function location(){
  return "인도";
}

const styles = {color: 'crimson', fontSize:'30px'};

function App() {
  //여기서 여행지가 변경되면 그때마다 화면에 내용이 변경돼야 한다.
  //상태값으로 처리해야한다. useState()
  let locations = ["인도", "라오스", "마다가스카르", "스페인", "하와이"]
  let [loc, setLoc] = useState(['Best Like Trip~~!!',locations]);
  let [likes, setLikes] = useState([0,0,0,0,0]);

  return (
    <div className="App">
      <div className="nav">
        태어난 김에 세계일주
      </div>
      {/* getElementById("h3").innerHTML = location; */}
      {/* <h3 style={styles}>{location()}여행 Blog 작성</h3> */}
      {
        locations.map((location,index)=>(
          <div className='list'>
              <h3>{location}
                <span onClick={
                ()=>{
                  let like = [...likes];
                  like[index]++;
                  setLikes(like);
                }}>👍
                </span>
              </h3>
              <p>{loc[0]} {likes[index]}</p><hr/>
          </div>
      ))}
      </div>
  );
}

export default App;