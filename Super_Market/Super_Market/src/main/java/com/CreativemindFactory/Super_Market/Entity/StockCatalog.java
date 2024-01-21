package com.CreativemindFactory.Super_Market.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockCatalog {

    @Id
    private String catalog;
    private Integer count;
    private List<Integer> vehicleId;
}
