import Historial from "./historial";
import "../CSS/listas.css";

export default function ListaHistorial({list}) {
    return(
        <div className="list-container">
            <h2 className="list-title">Historial de Transferencias</h2>
            <div className="list-items">
                {list.map((hst) => <Historial historial={hst} key={hst.id}/>)}
            </div>
        </div>
    );
}