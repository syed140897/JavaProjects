package com.CreativemindFactory.Storage_Unit.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Storage {

    @Id
    private String catalog;
    private Integer count;
    private List<Integer> vehicleID;

}
