import { BrowserRouter,Route, Routes } from 'react-router-dom';
import NavBar from './navBar';
import MyApp from './pruebas';
import ListAlmacenesContainer from './Almacen/listaAlmacenesContainer';
import ListItemsContainer from './Items/listaItemsContainer';
import ListHistorialContainer from './Historial/listaIHistorialContainer';
import Transferencia from './Historial/transferencia';
import App from '../App';
import NewItem from './Items/newItem';
import NewAlmacen from './Almacen/newAlmacen';
import "./CSS/home.css";

// export default function Home({token,setToken}){
//         return(
//         <BrowserRouter>
//           <NavBar token={token} setToken={setToken}/>
//           <Routes>
//             <Route path='/' element={<HomePage/>}/>
//             <Route path="/almacenes/:token" element={<ListAlmacenesContainer/>}/>
//             <Route path="/items/:id/:token/:isFull" element={<ListItemsContainer/>}/>
//             <Route path="/historial/:token" element={<ListHistorialContainer/>}/>
//             <Route path="/historial/:almacenId/:token/:id" element={<Transferencia/>}/>
//             <Route path="/newitem/:almcId/:token" element={<NewItem/>}/>
//             <Route path="/newalmacen/:token" element={<NewAlmacen/>}/>
//           </Routes>
//         </BrowserRouter>
//         );
// }

// function HomePage() {
//   return (
//     <h1>Bienvenido</h1>
//   );
// }

export default function Home({ token, setToken }) {
  return (
    <BrowserRouter>
        <NavBar token={token} setToken={setToken} />
      <div className="main-container">
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route
            path="/almacenes/:token"
            element={<ListAlmacenesContainer />}
          />
          <Route
            path="/items/:id/:token/:isFull"
            element={<ListItemsContainer />}
          />
          <Route
            path="/historial/:token"
            element={<ListHistorialContainer />}
          />
          <Route
            path="/historial/:almacenId/:token/:id"
            element={<Transferencia />}
          />
          <Route path="/newitem/:almcId/:token" element={<NewItem />} />
          <Route path="/newalmacen/:token" element={<NewAlmacen />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

function HomePage() {
  return (
    <div className="home-page">
      <h1 className="welcome-message">Bienvenido</h1>
    </div>
  );
}