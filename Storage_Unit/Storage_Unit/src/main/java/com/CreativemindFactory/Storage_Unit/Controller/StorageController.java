package com.CreativemindFactory.Storage_Unit.Controller;

import com.CreativemindFactory.Storage_Unit.Entity.Storage;
import com.CreativemindFactory.Storage_Unit.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StorageController {

    @Autowired
    private StorageService service;

    @PostMapping("/AddStock")
    public ResponseEntity<String> addStock(@RequestParam String catalog){
        return service.addStock(catalog);

    }

    @GetMapping("/ViewStorage")
    public ResponseEntity<List<Storage>> viewStorage(){
       return service.viewStorage();
    }

    @GetMapping("/viewFactoryStock")
    public ResponseEntity<Map<String,List<Integer>>> viewFactoryStock(){
        return service.viewFactoryStock();
    }

    @PutMapping("/StockModify")
    public ResponseEntity<String> stockModify(@RequestParam String catalog,@RequestParam Integer count){
        return service.stockModify(catalog,count);

    }
}
