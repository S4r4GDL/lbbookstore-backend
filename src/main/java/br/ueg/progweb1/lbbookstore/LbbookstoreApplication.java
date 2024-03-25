package br.ueg.progweb1.lbbookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class LbbookstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(LbbookstoreApplication.class, args);
	}

}
