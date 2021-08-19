package com.example.inheritance;

import java.util.*;

public class Cart
{
	private User user;
	private List<Item> contents;

	public Cart(User user)
	{
		setUser(user);
		emptyCart();
	}

	public Cart()
	{
		setUser(new User());
		emptyCart();
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public List<Item> getContents()
	{
		return contents;
	}

	public void setContents(List<Item> contents)
	{
		this.contents = contents;
	}

	public void emptyCart()
	{
		this.contents = new LinkedList<>();
	}

	public int getTotalPrice()
	{
		int totPrice = 0;
		for (Item item: getContents())
		{
			totPrice += item.getOfferPrice(getContents());
		}

		return totPrice;
	}

	public String displayCart()
	{
		String fullDetails = "";

		for (Item item: getContents())
		{
			fullDetails += item.getName()
						+ " ("
						+ item.getId()
						+ "):"
						+ item.getDescription()
						+ "\n";
		}

		if (fullDetails.equals(""))
		{
			return "Cart empty.";
		}
		return fullDetails;
	}


	public boolean addItem(Item item)
	{
		if (item.getStock() > 0)
		{
			getContents().add(item);
			item.setStock(item.getStock()-1);
			return true;
		}
		return false;
	}
}
