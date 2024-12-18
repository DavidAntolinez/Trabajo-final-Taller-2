package com.example.api_taller2.services;

import com.example.api_taller2.Models.Dao.IAlmacenDao;
import com.example.api_taller2.Models.Dao.IItemDao;
import com.example.api_taller2.Models.Dao.IUsuarioDao;
import com.example.api_taller2.Models.Entity.Almacen;
import com.example.api_taller2.Models.Entity.Item;
import com.example.api_taller2.Models.Entity.Usuario;
import com.example.api_taller2.services.utils.ItemUtils;
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
public class ItemService {
    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private IItemDao itemDao;

    @Autowired
    private IAlmacenDao almacenDao;

    public ResponseEntity<Item[]> findItems(Map<String, String> requestMap) {
        try{
            if(JwtUtils.validateTokenMap(requestMap) && JwtUtils.validateIdMap(requestMap)){
                Usuario usuario = usuarioDao.findByUsername(JwtUtils.extractUsername(requestMap.get("token")));
                if(usuario != null) {
                    if (JwtUtils.validateToken(requestMap.get("token"), usuario)) {
                        Long id = Long.parseLong(requestMap.get("id"));
                        if(!(Objects.equals(usuario.getId(), almacenDao.findOne(id).getUsuarioId()))) {
                            System.out.println("es aqui");
                            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
                        }else{
                            List<Item> items = itemDao.findAll();
                            ArrayList<Item> userItems = new ArrayList<>();
                            for (Item item : items) {
                                if (item.getAlmacenId() == id) {
                                    userItems.add(item);
                                }
                            }
                            return new ResponseEntity<>(userItems.toArray(new Item[0]), HttpStatus.OK);
                        }
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

    public ResponseEntity<String> newItem(Map<String, String> requestMap) {
        try{
            if(JwtUtils.validateTokenMap(requestMap) && JwtUtils.validateIdMap(requestMap) && ItemUtils.validateNewItemnMap(requestMap)){
                Usuario usuario = usuarioDao.findByUsername(JwtUtils.extractUsername(requestMap.get("token")));
                Almacen almacen = almacenDao.findOne(Long.parseLong(requestMap.get("id")));
                if(usuario != null && almacen != null) {
                    if(JwtUtils.validateToken(requestMap.get("token"),usuario)){
                        if(almacen.getItemsAlmacenados() < almacen.getCapacidadTotal()){
                            almacen.setItemsAlmacenados(almacen.getItemsAlmacenados() + 1);
                            almacenDao.Save(almacen);
                            Item item = new Item(requestMap.get("nombre"),requestMap.get("descripcion"),Long.parseLong(requestMap.get("id")));
                            itemDao.Save(item);
                            String body = "Nuevo item agregado";
                            return new ResponseEntity<>(body, HttpStatus.OK);
                        }
                        return new ResponseEntity<>("No se pueden agregar mas items al almacen", HttpStatus.ACCEPTED);
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

//    public ResponseEntity<Item> outItem(Map<String, String> requestMap) {
//        try{
//            if(JwtUtils.validateTokenMap(requestMap) && ItemUtils.validateOutItemnMap(requestMap)){
//                Usuario usuario = usuarioDao.findByUsername(JwtUtils.extractUsername(requestMap.get("token")));
//                Almacen almacen = almacenDao.findOne(Long.parseLong(requestMap.get("almacenId")));
//                Item item = itemDao.findOne(Long.parseLong(requestMap.get("itemId")));
//                if(usuario != null && almacen != null && item != null) {
//                    if(JwtUtils.validateToken(requestMap.get("token"),usuario)){
//                        if(almacen.getId() == item.getAlmacenId()){
//                            return new ResponseEntity<>(item, HttpStatus.OK);
//                        }
//                        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
//                    }
//                }
//                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//
//            }else {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//            }
//        }catch (Exception e){
//            if(e.getMessage().equals("Invalid JWT signature")){
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//            }
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//    }
}
