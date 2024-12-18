import { useEffect,useState } from "react";
import { getItems } from "../../helpers/API";
import { useParams,useNavigate } from "react-router-dom";
import ListaItems from "./listaItems";
import "../CSS/listas.css";


export default function ListItemsContainer(){
    const [items,setItems] = useState([]);
    const token = useParams().token;
    const almcId = useParams().id;
    const isFull = useParams().isFull;
    const navigate = useNavigate();

    useEffect(() => {
        // Definir y ejecutar la función asíncrona dentro del efecto
        const fetchData = async () => {
          try {
            const data = await FetchListaItems();
            setItems(data); // Actualizar estado con los datos
          } catch (error) {
            console.error("Error al obtener los datos:", error);
          }
        };
    
        fetchData();
      }, []);

    //   console.log(almcs);
    
    async function FetchListaItems() {
        try {
            const response = await getItems(token,almcId);
            return response.data;
        } catch (error) {
            return error.response;
        }
    }

    const handleClick = () => {
      navigate(`/newitem/${almcId}/${token}`);
    }

    return(
      <div className="container">
        <ListaItems list={items} token={token}/>
        <br />
          {isFull === "false" &&  <button onClick={handleClick} className="btn-primary">Agregar Item</button>}
      </div>
    );
}