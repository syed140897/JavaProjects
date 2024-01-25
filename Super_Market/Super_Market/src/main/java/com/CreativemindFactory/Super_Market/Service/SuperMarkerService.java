package com.CreativemindFactory.Super_Market.Service;

import com.CreativemindFactory.Super_Market.Entity.StockCatalog;
import com.CreativemindFactory.Super_Market.Model.Storage;
import com.CreativemindFactory.Super_Market.Model.Vehicle;
import com.CreativemindFactory.Super_Market.Repository.StockCatalogRepository;
import com.CreativemindFactory.Super_Market.ServerConnect.FactoryServerConnected;
import com.CreativemindFactory.Super_Market.ServerConnect.Storage_UnitServerConnected;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperMarkerService {
    @Autowired
    private Storage_UnitServerConnected server;
    @Autowired
    private StockCatalogRepository repo;
    @Autowired
    private FactoryServerConnected factoryServer;
    public ResponseEntity<List<Storage>> storageStock() {
          List<Storage> storageStockModels=server.viewStorage().getBody();
          return new ResponseEntity(storageStockModels,HttpStatus.OK);
    }

    public ResponseEntity<String> addStock(String catalog) {
        List<Storage> storageStockModels=server.viewStorage().getBody();
        StockCatalog stockCatalog=repo.findById(catalog).orElse(new StockCatalog(catalog,0,null));
        for(Storage item:storageStockModels){
            if((item.getCatalog()).equals(catalog)){
                System.out.println("Enter stock  "+item);
                System.out.println("Enter outer Loop "+item.getCount());
                for (int i = 0; i < item.getCount(); i++) {
                    System.out.println("Enter Loop "+item.getCount());
                    System.out.println("Enter stockCatalog Loop "+stockCatalog.getCount());
                    if (stockCatalog.getCount() < 3) {
                        System.out.println("Enter 2 Loop "+stockCatalog.getCount());
                        StockCatalog stock = new StockCatalog();
                        stock.setCatalog(item.getCatalog());
                        stock.setCount(item.getCount());
                        stock.setVehicleId(item.getVehicleID());
                        repo.save(stock);
                        server.stockModify(catalog,1);
                        System.out.println("Successfully");
                    }
                }
            }
        }

        return new ResponseEntity<>("SuccessFully Added Stock",HttpStatus.OK);

    }


    public ResponseEntity<List<StockCatalog>> viewStocks() {
        List<StockCatalog> stockCatalogs=repo.findAll();
        return new ResponseEntity<>(stockCatalogs,HttpStatus.OK);
    }

}
