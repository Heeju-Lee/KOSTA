import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import Form from './form/Form';
import Movie from './reservation/Movie';


const root = ReactDOM.createRoot(document.getElementById('root'));

function reservation(){
  alert("영화예매 확인 되었습니다~!!!")
}

root.render(
  //<Form/>
  <Movie reservation={reservation} />

  //<App/>

);

