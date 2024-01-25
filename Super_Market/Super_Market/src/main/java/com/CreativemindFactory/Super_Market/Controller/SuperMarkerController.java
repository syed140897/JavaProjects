package com.CreativemindFactory.Super_Market.Controller;

import com.CreativemindFactory.Super_Market.Entity.StockCatalog;
import com.CreativemindFactory.Super_Market.Model.Storage;
import com.CreativemindFactory.Super_Market.Model.Vehicle;
import com.CreativemindFactory.Super_Market.Service.SuperMarkerService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SuperMarkerController {
    @Autowired
    private SuperMarkerService service;

    @GetMapping("/StorageStock")
    public ResponseEntity<List<Storage>> storageStock(){
        return service.storageStock();
    }

    @PutMapping("/addStock")
    public ResponseEntity<String> addStock(@RequestParam String catalog){
        return service.addStock(catalog);
    }

    @GetMapping("/ViewStock")
    public ResponseEntity<List<StockCatalog>> viewStock(){
        return service.viewStocks();
    }


}
