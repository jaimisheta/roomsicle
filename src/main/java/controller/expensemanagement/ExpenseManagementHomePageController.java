package controller.expensemanagement;

import commandline.CommandLineInputProperties;
import commandline.RoomsicleCLI;

import java.sql.SQLException;

public class ExpenseManagementHomePageController {
    static  RoomsicleCLI roomsicleCLI = new RoomsicleCLI();

    public static void main(String[] args) throws SQLException {
        showHomePage();
    }

    static int userSelection;
    public static void showHomePage() throws SQLException {
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("expense.decorator.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("expense.management.welcome.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("expense.decorator.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("expense.management.select.option.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("expense.management.select.choice.message"));
        roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("expense.management.select.user.choice.message"));
        userSelection = roomsicleCLI.getNumberResponse();
        if (userSelection==1){
            ExpenseAdditionController expenseAdditionController =new ExpenseAdditionController();
        }
        else if (userSelection==2){
            ExpenseSettleUpController expenseSettleUpController=new ExpenseSettleUpController();
        }
        else{
            roomsicleCLI.printMessage(CommandLineInputProperties.getCommandLineInputPropertyValue("owner.survey.invalid.input.message"));
        }
    }
}
