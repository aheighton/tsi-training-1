package com.example.inheritance;

public class Order
{
	private Item item;
	private int number;

	public Order(Item item, int number)
	{
		setItem(item);
		setNumber(number);
	}

	public Item getItem()
	{
		return item;
	}

	public void setItem(Item item)
	{
		this.item = item;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}
}
