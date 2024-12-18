package com.example.api_taller2.services;

import com.example.api_taller2.Models.Dao.IAlmacenDao;
import com.example.api_taller2.Models.Dao.IUsuarioDao;
import com.example.api_taller2.Models.Entity.Almacen;
import com.example.api_taller2.Models.Entity.Usuario;
import com.example.api_taller2.services.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class AlmacenService {
    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private IAlmacenDao almacenDao;

    public ResponseEntity<Almacen[]> findAlmacenes(Map<String, String> requestMap) {
        try{
            if(JwtUtils.validateTokenMap(requestMap)){
                Usuario usuario = usuarioDao.findByUsername(JwtUtils.extractUsername(requestMap.get("token")));
                if(usuario != null){
                    if(JwtUtils.validateToken(requestMap.get("token"),usuario)){
                        List<Almacen> almacenes = almacenDao.findAll();
                        ArrayList<Almacen> userAlmacenes = new ArrayList<>();
                        for(Almacen almacen : almacenes){
                            if(Objects.equals(almacen.getUsuarioId(), usuario.getId())){
                                userAlmacenes.add(almacen);
                            }
                        }
                        return new ResponseEntity<>(userAlmacenes.toArray(new Almacen[0]), HttpStatus.OK);

                    }
                }
                    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }catch (Exception e){
            if(e.getMessage().equals("Invalid JWT signature")){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    public ResponseEntity<String> newAlmacen(Map<String, String> requestMap) {
        try{
            if(JwtUtils.validateTokenMap(requestMap)){
                Usuario usuario = usuarioDao.findByUsername(JwtUtils.extractUsername(requestMap.get("token")));
                if(usuario != null){
                    if(JwtUtils.validateToken(requestMap.get("token"),usuario)){
                        int capacidad = Integer.parseInt(requestMap.get("tamaño"));
                        Almacen almacen = new Almacen(capacidad,usuario.getId());
                        almacenDao.Save(almacen);
                        String body = "Nuevo almacen agregado";
                        return new ResponseEntity<>(body, HttpStatus.OK);
                    }
                }
                return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.BAD_REQUEST);

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
