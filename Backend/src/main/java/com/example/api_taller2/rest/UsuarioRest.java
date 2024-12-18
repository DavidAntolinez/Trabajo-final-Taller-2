package com.example.api_taller2.rest;

import com.example.api_taller2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/usuario")
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/signup")
    public ResponseEntity<String> registrarUsuario(@RequestBody(required = true) Map<String, String> requestMap) {
        try {
            return usuarioService.signUp(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Algo salio mal", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody(required = true) Map<String, String> requestMap) {
        try {
            return usuarioService.login(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Algo salio mal", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
