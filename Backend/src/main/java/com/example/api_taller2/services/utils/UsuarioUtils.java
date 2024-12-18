package com.example.api_taller2.services.utils;

import com.example.api_taller2.Models.Entity.Almacen;
import com.example.api_taller2.Models.Entity.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsuarioUtils {
    public static Usuario getUsuarioFromMap(Map<String, String> requestMap) {
        Usuario usuario = new Usuario();
        usuario.setUsername(requestMap.get("username"));
        usuario.setPassword(requestMap.get("password"));
        return usuario;
    }

    public static boolean validateSignUpMapUser(Map<String, String> requestMap) {
        return requestMap.containsKey("username") && requestMap.containsKey("password");
    }




}
