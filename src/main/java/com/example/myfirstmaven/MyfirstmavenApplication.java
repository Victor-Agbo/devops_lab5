package com.example.myfirstmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class MyfirstmavenApplication {

	@GetMapping("/")
	    public String hello() {
	        return "Hello from Spring Boot in Docker!";
	    }

	public static void main(String[] args) {
		
		SpringApplication.run(MyfirstmavenApplication.class, args);
		
		
	}

}
