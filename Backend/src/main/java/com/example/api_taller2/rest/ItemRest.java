package com.example.api_taller2.rest;


import com.example.api_taller2.Models.Entity.Item;
import com.example.api_taller2.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/item")
public class ItemRest {
    @Autowired
    private ItemService itemService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/getitems")
    public ResponseEntity<Item[]> getItems(@RequestBody(required = true) Map<String, String> requestMap) {
        try {
            return itemService.findItems(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/newitem")
    public ResponseEntity<String> newItems(@RequestBody(required = true) Map<String, String> requestMap) {
        try {
            return itemService.newItem(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Algo salio mal", HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @PostMapping("/selectitem")
//    public ResponseEntity<Item> selectItem(@RequestBody(required = true) Map<String, String> requestMap) {
//        try {
//            return itemService.outItem(requestMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
