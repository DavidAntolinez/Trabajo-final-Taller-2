import Item from "./item";
import "../CSS/listas.css";

export default function ListaItems({list,token}) {
    return(
        <div className="list-container">
            <h2 className="list-title">Items</h2>
            <div className="list-items">
                {list.map((itm) => <Item item={itm} token={token} key={itm.id}/>)}
            </div>
        </div>
    );
}