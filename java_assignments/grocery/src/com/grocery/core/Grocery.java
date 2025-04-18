package com.grocery.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Grocery {
	private String name;
	private double price;
	private int quantity;
	private LocalDateTime datetime;
	
	public Grocery(String name, double price, int quantity, LocalDateTime datetime) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.datetime = datetime;
	}

	@Override
	public String toString() {
		return "Grocery [name=" + name + ", price=" + price + ", quantity=" + quantity + ", datetime=" + datetime + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	
	
}
