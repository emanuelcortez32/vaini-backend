package ar.com.vaini.vainibackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class VainiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VainiBackendApplication.class, args);
	}

}
