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

	 // CommandLineRunner Interface has a run method. Interface used to indicate that a bean should run when it is contained within a SpringApplication.
	 // Multiple CommandLineRunner beans can be defined within the same application context and can be ordered using the Ordered interface or @Order annotation.
	 // If you need access to ApplicationArguments instead of the raw String array consider using ApplicationRunner.
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
