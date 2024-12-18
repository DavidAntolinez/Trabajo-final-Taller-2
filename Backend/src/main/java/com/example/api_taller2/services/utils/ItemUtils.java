package com.example.api_taller2.services.utils;

import java.util.Map;

public class ItemUtils {
    public static boolean validateNewItemnMap(Map<String, String> requestMap){
        return requestMap.containsKey("nombre") && requestMap.containsKey("descripcion");
    }

    public static boolean validateOutItemnMap(Map<String, String> requestMap){
        return requestMap.containsKey("almacenId") && requestMap.containsKey("itemId");
    }
}
