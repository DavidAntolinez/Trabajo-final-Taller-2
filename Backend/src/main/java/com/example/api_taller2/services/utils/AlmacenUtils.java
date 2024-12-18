package com.example.api_taller2.services.utils;

import com.example.api_taller2.Models.Dao.IAlmacenDao;
import com.example.api_taller2.Models.Entity.Almacen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public class AlmacenUtils {

    public static boolean validateNewAlmacenMap(Map<String, String> requestMap){
        return requestMap.containsKey("tamaño");
    }
}
