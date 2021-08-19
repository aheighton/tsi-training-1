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
		StringBuilder fullDetails = new StringBuilder();

		for (Item item: getContents())
		{
			fullDetails.append(item.getName()).append(" (").append(item.getId()).append("):")
					.append(item.getDescription()).append("\n");
		}

		if (fullDetails.toString().equals(""))
		{
			return "Cart empty.";
		}

		fullDetails.append("Total price: ").append(getTotalPrice());
		return fullDetails.toString();
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

	public boolean removeItem(Item newItem)
	{
		for (Item item: getContents())
		{
			if (item.equals(newItem))
			{
				getContents().remove(item);
				return true;
			}
		}
		return false;
	}
}
