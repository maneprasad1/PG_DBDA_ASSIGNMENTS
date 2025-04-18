package com.grocery.tester;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

import com.grocery.core.Grocery;
import com.grocery.custom_exception.CustomException;
import com.grocery.items.GroceryListImpl;

public class Tester {

	public static void main(String[] args) throws CustomException {
		try(Scanner sc = new Scanner(System.in)) {
			
		GroceryListImpl gl = new GroceryListImpl();
		HashMap<String, Grocery> groceries = gl.populateData();
		
//		groceries.forEach((k,v) -> System.out.println(v));
		boolean flag = false;
		
		while(!flag) {
			System.out.println("Options - \n1.Add new grocery item"
					+ "\n2.Update quantity of grocery"
					+ "\n3.Display all groceries \n4.Remove empty stocks \n0.Exit" );
			switch (sc.nextInt()) {
			case 1:
				System.out.println("Enter grocery name, price, quantity");
				Grocery g = gl.GroceryList(sc.next(), sc.nextDouble(), sc.nextInt(), LocalDateTime.now());
				if (groceries.containsKey(g.getName())){
					throw new CustomException("name already exists");
				}
				else
					groceries.put(g.getName(), g);
					System.out.println("grocery added");
				break;
			case 2:
				System.out.println("Enter grocery name and quantity");
				gl.UpdateGrocery(sc.next(), sc.nextInt(), groceries);
				break;
			case 3:
				groceries.forEach((k,v) -> System.out.println(v));
				break;
			case 4:
				System.out.println("Removed empty stock items");
				gl.RemoveGrocery(groceries);
				break;
			case 5:
				System.out.println("Show stocks updated in last 3 days");
				gl.QuantityChanged(groceries);
				break;
			case 0:
				flag = true;
				break;
			}
		}
		
		}

}
}
