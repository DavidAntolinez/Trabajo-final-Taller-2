package com.example.api_taller2.services;

import com.example.api_taller2.Models.Dao.IAlmacenDao;
import com.example.api_taller2.Models.Dao.IHistorialTransferenciasDao;
import com.example.api_taller2.Models.Dao.IItemDao;
import com.example.api_taller2.Models.Dao.IUsuarioDao;
import com.example.api_taller2.Models.Entity.Almacen;
import com.example.api_taller2.Models.Entity.HistorialTransferencias;
import com.example.api_taller2.Models.Entity.Item;
import com.example.api_taller2.Models.Entity.Usuario;
import com.example.api_taller2.services.utils.HistorialUtils;
import com.example.api_taller2.services.utils.ItemUtils;
import com.example.api_taller2.services.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HistorialService {
    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private IHistorialTransferenciasDao historialTransferenciasDao;

    @Autowired
    private IItemDao itemDao;

    @Autowired
    private IAlmacenDao almacenDao;

    public ResponseEntity<HistorialTransferencias[]> findHistorial(Map<String, String> requestMap) {
        try{
            if(JwtUtils.validateTokenMap(requestMap)){
                Usuario usuario = usuarioDao.findByUsername(JwtUtils.extractUsername(requestMap.get("token")));
                if(usuario != null){
                    if(JwtUtils.validateToken(requestMap.get("token"),usuario)){
                        List<HistorialTransferencias> historialTransferenciasList = historialTransferenciasDao.findAll();
                        ArrayList<HistorialTransferencias> userHistorial = new ArrayList<>();
                        for(HistorialTransferencias Historial : historialTransferenciasList){
                            if(Historial.getUsuarioId() == usuario.getId()){
                                userHistorial.add(Historial);
                            }
                        }
                        return new ResponseEntity<>(userHistorial.toArray(new HistorialTransferencias[0]), HttpStatus.OK);
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

    public ResponseEntity<String> newHistorial(Map<String, String> requestMap) {
        try{
            if(JwtUtils.validateTokenMap(requestMap) && HistorialUtils.validatenewHistorialMap(requestMap)){
                Usuario usuario = usuarioDao.findByUsername(JwtUtils.extractUsername(requestMap.get("token")));
                Almacen almacenOrigen = almacenDao.findOne(Long.parseLong(requestMap.get("almacenOrigenId")));
                Almacen almacenDestino = almacenDao.findOne(Long.parseLong(requestMap.get("almacenDestinoId")));
                Item item = itemDao.findOne(Long.parseLong(requestMap.get("itemId")));
                if(usuario != null && almacenOrigen != null && item != null && almacenDestino != null) {
                    if(JwtUtils.validateToken(requestMap.get("token"),usuario)){
                        if(almacenOrigen.getId() == item.getAlmacenId()){
                            if(almacenDestino.getCapacidadTotal() > almacenDestino.getItemsAlmacenados()){
                                almacenOrigen.setItemsAlmacenados(almacenOrigen.getItemsAlmacenados() - 1);
                                almacenDao.Save(almacenOrigen);
                                almacenDestino.setItemsAlmacenados(almacenDestino.getItemsAlmacenados() + 1);
                                almacenDao.Save(almacenDestino);
                                item.setAlmacenId(almacenDestino.getId());
                                itemDao.Save(item);
                                HistorialTransferencias historialTransferencias = new HistorialTransferencias();
                                historialTransferencias.setUsuarioId(usuario.getId());
                                historialTransferencias.setAlmacenOrigenId(almacenOrigen.getId());
                                historialTransferencias.setItemId(item.getId());
                                historialTransferencias.setAlmacenDestinoId(almacenDestino.getId());
                                historialTransferenciasDao.Save(historialTransferencias);
                                String body = "Se ha transferido el item con exito";
                                return new ResponseEntity<>(body, HttpStatus.OK);
                            }
                            return new ResponseEntity<>("El almacen destino no tiene suficiente espacio", HttpStatus.ACCEPTED);
                        }
                        return new ResponseEntity<>("El item no se encuentra en este almacen", HttpStatus.ACCEPTED);
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
