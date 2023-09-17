package br.com.criarTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.criarTime")
public class CriarTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriarTimeApplication.class, args);
	}

}
