package com.CreativemindFactory.Super_Market.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private String catalog;
    private Integer count;
    private List<Integer> vehicleID;
}
