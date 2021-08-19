package com.example.inheritance;

public class User
{
	private String name;
	private String id;
	private boolean guest;

	public User(String name)
	{
		setName(name);
		setId(generateId());
		setGuest(false);
	}

	public User()
	{
		setName("Guest");
		setId(generateId());
		setGuest(true);
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

	public String generateId()
	{
		return "";
	}

	public boolean isGuest()
	{
		return guest;
	}

	public void setGuest(boolean guest)
	{
		this.guest = guest;
	}

	public void openCart()
	{
		Cart cart = new Cart(this);
	}
}
