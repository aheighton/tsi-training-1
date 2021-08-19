package com.example.inheritance;

import java.util.regex.*;
import static java.lang.Integer.parseInt;

public interface Offer
{
	boolean getOfferStatus();
	void setOfferStatus(boolean offerStatus);
	String getOffer();
	void setOffer(String offer);
	default boolean validateOffer(String offer)
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
				parseInt(offer.substring(0, offer.length() - 5));
				return true;
			} catch (Exception e)
			{
				return false;
			}
		}
		return false;
	}

}
