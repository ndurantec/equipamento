package com.castelo.equipamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/* 
@SpringBootApplication
*/

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EquipamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipamentoApplication.class, args);
	}

}