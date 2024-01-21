package com.CreativemindFactory.Storage_Unit.Service;

import com.CreativemindFactory.Storage_Unit.Entity.Storage;
import com.CreativemindFactory.Storage_Unit.Repository.StorageRepository;
import com.CreativemindFactory.Storage_Unit.ServereConnect.FactoryConnectServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class StorageService {
    String status;

    HttpStatus httpStatus;
    @Autowired
    private StorageRepository repo;

    @Autowired
    private FactoryConnectServer server;

    public ResponseEntity<String>addStock(String catalog) {
        Storage storage=repo.findById(catalog).orElse(new Storage(catalog,0,null));
        Map<String,List<Integer>> stockList=viewFactoryStock().getBody();
        List<Integer> stockCount=stockList.get(catalog);
        List<Integer>  vehicleId=new LinkedList<>();
        if(catalog.equals("Bike") || catalog.equals("Car") || catalog.equals("Truck")){
            if(storage.getCount()<5){
                for(int i=1;i<=stockCount.size();i++){
                    int j=1;
                      if(((storage.getCount())+j)<=5){
                          vehicleId.add(stockCount.get(i-1));
                          storage.setCatalog(catalog);
                          storage.setCount((storage.getCount())+1);
                          storage.setVehicleID(vehicleId);
                          repo.save(storage);
                          server.modifyStock(catalog,1);
                          status=i+" "+catalog+" Stock Added SuccessFully";
                          httpStatus=HttpStatus.CREATED;
                      }
                }
            }else{
                status=catalog+" Storage Full so return stock";
                httpStatus=HttpStatus.INSUFFICIENT_STORAGE;
            }
        }else{
            status=catalog+" does not Added Because This Storage Unit Only Store Vehicle like Bike,Car,Truck";
        }

        return new ResponseEntity<>(status,httpStatus);
    }
    public ResponseEntity<List<Storage>> viewStorage() {
       List<Storage> storageList= repo.findAll();
       return new ResponseEntity(storageList, HttpStatus.OK);
    }

    public ResponseEntity<Map<String,List<Integer>>> viewFactoryStock() {
        Map<String,List<Integer>> stock=server.fetchStockMonitor().getBody();
        return new ResponseEntity(stock,HttpStatus.FOUND);
    }


    public ResponseEntity<String> stockModify(String catalog, Integer count) {
        List<Storage> storageList= repo.findById(catalog).stream().toList();
        for(int i=0;i<count;i++){
            repo.delete(storageList.get(i));
        }
        return new ResponseEntity<>("Modified Stock",HttpStatus.ACCEPTED);
    }
}
