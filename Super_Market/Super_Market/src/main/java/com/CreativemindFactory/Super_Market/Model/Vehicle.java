package com.CreativemindFactory.Super_Market.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle{

    private Integer vehicle_Id;
    private String vehicle_Name;
    private String vehicle_Catalog;
    private String vehicle_Model;
    private Double vehicle_Price;
}
