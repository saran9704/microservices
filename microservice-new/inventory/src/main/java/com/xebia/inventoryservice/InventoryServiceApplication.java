package com.xebia.inventoryservice;

import com.xebia.inventoryservice.model.Inventory;
import com.xebia.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
//		return args -> {
//
//			Inventory inventory=new Inventory();
//			inventory.setSkuCode("IPhone_11");
//			inventory.setQuantity(50);
//
//			Inventory inventory1=new Inventory();
//			inventory1.setSkuCode("IPhone_12");
//			inventory1.setQuantity(20);
//
//			inventoryRepository.save(inventory);
//			inventoryRepository.save(inventory1);
//
//		};
//	}
}
