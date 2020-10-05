package sk.po.spse.beachclubapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "sk.po.spse.beachclubapp.controller, sk.po.spse.beachclubapp.service, sk.po.spse.beachclubapp.web.controller")
@SpringBootApplication
public class BeachclubappApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BeachclubappApplication.class, args);
	
	}

}
