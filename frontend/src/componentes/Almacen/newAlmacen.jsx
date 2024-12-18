import { useState } from "react";
import { useParams,useNavigate } from "react-router-dom";
import { putAlmacenes } from "../../helpers/API";
import "../CSS/newSomething.css";

export default function NewAlmacen() {
    const token = useParams().token;
    const [newAlmacen, setNewAlmacen] = useState({Tamaño: ""})
    const navigate = useNavigate();

    const handleSubmit= async (e) => {
        e.preventDefault();
        try {
            const response = await putAlmacenes(token,newAlmacen.Tamaño);
            if (response.status === 200) {
                alert("Se creo el nuevo almacen exitosamente")
                navigate("/");
            }else{
                alert("error: "+response)
            }
        } catch (error) {
            alert("error: "+error)
        }
    }

    return (
        <div className="form-container">
            <h1 className="form-title">Nuevo Almacen</h1>
            <form onSubmit={handleSubmit} className="form">
                <input placeholder="Tamaño del Almacen" onChange={(e) =>  setNewAlmacen({...newAlmacen,Tamaño: e.target.value})} className="form-input"/>
                <br />
                <button type="submit" className="btn-primary">Crear</button>
            </form>
            
        </div>
    );
}