import './App.css';
import { Container } from 'react-bootstrap';
import Header from './components/Header';
import Navirouter from './Navirouter';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div className="App">
      <Container>
        <Header />
      </Container>
      <Navirouter />
    </div>
  );
}

export default App;
