package com.example.api_taller2.rest;

import com.example.api_taller2.Models.Entity.HistorialTransferencias;
import com.example.api_taller2.services.HistorialService;
import com.example.api_taller2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/historial")
public class HistorialRest {
    @Autowired
    private HistorialService historialService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/gethistorial")
    public ResponseEntity<HistorialTransferencias[]> getHistorial(@RequestBody(required = true) Map<String, String> requestMap) {
        try {
            return historialService.findHistorial(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/newhistorial")
    public ResponseEntity<String> newHistorial(@RequestBody(required = true) Map<String, String> requestMap) {
        try {
            return historialService.newHistorial(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Algo salio mal", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
