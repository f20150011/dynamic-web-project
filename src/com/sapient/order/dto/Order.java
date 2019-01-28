package com.sapient.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

	private int id;
	private String company;
	private String location;
	private Float price;
	
}
