package controller.expensemanagement;

public class ExpenseAdditionController {
    int expense;

    public void ExpenseAddition() {
        try{
            UserExpenseAddition();
        }
        catch (Exception e){
            e.printStackTrace();
            UserExpenseAddition();
        }
    }

    public void UserExpenseAddition() {

    }
}