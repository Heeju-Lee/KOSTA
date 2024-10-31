import logo from './logo.svg';
import './App.css';

function Header(props) {
  console.log("props---->",props)
  return (
    <>
      <header>
        <h1>Best Top 3 {props.title}</h1>
      </header>
    </>
  );
}

function Nav() {
  return (
    <>
      <nav>
        <ol>
          <li>산티아고</li>
          <li>아씨씨</li>
          <li>칸쿤</li>
        </ol>
      </nav>
    </>
  );
}

function Article(props) {
  return (
    <>
      <article>
        <h2>{props.title}</h2>
        <h4><b>{props.content}</b></h4>
      </article>
    </>
  );
}

function App() {
  return (
    <>
      <div className='content'>
        <Header title="TRIPS"/>
        <Nav/>
        <Article title="태어난 김에 유럽일주" content="올겨울 최고의 찬스~~!"/>      
      </div>
    </>
  );
}

export default App;
