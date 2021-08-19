package com.example.password;

public class PassArrayValidation
{
    static String[][] passwords = {{"a","b","c","d"},
            {"Password123","HelloWorld","AbC1026","X1uHm35a"},
            {"correct","horse","battery","staple"},
            {"","","",""}};

    public static void main(String[] args)
    {


        for (int i = 0; i < passwords.length; i++)
        {
            System.out.println("\n Password set " + (i + 1) + ".");
            for (String password : passwords[i])
            {
                if (SimplePassCheck.passwordChecker(password, false))
                {
                    System.out.println("\"" + password + "\" is valid.");
                } else
                {
                    System.out.println("\"" + password + "\" is not valid.");
                }
            }
        }
    }
}
