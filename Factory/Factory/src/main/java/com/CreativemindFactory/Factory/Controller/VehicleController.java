package com.CreativemindFactory.Factory.Controller;

import com.CreativemindFactory.Factory.Entity.Vehicle;
import com.CreativemindFactory.Factory.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Factory")
public class VehicleController {
    @Autowired
     VehicleService service;

    @PostMapping("/AddVehicle")
    public ResponseEntity addVehicle(@RequestBody Vehicle vehicle){
        return service.addVehicle(vehicle);
    }

    @GetMapping("/FetchVehicle")
    public ResponseEntity<List<Vehicle>> fetchVehicle(){
        return service.fetchVehicle();
    }

    @GetMapping("/FetchVehicle/{id}")
    public ResponseEntity<Vehicle> fetchVehicle(@PathVariable Integer id){
        return service.fetchVehicleDetails(id);
    }

    @GetMapping("/FetchByCatalog/{catalog}")
    public ResponseEntity<List<Vehicle>> fetchByCatalog(@PathVariable(value = "catalog") String catalog){
        return service.fetchByCatalog(catalog);
    }

    @GetMapping("/FetchStock")
    public ResponseEntity <Map<String,List<Integer>>> fetchStockMonitor(){
        return service.fetchStockMonitor();
    }

    @PutMapping("/ModifyStock")
    public ResponseEntity<String> modifyStock(@RequestParam String catalog,@RequestParam Integer count){
        return service.modifyStock(catalog,count);
    }
}
