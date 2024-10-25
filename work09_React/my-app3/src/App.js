import logo from './logo.svg';
import './App.css';

//const, let,,,,사용 var를 거의 사용하지 않는다.
const a = "Hello";
let b = 100;


function App() {
  return (
    <>
      <div>
        <h1 className="box-style">{a === "Hi" || "Hello" } React~~!!</h1>
        <h2>React 공부한지 {b===100? "100일" : "3일"} 되는날 </h2>
      </div>
    </>
  );
}

export default App;
