package com.CreativemindFactory.Super_Market.ServerConnect;


import com.CreativemindFactory.Super_Market.Model.Storage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("STORAGEUNIT-SERVER")
public interface Storage_UnitServerConnected {

    @GetMapping("/ViewStorage")
    public ResponseEntity<List<Storage>> viewStorage();

    @PutMapping("/StockModify")
    public ResponseEntity<String> stockModify(@RequestParam String catalog,@RequestParam Integer count);

}
