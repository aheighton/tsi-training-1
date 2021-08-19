package com.example.inheritance;

import java.util.List;

public class NewUserRun
{
	public static void main(String[] args)
	{
		createUserWithUsername("Gareth","gdavis");
		createGuest();
	}


	public static void createUserWithUsername(String name, String username)
	{
		User self = new User(name, username);
		System.out.println("Good morning, "+self.getName()+". ("+self.getUsername()+")");
		List<Item> stock = OwnerRun.generateItems();

		if (self.getCart().addItem(stock.get(0),1))
		{
			System.out.println(stock.get(0).getName()+" added to cart.");
		}

		if (self.getCart().addItem(stock.get(1),5))
		{
			System.out.println(stock.get(1).getName()+" added to cart.");
		}

		if (self.getCart().removeItem(stock.get(0)))
		{
			System.out.println(stock.get(0).getName()+" removed to cart.");
		}
		System.out.println("\n");
		System.out.println(self.getCart().getUser().getName()+" is checking out with:");
		System.out.println(self.getCart().displayCart());

		self.checkout();
	}

	public static void createGuest()
	{
		User self = new User();
		System.out.println("Good morning, "+self.getName()+".");
	}
}
