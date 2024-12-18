import { useEffect,useState } from "react";
import { getHistorial } from "../../helpers/API";
import { useParams } from "react-router-dom";
import ListaHistorial from "./listaHistorial";
import "../CSS/listas.css";


export default function ListHistorialContainer(){
    const [historial,setHistorial] = useState([]);
    const token = useParams().token;

    useEffect(() => {
        // Definir y ejecutar la función asíncrona dentro del efecto
        const fetchData = async () => {
          try {
            const data = await FetchListaHistorial();
            setHistorial(data); // Actualizar estado con los datos
          } catch (error) {
            console.error("Error al obtener los datos:", error);
          }
        };
    
        fetchData();
      }, []);

    //   console.log(almcs);
    
    async function FetchListaHistorial() {
        try {
            const response = await getHistorial(token);
            return response.data;
        } catch (error) {
            return error.response;
        }
    }

    return(
      <div className="container">
        < ListaHistorial list={historial}/>
      </div>
        
        
    );
}