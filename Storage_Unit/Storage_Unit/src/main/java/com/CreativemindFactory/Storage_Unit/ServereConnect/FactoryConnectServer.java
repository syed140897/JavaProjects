package com.CreativemindFactory.Storage_Unit.ServereConnect;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@FeignClient("FACTORY-SERVER")
public interface FactoryConnectServer {

    @GetMapping("Factory/FetchStock")
    public ResponseEntity<Map<String,List<Integer>>> fetchStockMonitor();

    @PutMapping("Factory/ModifyStock")
    public ResponseEntity<String> modifyStock(@RequestParam  String catalog,@RequestParam Integer count);
}
