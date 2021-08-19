package com.example.inheritance;

import java.util.regex.*;
import static java.lang.Integer.parseInt;

public interface Offer
{
	public boolean getOfferStatus();
	public void setOfferStatus(boolean offerStatus);
	public String getOffer();
	public void setOffer(String offer);
	public default boolean validateOffer(String offer)
	{
		if (offer.equals("bogof"))
		{
			return true;
		}

		Pattern perCentOff = Pattern.compile("% off");

		if (perCentOff.matcher(offer).find())
		{
			try
			{
				int discount = parseInt(offer.substring(0, offer.length() - 5));
				return true;
			} catch (Exception e)
			{
				return false;
			}
		}
		return false;
	}

}
