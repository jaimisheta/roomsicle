package controller;

import java.util.Scanner;
import models.UsersModel;

public class Login{
	UsersModel d1=new UsersModel();
	public Login() {

		Scanner Email = new Scanner(System.in);
		Scanner Password = new Scanner(System.in);

	  System.out.println("-----------------------------------");
      System.out.println("         Login      ");
      System.out.println("-----------------------------------");
      System.out.println("Enter Your Email Id:");
      String emailEntry = Email.nextLine();
      System.out.println("Password:");
      String passwordEntry = Email.nextLine();
      String Value = d1.getUserCreds().get(emailEntry);
      if (Value != null) {
    	  if(d1.getUserCreds().get(emailEntry).equals(passwordEntry) ) {
    		  System.out.println("Login Successfull");
    	  }  
    	  else {
      		System.out.println("Login Failed");
      	}  
    	} else {
    		System.out.println("Login Failed");
    	}
      

	}
	
}
