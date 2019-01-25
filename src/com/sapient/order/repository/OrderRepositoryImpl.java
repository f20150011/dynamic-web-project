package com.sapient.order.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.x.protobuf.MysqlxCrud.OrderOrBuilder;
import com.sapient.order.dto.Order;

public class OrderRepositoryImpl implements IOrderRepository{

	public void save(Order order) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://10.150.222.33:3306/shriram","root","root");
			Statement statement=connection.createStatement();  
			String command = "insert into shriram.servlet (company, location, price) values ('" + order.getCompany() + "','" + order.getLocation() + "','" + order.getPrice() +"');";
			System.out.println(command);
			statement.execute(command);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}
