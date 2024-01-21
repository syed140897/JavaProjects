package com.CreativemindFactory.Factory.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer vehicle_Id;
    private String vehicle_Name;
    private String vehicle_Catalog;
    private String vehicle_Model;
    private Double vehicle_Price;

}
