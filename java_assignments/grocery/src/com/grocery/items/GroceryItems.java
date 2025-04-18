package com.grocery.items;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.grocery.core.Grocery;
import com.grocery.custom_exception.CustomException;

public interface GroceryItems {
	
	Grocery GroceryList(String name, double price, int quantity, LocalDateTime datetime)
			throws CustomException;
	Grocery finder(String name, HashMap<String, Grocery> map) throws CustomException;
	String UpdateGrocery(String name, int quantity, HashMap<String, Grocery> map) throws CustomException;
	void RemoveGrocery(HashMap<String, Grocery> map);
	void QuantityChanged(HashMap<String, Grocery> map);
}
