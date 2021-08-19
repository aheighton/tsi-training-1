package com.example.inheritance;

import java.util.*;

public class Cart
{
	private User user;
	private List<Order> contents;

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

	public List<Order> getContents()
	{
		return contents;
	}

	public void setContents(List<Order> contents)
	{
		this.contents = contents;
	}

	public void emptyCart()
	{
		setContents(new LinkedList<>());
	}

	public int getTotalPrice()
	{
		int totPrice = 0;
		for (Order item: getContents())
		{
			totPrice += item.getItem().getOfferPrice(getContents()) * item.getNumber();
		}

		return totPrice;
	}

	public String displayCart()
	{
		StringBuilder fullDetails = new StringBuilder();

		for (Order orderItem: getContents())
		{
			fullDetails.append(orderItem.getNumber()).append("x ").append(orderItem.getItem().getName()).append(", ")
					.append(orderItem.getItem().getPrice()).append (" each. (")
					.append(orderItem.getItem().getDescription()).append(")\n");
		}

		if (fullDetails.toString().equals(""))
		{
			return "Cart empty.";
		}

		fullDetails.append("Total price: ").append(getTotalPrice());
		return fullDetails.toString();
	}


	public boolean addItem(Item item, int number)
	{
		for (Order orderItem : getContents())
		{
			if (orderItem.getItem().equals(item))
			{
				if (item.getStock() >= number)
				{
					orderItem.setNumber(orderItem.getNumber()+number);
					item.setStock(item.getStock()-number);
					return true;
				}
				return false;
			}
		}

		if (item.getStock() >= number)
		{
			getContents().add(new Order(item, number));
			item.setStock(item.getStock()-number);
			return true;
		}
		return false;
	}

	public boolean removeItem(Item newItem)
	{
		for (Order orderItem: getContents())
		{
			if (orderItem.getItem().equals(newItem))
			{
				getContents().remove(orderItem);
				return true;
			}
		}
		return false;
	}
}
