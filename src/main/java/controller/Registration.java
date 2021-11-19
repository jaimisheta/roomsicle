package controller;

import java.util.Scanner;

import models.UsersModel;

public class Registration {
	
	public Registration() {
		UsersModel userRegister = new UsersModel();
		Scanner userChoice = new Scanner(System.in);
		Scanner userName = new Scanner(System.in);
		Scanner userContact = new Scanner(System.in);
		Scanner userEmailId = new Scanner(System.in);
		Scanner userPassword = new Scanner(System.in);
		Scanner userConfirmPassword = new Scanner(System.in);
		
		System.out.println("-----------------------------------");
	    System.out.println("         Registration      ");
	    System.out.println("-----------------------------------");
	    System.out.println("How do you Identify yourself?");
	    System.out.println("1.Roomate Seeker  2.Property Owner");
	    System.out.print(" Enter Your choice: ");
	    String userSelection = userChoice.nextLine(); 
	    userRegister.setUserSelection(userSelection);
	    int userSelectionInt = Integer.parseInt(userSelection);
	    
	    System.out.print(" Enter Your Name: ");
	    String Name = userName.nextLine(); 
	    userRegister.setFirstName(Name);
	    System.out.print(" Enter Your Contact Number: ");
	    String Contact = userContact.nextLine(); 
	    int ContactInt = Integer.parseInt(Contact);
	    userRegister.setContactNumber(ContactInt);
	    System.out.print(" Enter Your Email Id: ");
	    String Email = userEmailId.nextLine(); 
	    userRegister.setEmailId(Email);
	    System.out.print(" Enter Password: ");
	    String Password = userPassword.nextLine(); 
	    userRegister.setPassword(Password);
	    System.out.print(" Confirm Password: ");
	    String confirmPassword = userConfirmPassword.nextLine(); 
	    userRegister.setPassword(confirmPassword);
	    userRegister.roomSeeker(userSelectionInt);
	    System.out.print(" You have been registered successfully! ");
	}
	
}
