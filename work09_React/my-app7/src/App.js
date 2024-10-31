import './App.css';
//import {BrowserRouter, Route, Routes} from 'react-router-dom';
//import ListPage from './pages/ListPage';
import axios from 'axios'; // 원래 이거임.
//import WritePage from './pages/WritePage';
//import Navigate from './Navigate';

function App() {

  const selectAll=()=>{
    axios.get("https://jsonplaceholder.typicode.com/posts")
      .then((result)=>{
        //console.log(result);
        //console.log(result.data);
        result.data.map((item)=>{
          console.log(item.id+","+item.title);
        })
      })
      .catch((err)=>{
        console.error(err);
      })
  }

  const selectById=()=>{
     axios({
      url:"https://jsonplaceholder.typicode.com/posts/1",
      method:"get",
      //data:
     })
     .then((result)=>{
      console.log(result.data);
     })
     .then(()=>{
      // 이런 부분이 callBack hell 을 만나지 않게 하는 중요한 부분이다.
      console.log("성공한 후에 할일은 여기서도 계속 됩니다....")
     })
     .catch((err)=>{
      console.log(err);
     })
  }

  return (
    <div className="App">
        {/* <BrowserRouter>
          <Navigate />
          <Routes>
            <Route path='/' element={<ListPage />} />
            <Route path='/write' element={<WritePage />} />
          </Routes>
        </BrowserRouter> */}
        
        {/* <ListPage /> */}

        <button onClick={selectAll}>get-selectAll</button>
        <button onClick={selectById}>get-selectById</button>
    </div>
  );
}

export default App;
