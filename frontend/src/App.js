import './App.css';
import LoginPage from './componentes/login';
import Home from './componentes/home';
import { useState } from 'react';

function App() {
  const [token, setToken] = useState("");

  return (
    <div>
      {
        !token.length > 0
        ?
        <LoginPage setToken={setToken}/>
        :
        <Home token={token} setToken={setToken}/>
      }
    </div>
  );
}

export default App;
