package sk.po.spse.beachclubapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import sk.po.spse.beachclubapp.entity.Pair;

import java.util.ArrayList;
import java.util.List;


@ComponentScan(basePackages = "sk.po.spse.beachclubapp.controller, sk.po.spse.beachclubapp.service, sk.po.spse.beachclubapp.web.controller")
@Configuration
@SpringBootApplication
public class BeachclubappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeachclubappApplication.class, args);
		List<Pair> pairs = new ArrayList<>();
		pairs.add(new Pair());
		pairs.add(new Pair());
		System.out.println("Starting excelService...");
		inputListInExcel(pairs, "PresovBeachvolleyCup");
		System.out.println("Ending excelService...");

	}

	public static void inputListInExcel(List<Pair> pairs, String tournamentName) {
		//work here!
	}

}
