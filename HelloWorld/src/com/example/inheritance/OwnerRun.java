package com.example.inheritance;

import java.io.*;
import java.util.*;


public class OwnerRun
{
	public static void main(String[] args)
	{
		List<Item> stock = generateItems();
		createBrick();

		System.out.println(stock);
	}

	public static List<Item> generateItems()
	{
		List<Item> stock = new LinkedList<>();

		try
		{
			File file = new File(Item.stockRecord);
			Scanner fReader = new Scanner(file);
			Scanner splitter;
			String nextRead;

			while (fReader.hasNextLine())
			{
				nextRead = fReader.nextLine();
				splitter = new Scanner(nextRead).useDelimiter("/");
				String fId = splitter.next();
				String fName = splitter.next();
				int fPrice = splitter.nextInt();
				int fStock = splitter.nextInt();
				splitter.next();
				String fOffer = splitter.next();

				stock.add(new Item(fId, fName, fPrice, fStock, fOffer));
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return stock;

	}

	public static void createBrick()
	{
		Item item = new Item("1","Brick",98,399,"It is a brick.");
		System.out.println(item);
	}
}
