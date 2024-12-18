import "../CSS/listas.css";

export default function Historial({historial}) {
    return(
        <div className="almacen-card">
            <h4 className="almacen-title">Historial Id: {historial.id}</h4>
            <p className="almacen-info">Item id: {historial.itemId}</p>
            <p className="almacen-info">Almacen Origen id: {historial.almacenOrigenId}</p>
            <p className="almacen-info">Almacen Destino id: {historial.almacenDestinoId}</p>
            <p className="almacen-info">Fecha de la Transferencia: {historial.fecha}</p>
        </div>
    );
}