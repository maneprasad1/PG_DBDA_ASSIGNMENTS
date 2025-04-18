package com.grocery.items;

import com.grocery.custom_exception.CustomException;

public class GroceryValidations {
	public static void validatePrice(double price) throws CustomException {
		if(price <= 0){
			throw new CustomException("Price must be above 0 !!!");
		}
	}
	
	public static void validateQuantity(double quantity) throws CustomException {
		if(quantity <= 0){
			throw new CustomException("Quantity must be above 0 !!!");
		}
	}
}
