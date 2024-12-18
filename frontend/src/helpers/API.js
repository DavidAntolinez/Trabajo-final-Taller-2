import axios from "axios";

const API_URL = "http://localhost:8080/api";

// Usuario
    const USER_URL = "/usuario"
    export const signUp = (user,passw) => axios.put(API_URL+USER_URL+"/signup",{username: user,password: passw});
    export const login = (user,passw) => axios.post(API_URL+USER_URL+"/login",{username: user,password: passw});

//Almacenes
    const ALM_URL = "/almacen"
    export const getAlmacenes = (Token) => axios.post(API_URL+ALM_URL+"/getalmacenes",{token: Token});
    export const putAlmacenes = (Token,Tamaño) => axios.put(API_URL+ALM_URL+"/newalmacen",{token: Token,tamaño: Tamaño});

//Items
    const ITM_URL = "/item"
    export const getItems = (Token,Id) => axios.post(API_URL+ITM_URL+"/getitems",{token: Token,id: Id});
    export const putItem = (Token,Id,Nombre,Descripcion) => axios.put(API_URL+ITM_URL+"/newitem",{token: Token,id: Id,nombre: Nombre,descripcion: Descripcion});

//Historial
    const HST_URL = "/historial"
    export const getHistorial = (Token) => axios.post(API_URL+HST_URL+"/gethistorial",{token: Token});
    export const newHistorial = (Token,ItemId,AlmcOrigId,AlmcDesId) => axios.put(API_URL+HST_URL+"/newhistorial",{token: Token,almacenOrigenId: AlmcOrigId,almacenDestinoId: AlmcDesId,itemId: ItemId});


