import { useState } from "react";



const usuario = {
    name: "pedro"
};

const products = [
    { title: 'Col', id: 1 },
    { title: 'Ajo', id: 2 },
    { title: 'Manzana', id: 3 },
  ];

const lista = products.map(product => 
    <li key={product.id}>
        {product.title}
    </li>
);







export default function MyApp() {
   
    const [count2,setCount2] = useState("A");

    function MyButton() {
        
        function Click() {
            setCount2(count2 + "A")
            // alert(count);
        }
        return(
            <button onClick={Click}>1 hiciste click {count2} veces</button>
        );
    }

    function MyButton2() {
        const [count,setCount] = useState("B");
        function Click2() {
            setCount(count + "B")
            // alert(count);
        }
        return(
            <button onClick={Click2}>2 hiciste click {count} veces</button>
        );
    }

    

    return(
        <div>
            <h1>Bienvenidos a mi app</h1>
            <MyButton />
            <br />
            <MyButton />
            <h1>
                {usuario.name}
            </h1>
            <MyButton2 />
            <br />
            <MyButton2 />
            <ul>{lista}</ul>
        </div>
    );
}