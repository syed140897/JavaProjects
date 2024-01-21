package com.CreativemindFactory.Storage_Unit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class StorageUnitApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageUnitApplication.class, args);
	}

}
