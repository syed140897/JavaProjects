package com.CreativemindFactory.Super_Market.ServerConnect;

import com.CreativemindFactory.Super_Market.Model.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "FACTORY-SERVER",path = "/factory-api/api")
public interface FactoryServerConnected {

    @GetMapping("/Factory/FetchVehicle/{id}")
    public ResponseEntity<Vehicle> fetchVehicle(@PathVariable Integer id);

    @GetMapping("/Factory/FetchVehicle")
    public ResponseEntity<List<Vehicle>> fetchVehicle();

}
