package com.scaler.EcomProductService;

import com.scaler.EcomProductService.service.InitServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomProductServiceApplication implements CommandLineRunner {

	InitServiceImpl initService;

	@Autowired
	public EcomProductServiceApplication(InitServiceImpl initService) {
		this.initService = initService;
	}

	public static void main(String[] args) {
		SpringApplication.run(EcomProductServiceApplication.class, args);
	}

	public void run(String[] args) throws Exception
	{
		initService.initialize();
	}
}
