import Almacen from "./almacen";
import "../CSS/listas.css";

export default function ListaAlmacenes({list,token}) {
    // console.log(list);
    return(
        // <div>
        //     <h2>Almacenes</h2>
        //     <div>
        //         {list.map((alm) => <Almacen almacen={alm} token={token} key={alm.id}/>)}
        //     </div>
        // </div>

        <div className="list-container">
  <h2 className="list-title">Almacenes</h2>
  <div className="list-items">
    {list.map((alm) => (
      <Almacen almacen={alm} token={token} key={alm.id} />
    ))}
  </div>
</div>
    );
}