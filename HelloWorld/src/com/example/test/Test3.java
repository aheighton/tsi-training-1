package com.example.test;

public class Test3
{
	public static void main(String[] args)
	{
		boolean isValid;
		int tries = 0;


		do
		{
			String inputPassword = Test1.passwordInput();
			isValid = checkPass(inputPassword);
			tries++;
		} while (!isValid && (tries < 8));

		if (isValid)
		{
			System.out.println("Welcome back. Now logging in.");
		} else
		{
			System.out.println("Max attempts achieved.");
		}
	}

	public static boolean checkPass(String input)
	{
		boolean isValid = false;
		for (String[] passSet: Test2.passwords)
		{
			for (String pass: passSet)
			{
				if (pass.equals(input))
				{
					isValid = true;
					break;
				}
			}
		}

		return isValid;
	}
}
