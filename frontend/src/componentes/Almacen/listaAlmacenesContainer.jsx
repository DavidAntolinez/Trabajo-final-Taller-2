import { useEffect,useState } from "react";
import { getAlmacenes } from "../../helpers/API";
import ListaAlmacenes from "./listaAlmacenes";
import { useParams,useNavigate } from "react-router-dom";
import "../CSS/listas.css";

export default function ListAlmacenesContainer(){
    const [almcs,setAlmcs] = useState([]);
    const token = useParams().token;
    const navigate = useNavigate();

    useEffect(() => {
        // Definir y ejecutar la función asíncrona dentro del efecto
        const fetchData = async () => {
          try {
            const data = await FetchListaAlmacenes();
            setAlmcs(data); // Actualizar estado con los datos
          } catch (error) {
            console.error("Error al obtener los datos:", error);
          }
        };
    
        fetchData();
      }, []);

    //   console.log(almcs);
    
    async function FetchListaAlmacenes() {
        try {
            const response = await getAlmacenes(token);
            return response.data;
        } catch (error) {
            return error.response;
        }
    }

    const handleClick = () => {
      navigate(`/newalmacen/${token}`);
    }

    return(
      // <div>
      //   <ListaAlmacenes list={almcs} token={token}/>
      //   <br />
      //     <button onClick={handleClick}>Nuevo Almacen</button>
      // </div>
      <div className="container">
  <ListaAlmacenes list={almcs} token={token} />
  <br />
  <button onClick={handleClick} className="btn-primary">
    Nuevo Almacen
  </button>
</div>
    );
}