package com.sapient.order.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sapient.order.dto.Order;

public class OrderRepositoryPSQL implements IOrderRepository {

	public void save(Order order) {
		try {
	         Class.forName("org.postgresql.Driver");
	         Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sapient","postgres", "root");
	         connection.setAutoCommit(false);

	         Statement stmt = connection.createStatement();
	         String sql = "INSERT INTO postgre (company,location,price) "
	         		+ "VALUES ('" + order.getCompany() + "','" + order.getLocation() + "'," + order.getPrice() + ");";
	         stmt.executeUpdate(sql);

	         stmt.close();
	         connection.commit();
	         connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
