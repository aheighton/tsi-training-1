package com.example.inheritance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.regex.*;

import static java.lang.Integer.parseInt;

public class Item implements Offer
{
	public static final String stockRecord = "stockRecord.txt";

	private String id;
	private String name;
	private int price;
	private int stock;
	private String description;
	private boolean offerStatus;
	private String offer;

	public Item(String id, String name, int price, int stock, String description, String offer)
	{
		setId(id);
		setName(name);
		setPrice(price);
		setStock(stock);
		setDescription(description);
		setOffer(offer);
	}

	public Item(String id, String name, int price, int stock, String description)
	{
		setId(id);
		setName(name);
		setPrice(price);
		setStock(stock);
		setDescription(description);
		setOffer("");
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
			setOfferStatus(true);
		} else if (offer.equals(""))
		{
			setOfferStatus(false);
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

	public void save()
	{
		try
		{
			boolean exists = false;
			File file = new File(stockRecord);

			Scanner fReader = new Scanner(file);
			Scanner splitter;

			String nextRead;
			List<String> fileRead = new LinkedList<>();

			while (fReader.hasNextLine())
			{
				nextRead = fReader.nextLine();
				splitter = new Scanner(nextRead).useDelimiter("/");
				String nextId = splitter.next();

				if (nextId.equals(getId()))
				{
					exists = true;
					fileRead.add(this.toString());
				} else
				{
					fileRead.add(nextRead);
				}
			}

			if (!exists)
			{
				fileRead.add(this.toString());
			}
			fReader.close();

			FileWriter fw = new FileWriter(file, false);
			BufferedWriter bw = new BufferedWriter(fw);
			for (String item: fileRead)
			{
				bw.write(item);
				bw.newLine();
			}
			bw.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public String toString()
	{
		return (getId()+"/"+getName()+"/"+getPrice()+"/"+getStock()+"/"+getDescription()+"/"+getOfferStatus()+"/"+getOffer());
	}
}
