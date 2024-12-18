import { Link } from "react-router-dom";
import "../CSS/listas.css";

export default function Almacen({ almacen, token }) {

    function isFull() {
        return !(almacen.capacidadTotal > almacen.itemsAlmacenados);
    }

    return (
        // <div>
        //     <h4>Almacen id {almacen.id}</h4>
        //     <p>Capacidad: {almacen.capacidadTotal}</p>
        //     <p>Items Almacenados: {almacen.itemsAlmacenados}</p>
        //     <Link to={`/items/${almacen.id}/${token}/${isFull()}`}>Lista de items</Link>
        // </div>

        <div className="almacen-card">
            <h4 className="almacen-title">Almacen id {almacen.id}</h4>
            <p className="almacen-info">Capacidad: {almacen.capacidadTotal}</p>
            <p className="almacen-info">Items Almacenados: {almacen.itemsAlmacenados}</p>
            <Link
                to={`/items/${almacen.id}/${token}/${isFull()}`}
                className="almacen-link"
            >
                Lista de items
            </Link>
        </div>
    );
}