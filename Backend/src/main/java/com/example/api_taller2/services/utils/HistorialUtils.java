package com.example.api_taller2.services.utils;

import java.util.Map;

public class HistorialUtils {
    public static boolean validatenewHistorialMap(Map<String, String> requestMap){
        return requestMap.containsKey("almacenOrigenId") && requestMap.containsKey("almacenDestinoId") && requestMap.containsKey("itemId");
    }
}
