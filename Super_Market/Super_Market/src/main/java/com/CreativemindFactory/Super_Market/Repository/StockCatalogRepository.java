package com.CreativemindFactory.Super_Market.Repository;

import com.CreativemindFactory.Super_Market.Entity.StockCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockCatalogRepository extends JpaRepository<StockCatalog,String> {
}
