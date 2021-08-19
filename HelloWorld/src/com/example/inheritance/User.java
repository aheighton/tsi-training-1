package com.example.inheritance;

public class User
{
	private String name;
	private String username;
	private boolean guest;
	private Cart cart;

	public User(String name, String username)
	{
		setName(name);
		setUsername(username);
		setGuest(false);
		openCart();
	}


	public User()
	{
		setName("Guest");
		setGuest(true);
		openCart();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public boolean isGuest()
	{
		return guest;
	}

	public void setGuest(boolean guest)
	{
		this.guest = guest;
	}

	public Cart getCart()
	{
		return cart;
	}

	public void setCart(Cart cart)
	{
		this.cart = cart;
	}

	public void openCart()
	{
		setCart(new Cart(this));
	}

	public void checkout()
	{
		//TODO: some method of payment using getCart().getTotalPrice(). Send cart confirmation.

		if (isGuest())
		{
			//TODO: wipe data from guest checkout and possibly ask if want to make account
			this.cart.emptyCart();
			//I know this does the same thing but for now it stops the if from collapsing
		} else
		{
			//TODO: move data to history
			getCart().emptyCart();
		}
	}
}
