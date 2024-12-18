package com.example.api_taller2.rest;

import com.example.api_taller2.Models.Entity.Almacen;
import com.example.api_taller2.services.AlmacenService;
import com.example.api_taller2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/almacen")
public class AlmacenRest {

    @Autowired
    private AlmacenService almacenService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("getalmacenes")
    public ResponseEntity<Almacen[]> getAlmacenes(@RequestBody(required = true) Map<String, String> requestMap) {
        try {
            return almacenService.findAlmacenes(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("newalmacen")
    public ResponseEntity<String> newAlmacen(@RequestBody(required = true) Map<String, String> requestMap) {
        try {
            return almacenService.newAlmacen(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Algo salio mal", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
