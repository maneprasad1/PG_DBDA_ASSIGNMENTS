package com.grocery.items;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.grocery.items.GroceryValidations.*;
import com.grocery.core.Grocery;
import com.grocery.custom_exception.CustomException;

public class GroceryListImpl implements GroceryItems {
	public HashMap<String, Grocery> populateData() throws CustomException {
		HashMap<String, Grocery> map= new HashMap<>();
		//String name, double price, int quantity, LocalDateTime datetime
		map.put("apple", GroceryList("apple", 220.0,6, LocalDateTime.now().minusDays(5) ));
		map.put("milk", GroceryList("milk", 50.0,1,LocalDateTime.now()));
		map.put("bread", GroceryList("bread", 200.0,10,LocalDateTime.now()));
		map.put("eggs", GroceryList("eggs", 100.0,12,LocalDateTime.now()));
		return map;
		
	}
	@Override
	public Grocery GroceryList(String name, double price, int quantity, LocalDateTime datetime)
			throws CustomException{
		
		validatePrice(price);
		validateQuantity(quantity);
		return new Grocery(name,price,quantity,datetime);
	}
	@Override
	public Grocery finder(String name, HashMap<String, Grocery> map) throws CustomException {
		Grocery g = map. get(name);
		if(g == null)
			throw new CustomException("Grocery item not in list");
		return g;
	}
	@Override
	public String UpdateGrocery(String name, int quantity, HashMap<String, Grocery> map)
			throws CustomException {
		Grocery g = finder(name, map);
		g.setQuantity(quantity);
		g.setDatetime(LocalDateTime.now());
		return "Quantity updated";
	}
	public void RemoveGrocery(HashMap<String, Grocery> map) {
		//revise
		map.values().removeIf(key -> key.getQuantity() <= 0);

	}
	@Override
	public void QuantityChanged(HashMap<String, Grocery> map) {
		
		map.values().stream().filter(d -> d.getDatetime().isAfter(LocalDateTime.now().minusDays(3)))
		.forEach(m -> System.out.println(m));
	}
	
}
