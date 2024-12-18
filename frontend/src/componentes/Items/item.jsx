import { Link } from "react-router-dom";
import "../CSS/listas.css";

export default function Item({item,token}) {
    return(
        <div className="almacen-card">
            <h4 className="almacen-title">{item.nombre}</h4>
            <p className="almacen-info">{item.descripcion}</p>
            <Link to={`/historial/${item.almacenId}/${token}/${item.id}`} className="almacen-link">Transferir</Link>
        </div>
    );
}