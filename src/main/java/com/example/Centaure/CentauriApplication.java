package com.example.Centaure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;

@SpringBootApplication
<<<<<<< HEAD:src/main/java/com/example/Centaure/CentaureApplication.java
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class})
public class CentaureApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentaureApplication.class, args);

		System.out.println("Vencemos, o código pegou, papai");
=======
public class CentauriApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentauriApplication.class, args);
>>>>>>> 1e8d1abe0068e185339b60e486562d44b635b11b:src/main/java/com/example/Centaure/CentauriApplication.java
	}

}
