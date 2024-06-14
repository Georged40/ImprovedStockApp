package com.AsandeWeb.TestApp;

import com.AsandeWeb.TestApp.model.Stock_Item;;
import com.AsandeWeb.TestApp.repository.stockItemRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication
public class Application {

	static Connection connection = null;
	//static String databaseName = "storeroom";
	static String url = "jdbc:mysql://localhost:3306/storesdb";
	static String username = "root";
	static String password = "Owe22Phila20";

	public Application() throws SQLException {
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		System.setProperty("server.servlet.context-path", "/api/storeroom");

		SpringApplication.run(Application.class, args);
	}
/*
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/stockItems").allowedOrigins("*");
			}
		};
	}
/*
	@Bean
	CommandLineRunner run(stockItemRepo stockItemRepo) {
		return args -> {
			stockItemRepo.save(new Stock_Item(null, "Butter", "KG",
					15, 20.50, 355.00, 20, 5, LocalDateTime.now(), null));
			stockItemRepo.save(new Stock_Item(null, "Beef Cubes", "KG",
					20, 120.50, 2520.00, 50, 30, LocalDateTime.now(), null));
			stockItemRepo.save(new Stock_Item(null, "Rice", "KG",
					10, 20.50, 250.00, 30, 20, LocalDateTime.now(), null));
			stockItemRepo.save(new Stock_Item(null, "Oil", "KG",
					20, 35, 700.00, 40, 20, LocalDateTime.now(), null));
			stockItemRepo.save(new Stock_Item(null, "Tomatoes", "KG",
					40, 10.00, 400.00, 60, 20, LocalDateTime.now(), null));

		};

	}
*/




}

	/*
	* DataSource dataSource = DataSourceBuilder.create()
    .driverClassName(driver-class-name)
    .url(env.getProperty(dataSoruceUrl).build();
	Connection connection = dataSource.getConnection(username, password);
	*
	*
	* */
	/*
	public static void upDateDatabase() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {

	/*	//itemNumberPassed = (int) Double.parseDouble(itemNumberField.getText());
	//	receivedQty = Double.parseDouble(itemQtyField.getText());
		int receivedQty = 100;
		int itemNumberPassed = 2;

		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		connection = DriverManager.getConnection(url, username, password);
		Statement stmt = connection.createStatement();

		//String updateStatement = String.format("UPDATE stockitem set qty = qty+%f WHERE itemNumber = %d", receivedQty, itemNumberPassed);
		String updateStatement = String.format("UPDATE stock_item set qty = qty+40 WHERE id = 2");
		System.out.println(updateStatement);
		int updatedResultSet = stmt.executeUpdate(updateStatement);
		System.out.println(updatedResultSet + "lines were updated");

		String mySelectStatement = String.format("SELECT qty FROM stock_item WHERE 'id' = %d", itemNumberPassed);
		ResultSet resultSet = stmt.executeQuery(mySelectStatement);


		}
	}*/







