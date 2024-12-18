import { useState } from "react";
import { useParams,useNavigate } from "react-router-dom";
import { putItem } from "../../helpers/API";
import "../CSS/newSomething.css";



export default function NewItem() {
    const almcId = useParams().almcId;
    const token = useParams().token;
    const [newItem, setNewItem] = useState({Nombre: "",Descripcion: ""})
    const navigate = useNavigate();

    const handleSubmit= async (e) => {
        e.preventDefault();
        try {
            const response = await putItem(token,almcId,newItem.Nombre,newItem.Descripcion);
            if (response.status === 200) {
                alert("Se guardo el item exitosamente")
                navigate("/");
            }else{
                alert("error: "+response)
            }
        } catch (error) {
            alert("error: "+error)
        }
    }

    return (
        // <div>
        //     <h1>Nuevo Item</h1>
        //     <form onSubmit={handleSubmit}>
        //         <input placeholder="Nombre del item" onChange={(e) =>  setNewItem({...newItem,Nombre: e.target.value})}/>
        //         <br />
        //         <textarea rows="5" cols="50" placeholder="Desrcipcion del item" onChange={(e) => setNewItem({...newItem,Descripcion: e.target.value})} />
        //         <br />
        //         <button type="submit">Agregar</button>
        //     </form>
        // </div>

        <div className="form-container">
  <h1 className="form-title">Nuevo Item</h1>
  <form onSubmit={handleSubmit} className="form">
    <input
      placeholder="Nombre del item"
      className="form-input"
      onChange={(e) => setNewItem({ ...newItem, Nombre: e.target.value })}
    />
    
    <textarea
      rows="5"
      cols="50"
      placeholder="Descripción del item"
      className="form-textarea"
      onChange={(e) => setNewItem({ ...newItem, Descripcion: e.target.value })}
    />
    <br />
    <button type="submit" className="btn-primary">Agregar</button>
  </form>
</div>
    );
}