package com.example.password;

import java.util.regex.*;

public class PasswordScore
{
	public static void main(String[] args)
	{
		String newPass = SimplePassCheck.passwordInput();
		int passScore = calcPassScore(newPass);
		outputEval(passScore);
	}

	public static int calcPassScore(String password)
	{
		if (password.length() < 8) return 0;

		Pattern alpha = Pattern.compile("[abcdefghijklmnopqrstuvwxyz]");
		Pattern alphaUp = Pattern.compile("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]");
		Pattern number = Pattern.compile("[0123456789]");
		Pattern special = Pattern.compile("[!£$%^&*()#;'?/.,:@~{}]");

		int multiplier = 0;
		if (alpha.matcher(password).find()) multiplier += 1;
		if (alphaUp.matcher(password).find()) multiplier += 1;
		if (number.matcher(password).find()) multiplier += 1;
		if (special.matcher(password).find()) multiplier += 1;

		return (multiplier * (password.length()-2));
	}
	
	public static void outputEval(int score)
	{
		System.out.println("Your password's score is: "+score);
		if (score < 10) System.out.println("Not great. You can do better.");
		else if (score < 20) System.out.println("Good! Not great, but pretty good!");
		else if (score < 40) System.out.println("Better, pretty secure! " +
				"Make sure you use different passwords for every account.");
		else System.out.println("Excellent! You really know your stuff.");
	}
}
