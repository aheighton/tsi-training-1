package com.example.password;

import java.util.*;
import java.io.*;

public class PassChangeMenu
{
	public static String passFile = "passwords.txt";

	public static void main(String[] args)
	{
		String menuOption;
		Scanner kReader = new Scanner(System.in);
		List<String> passwords;
		do
		{
			System.out.println("Select an option");
			System.out.println("1: View passwords");
			System.out.println("2: Add a password");
			System.out.println("3: Delete a password");
			System.out.println("4: Exit");
			menuOption = kReader.nextLine();

			switch (menuOption)
			{
				case "1" -> {
					passwords = readPass();
					System.out.println(passwords);
				}
				case "2" -> {
					System.out.println("Adding a password:");
					String input = SimplePassCheck.passwordInput();
					boolean dupe = checkDupe(input);
					if (dupe)
					{
						System.out.println("Password already exists. Not entered.");
					} else
					{
						addPass(input);
						System.out.println("Password added to file.");

						/* Alex:
						 * Adds any password, no matter what.
						 * TODO: run new passwords through SimplePassCheck validation.
						 */
					}
				}
				case "3" -> {
					System.out.println("Deleting a password:");
					String input = SimplePassCheck.passwordInput();
					boolean dupe = checkDupe(input);
					if (dupe)
					{
						System.out.println("Password found. Now deleting.");
						delPass(input);
						System.out.println("Deleted.");
					} else
					{
						System.out.println("Password not found. Not deleted.");
					}
				}
			}
		} while (!menuOption.equals("4"));
	}

	public static List<String> readPass()
	{
		try
		{
			File file = new File(passFile);
			Scanner fReader = new Scanner(file);

			String nextRead;
			List<String> fileRead = new LinkedList<>();

			while (fReader.hasNextLine())
			{
				nextRead = fReader.nextLine();
				fileRead.add(nextRead);
			}

			fReader.close();

			return fileRead;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static boolean checkDupe(String newPass)
	{
		List<String> passwords = readPass();
		if (passwords == null)
		{
			return false;
		}
		for (String s : passwords)
		{
			if (s.equals(newPass))
			{
				return true;
			}
		}
		return false;
	}

	public static void addPass(String newPass)
	{
		try
		{
			File file = new File(passFile);
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(newPass);
			bw.newLine();
			bw.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void delPass(String oldPass)
	{
		List<String> passwords = readPass();
		assert passwords != null;
		passwords.removeIf(s -> s.equals(oldPass));

		try
		{
			File file = new File(passFile);
			FileWriter fw = new FileWriter(file, false);
			BufferedWriter bw = new BufferedWriter(fw);
			for (String s : passwords)
			{
				bw.write(s);
				bw.newLine();
			}

			/* Alex:
			 * I am fully aware that this is super inefficient
			 * I'm not 100% versed in lists and files, and I'm sure there's a more efficient way to do this than just
			 * rewriting the whole file every time, but while I'm only dealing with small numbers, it's fine.
			 *
			 * TODO: fix efficiency.
			 */

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}