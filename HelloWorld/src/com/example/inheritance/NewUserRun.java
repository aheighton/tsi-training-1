package com.example.inheritance;

public class NewUserRun
{
	public static void main(String[] args)
	{
		createUserWithUsername("Gareth","gdavis");
		createGuest();
	}
	public static void createUserWithUsername(String name, String username)
	{
		User self = new User(name, username);
		System.out.println("Good morning, "+self.getName()+". ("+self.getUsername()+")");



		self.checkout();
	}

	public static void createGuest()
	{
		User self = new User();
		System.out.println("Good morning, "+self.getName()+".");
	}
}
