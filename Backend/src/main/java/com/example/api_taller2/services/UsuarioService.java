package com.example.api_taller2.services;

import com.example.api_taller2.Models.Dao.IAlmacenDao;
import com.example.api_taller2.Models.Dao.IHistorialTransferenciasDao;
import com.example.api_taller2.Models.Dao.IItemDao;
import com.example.api_taller2.Models.Dao.IUsuarioDao;
import com.example.api_taller2.Models.Entity.Almacen;
import com.example.api_taller2.Models.Entity.HistorialTransferencias;
import com.example.api_taller2.Models.Entity.Item;
import com.example.api_taller2.Models.Entity.Usuario;
import com.example.api_taller2.services.utils.JwtUtils;
import com.example.api_taller2.services.utils.UsuarioUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.example.api_taller2.services.utils.UsuarioUtils.*;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    private IUsuarioDao usuarioDao;





    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Intentado registrar el usuario {}",requestMap);
        try{
            if(validateSignUpMapUser(requestMap)){
                Usuario usuario = usuarioDao.findByUsername(requestMap.get("username"));
                if(Objects.isNull(usuario)){
                    usuarioDao.Save(getUsuarioFromMap(requestMap));
                    return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente");
                }else{
                    return new ResponseEntity<String>("Este usuario ya existe", HttpStatus.BAD_REQUEST);
                }
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en campos");
            }
        }catch (Exception e){
            if(e.getMessage().equals("Invalid JWT signature")){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Algo salio mal");
    }

    public ResponseEntity<String> login(Map<String, String> requestMap) {
        log.info("Dentro del login");
        try{
            if(validateSignUpMapUser(requestMap)){
                Usuario usuario = usuarioDao.findByUsername(requestMap.get("username"));
                Usuario usuario1 = getUsuarioFromMap(requestMap);
                if(Objects.isNull(usuario)){
                    return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.BAD_REQUEST);
                }else{
                    if(usuario.getPassword().equals(usuario1.getPassword())){
                        JwtUtils jwtUtils = new JwtUtils();
                        return new ResponseEntity<String>("{\"Token\":\""+jwtUtils.generateToken(usuario.getUsername(),usuario.getPassword())+"\"}", HttpStatus.OK);
                    }
                    return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.BAD_REQUEST);
                }
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en campos");
            }
        }catch (Exception e){
            if(e.getMessage().equals("Invalid JWT signature")){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Algo salio mal");
    }






}
