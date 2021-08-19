package com.example.password;

import java.util.Scanner;


public class SimplePassCheck
{

    public static void main(String[] args)
    {
		int passCount = 0;
        boolean isValid;
        do
        {
            String password = passwordInput();
            isValid = passwordChecker(password, true);
            passCount += 1;
        } while (!isValid && (passCount < 8));

        if (isValid)
        {
        	System.out.println("Password set.");
        } else
        {
			System.out.println("Number of tried exceeded.");
        }
    }

    public static String passwordInput()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter password:");
        return reader.nextLine();
    }

    public static boolean passwordChecker(String password, boolean systemOut)
    {
        boolean isValid = true;


        if (password.equals(password.toUpperCase()))
        {
            if (systemOut)
            {
                System.out.println("Must contain lower case letter.");
            }
            isValid = false;
        }

        if (password.equals(password.toLowerCase()))
        {
            if (systemOut)
            {
                System.out.println("Must contain upper case letter.");
            }
            isValid = false;
        }

        boolean containsNumber = false;
        for (int checkNumber = 0; checkNumber < 10; checkNumber++)
        {
            if (password.contains(String.valueOf(checkNumber)))
            {
                containsNumber = true;
                break;
            }
        }
        if (!containsNumber)
        {
            if (systemOut)
            {
                System.out.println("Must contain number 0-9.");

            }
            isValid = false;
        }

        if (password.length() < 8)
        {
            if (systemOut)
            {
                System.out.println("Must be at least 8 characters long.");
            }
            isValid = false;
        }

        if (isValid && systemOut)
        {
            System.out.println("Password valid.");
        }

        return isValid;
    }
}