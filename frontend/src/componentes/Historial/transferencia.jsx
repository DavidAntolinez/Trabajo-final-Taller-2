import { useState,useEffect } from "react";
import { useParams } from "react-router-dom";
import { getAlmacenes, newHistorial } from "../../helpers/API";
import { useNavigate } from "react-router-dom";
import "../CSS/transferencia.css";

export default function Transferencia() {

   const [almcs,setAlmcs] = useState([]);
    const token = useParams().token;
    const almcOriId = useParams().almacenId;
    const itemId = useParams().id;
    const navigate = useNavigate();
       useEffect(() => {
           // Definir y ejecutar la función asíncrona dentro del efecto
           const fetchData = async () => {
             try {
               const data = await FetchListaAlmacenes();
               setAlmcs(CleanData(data)); // Actualizar estado con los datos
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
               return error;
           }
       }

       function CleanData(data) {
        const updatedData = data.filter(almc => (almc.id != almcOriId) && (almc.capacidadTotal > almc.itemsAlmacenados));
        return updatedData;
       }
       
       function MyButton(almcId) {
        function Click() {
            handleClick(almcId.almcId);
        }
        return(
            // <button onClick={Click}>Transferir</button>
            <button onClick={Click} className="btn-secondary">Transferir</button>
        );
    }

       async function handleClick(almcDesId) {
            try {
                const response = await newHistorial(token,itemId,almcOriId,Number(almcDesId));
                if(response.status === 200){
                    alert("Transferencia exitosa");
                    navigate("/");
                }else{
                    alert("Ese item ya no se encuentra en ese almacen");
                }
            } catch (error) {
                alert("Ha ocurrido un error: "+error);
            }
       }

       const lista = almcs.map(almc => 
        // <li key={almc.id}>
        //     <p>
        //     Almacen id: {almc.id}
        //     </p>
        //     <MyButton almcId={almc.id}/>
        // </li>
        <li key={almc.id} className="list-item">
      <p className="list-item-text">Almacén id: {almc.id}</p>
      <MyButton almcId={almc.id} />
    </li>
    );

       return(
    //     <div>
    //         <h3>Seleccione a que almacen transferir el item</h3>
    //         <ul>{lista}</ul>
    //   </div>
    <div className="container">
  <h3 className="section-title">Seleccione a qué almacén transferir el ítem</h3>
  <ul className="list-container">
    {lista}
  </ul>
</div>
       );
}