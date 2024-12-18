import { useState} from "react";
import { login, signUp } from "../helpers/API";
import "./CSS/login.css"



function LoginPage({setToken}) {
    const [user, setUser] = useState({username: "", password: ""});
    const [error, setError] = useState(false);
    const [flag,setFlag] = useState(false);

    const handleSubmit = async (e) => {

        e.preventDefault();
        try {
            if(flag){
                const response = await signUp(user.username,user.password);
                if(response.status === 201){
                    alert("Se ha registrado exitosamente");
                    setFlag(false);
                }else{ 
                    alert("ha ocurrido un error... : ");
                    console.log(response);
                }
            }else{
                const response =  await login(user.username,user.password);
                setToken(response.data.Token);
                if(response.status === 200){
                    setError(false);
                }else{ 
                    setError(true);
                }
            }
        } catch (error) {
            if(error.response.status === 400){
                if(!flag){
                    setError(true);
                }else{
                    alert(error.response.data)
                }
            }else{
                alert("ha ocurrido un error...");
            }
            
        }
        
    };

    const handleClick = () => {
        setFlag(!flag);
    }

    return (
        // <div>
        //     <h1>{flag ? "Registrarse" : "Login"}</h1>
        //     <form onSubmit={handleSubmit}>
        //         <input placeholder="Usuario" onChange={(e) =>  setUser({...user,username: e.target.value})}/>
        //         <br />
        //         <input placeholder="Contraseña" type="password" onChange={(e) => setUser({...user, password: e.target.value})} />
        //         <br />
        //         <button type="submit">{flag ? "Registrarse" : "Login"}</button>
        //     </form>
        //     <br />
        //     <button onClick={handleClick} id="cambio">{flag ? "Login" : "Registrarse"}</button>
        //     {error && <h1>
        //         Credenciales incorrectas
        //         </h1>
        //          }
            
        // </div>
        <div class="container">
  <h1 class="form-title">{flag ? "Registrarse" : "Login"}</h1>
  <form onSubmit={handleSubmit} class="form">
    <input 
      class="form-input" 
      placeholder="Usuario" 
      onChange={(e) => setUser({ ...user, username: e.target.value })} 
    />
    <input 
      class="form-input" 
      type="password" 
      placeholder="Contraseña" 
      onChange={(e) => setUser({ ...user, password: e.target.value })} 
    />
    <br />
    <button type="submit" class="form-button">{flag ? "Registrarse" : "Login"}</button>
  </form>
  <br />
  <button onClick={handleClick} id="cambio" class="switch-button">
    {flag ? "Login" : "Registrarse"}
  </button>
  {error && (
    <h1 class="error-message">Credenciales incorrectas</h1>
  )}
</div>
    );
}

export default LoginPage