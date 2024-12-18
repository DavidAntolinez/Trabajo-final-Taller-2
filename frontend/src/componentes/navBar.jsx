import { Link, useNavigate} from "react-router-dom";
import "./CSS/navBar.css";

export default function NavBar({token,setToken}) {
    const navigate = useNavigate();
    function LogOut() {
    setToken("");
    navigate("/");
}
    return(
        // <nav>
        //     <p><Link to={`/`}>Home</Link></p>
        //     <ul>
        //         <li><Link to={`/almacenes/${token}`} >Almacenes</Link></li>
        //         <li><Link to={`/historial/${token}`}>Historial</Link></li>
        //         <li><button onClick={LogOut}>Log Out</button></li>
        //     </ul>
        // </nav>
        <nav className="navbar">
  <p className="navbar-brand">
    <Link to={`/`}>Home</Link>
  </p>
  <ul className="navbar-menu">
    <li className="navbar-item">
      <Link to={`/almacenes/${token}`}>Almacenes</Link>
    </li>
    <li className="navbar-item">
      <Link to={`/historial/${token}`}>Historial</Link>
    </li>
    <li className="navbar-item">
      <button onClick={LogOut} className="logout-button">Log Out</button>
    </li>
  </ul>
</nav>
    );
}

