package com.CreativemindFactory.Factory.Service;

import com.CreativemindFactory.Factory.Entity.Vehicle;
import com.CreativemindFactory.Factory.Repo.VehicleRepository;
import org.antlr.v4.runtime.misc.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository repo;

    public ResponseEntity addVehicle(Vehicle vehicle) {
        if (vehicle.getVehicle_Name() != null && vehicle.getVehicle_Catalog() !=null && vehicle.getVehicle_Price() != null
                                        && vehicle.getVehicle_Model() != null){
            Vehicle added = repo.save(vehicle);
            return new ResponseEntity("Successfully Added", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Please Provide Correct Input Added Failure", HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<List<Vehicle>> fetchVehicle() {
        List<Vehicle> vehicleList=repo.findAll();
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    public ResponseEntity<List<Vehicle>> fetchByCatalog(String catalog) {
          List<Vehicle> vehicleList=repo.findAll().stream().filter(vehicle -> vehicle.getVehicle_Catalog().equals(catalog))
                                       .collect(Collectors.toList());
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }


    public ResponseEntity <Map<String,List<Integer>>> fetchStockMonitor() {
        Map<String,List<Integer>> stock=new HashMap<>();
        Map<String,List<Vehicle>> vehicleList=repo.findAll().stream()
                   .collect(Collectors.groupingBy(Vehicle::getVehicle_Catalog));
               for(Map.Entry item:vehicleList.entrySet()) {
                   List<Vehicle> vehicle = (List<Vehicle>) item.getValue();
                   List<Integer> id = new LinkedList<>();
                   for (Vehicle vehicle1 : vehicle) {
                       id.add(vehicle1.getVehicle_Id());
                       stock.put((String) item.getKey(), id);
                   }
               }

        return new ResponseEntity<>(stock,HttpStatus.OK);
    }

    public ResponseEntity<String> modifyStock(String catalog, Integer count) {
           List<Vehicle> catalogVehicle=fetchByCatalog(catalog).getBody();
                 for(int i=0;i<count;i++){
                     repo.delete(catalogVehicle.get(i));
                 }
           return new ResponseEntity<>("Stock Modified By Storage_Unit",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Vehicle> fetchVehicleDetails(Integer id) {
        Vehicle vehicle=repo.findById(id).get();
        return new ResponseEntity<>(vehicle,HttpStatus.FOUND);
    }
}