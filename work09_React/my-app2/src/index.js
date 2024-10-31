import React, { Fragment } from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import PMS from './phones/PMService';
import Clock from './time/Clock';
import Phone from './phones/Phone';

// //1. const, function 사용해서 ui를 구성해봄.
// const member={
//   id:"kosta",
//   pwd:"1234",
//   name:"홍종각",
//   address:"종각",//trial comma
// }

// function getToken(member){
//   return member.id+" "+member.name;
// }


// const uielement = (
//   <h1>Hello, {getToken(member)}</h1>
// )
setInterval(()=>{
  root.render(
    //3. Custom Tag
    <> 
        <Phone model={"IPhone-16"} made={"Apple"}/>
        <Phone model={"갤럭시-S23"} made={"Samsung"}/>
        <Phone model={"갤럭시-S24"} made={"Samsung"}/>
        <Clock />
    </>
  );
},1000);

const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   // uielement ---1

//   <React.StrictMode>
    
//     <Clock/>

//   </React.StrictMode>
// );
