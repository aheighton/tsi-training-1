package com.example.inheritance;

import java.util.*;
import java.util.regex.*;

import static java.lang.Integer.parseInt;

public class Item implements Offer
{
	private String name;
	private String id;
	private int price;
	private int stock;
	private String description;
	private boolean offerStatus;
	private String offer;

	public Item(String name, String id, int price, int stock, String description)
	{
		setName(name);
		setId(id);
		setPrice(price);
		setStock(stock);
		setDescription(description);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public int getStock()
	{
		return stock;
	}

	public void setStock(int stock)
	{
		this.stock = stock;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public boolean getOfferStatus()
	{
		return offerStatus;
	}

	public void setOfferStatus(boolean offerStatus)
	{
		this.offerStatus = offerStatus;
	}

	@Override
	public String getOffer()
	{
		return this.offer;
	}

	@Override
	public void setOffer(String offer)
	{
		if (validateOffer(offer))
		{
			this.offer = offer;
		}
	}

	@Override
	public boolean validateOffer(String offer)
	{
		return Offer.super.validateOffer(offer);
	}

	public int getOfferPrice(List<Item> cart)
	{
		if (getOfferStatus())
		{
			if (getOffer().equals("bogof"))
			{
				int number = 0;
				for (Item checkItem: cart)
				{
					if (checkItem.equals(this))
					{
						number += 1;
					}
				}

				return (getPrice() * (Math.round(number/2f))/(number));
				/* Alex:
				 * rather than set some items to full price and others to 0, this calculation makes a relative
				 * equal price for each of them.
				 * Math.round(number/2f) is either exactly half or 1 over half, and dividing this by the total gives
				 * either exactly a half, or the correct proportion to pay half price for all but one (at full price)
				 *
				 * Probably a more efficient way to do this that doesn't require searching the whole list every time.
				 * TODO: make bogof pricing not have to search the whole list every time
				 */
			}

			Pattern perCentOff = Pattern.compile("% off");
			if (perCentOff.matcher(offer).find())
			{
				try
				{
					int discount = parseInt(offer.substring(0, offer.length() - 5));
					return (Math.round(getPrice() * discount / 100f));
				} catch (Exception e)
				{
					return getPrice();
				}
			}
		}
		return getPrice();
	}
}
