package controller;

import java.util.Scanner;

public class RoomateFinderController {
	public void start() {
      Scanner userChoice = new Scanner(System.in);
      System.out.println("-----------------------------------");
      System.out.println("         Welcome to Roomsicle      ");
      System.out.println("-----------------------------------");
      System.out.println("Select from the options:");
      System.out.println("1.Login  2.Register Yourself");
      System.out.print(" Enter Your choice ");
      String userSelection = userChoice.nextLine(); 
      int userSelectionInt = Integer.parseInt(userSelection);
      if (userSelectionInt==1) {
    	  Login login=new Login();  
		}    
      else {
      	  Registration register = new Registration();
		}
	}
}
