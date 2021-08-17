package com.example.test;

import java.util.Scanner;


public class Test1 {
    public static void main(String[] args)
    {
        String password = passwordInput();
        passwordChecker(password);
    }

    public static String passwordInput()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter password:");
        return reader.nextLine();
    }

    public static void passwordChecker(String password)
    {
        boolean isValid = true;


        if (password.equals(password.toUpperCase()))
        {
            System.out.println("Must contain lower case letter.");
            isValid = false;
        }

        if (password.equals(password.toLowerCase()))
        {
            System.out.println("Must contain upper case letter.");
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
            System.out.println("Must contain number 0-9.");
            isValid = false;
        }

        if (password.length() < 8)
        {
            System.out.println("Must be at least 8 characters long.");
            isValid = false;
        }

        if (isValid)
        {
            System.out.println("Password valid.");
        }
    }
}
