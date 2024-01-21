package com.CreativemindFactory.Super_Market.ServerConnect;

import com.CreativemindFactory.Super_Market.Model.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("FACTORY-SERVER")
public interface FactoryServerConnected {

    @GetMapping("/Factory/FetchVehicle/{id}")
    public ResponseEntity<Vehicle> fetchVehicle(@PathVariable Integer id);

}
