package controller.expensemanagement;

import commandline.IRoomsicleCLI;
import controller.ClassInitializer;
import controller.clicommentlist.IMakeCLICommentListController;
import database.IExpenseAdditionDAO;
import models.IExpenseAdditionModel;

public class ExpenseAdditionController {
    int expense;
    String description;

    public ExpenseAdditionController() {
        try{
            userExpenseAddition();
        }
        catch (Exception e){
            e.printStackTrace();
            userExpenseAddition();
        }
    }

    public void userExpenseAddition() {
        IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
        IExpenseAdditionDAO iExpenseAdditionDAO=ClassInitializer.initializer().getIExpenseAdditionDAO();
        IExpenseAdditionModel iExpenseAdditionModel=ClassInitializer.initializer().getIExpenseAdditionModel();
        iMakeCLICommentListController.makeCLICommentListController("expense.decorator.message","expense.management.expense.addition.main.message","expense.decorator.message");
        setExpense();
        setDescription();
        iExpenseAdditionDAO.addExpense(iExpenseAdditionModel);
    }

    public void setExpense() {
        IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
        IExpenseAdditionModel iExpenseAdditionModel=ClassInitializer.initializer().getIExpenseAdditionModel();
        IRoomsicleCLI iRoomsicleCLI=ClassInitializer.initializer().getRoomsicleCLI();
        try {
            iMakeCLICommentListController.makeCLICommentListController("expense.management.expense.price.addition.message");
            expense = iRoomsicleCLI.getNumberResponse();
            iExpenseAdditionModel.setExpensePrice(expense);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDescription() {
        IMakeCLICommentListController iMakeCLICommentListController= ClassInitializer.initializer().getIMakeCLICommentListController();
        IExpenseAdditionModel iExpenseAdditionModel=ClassInitializer.initializer().getIExpenseAdditionModel();
        IRoomsicleCLI iRoomsicleCLI=ClassInitializer.initializer().getRoomsicleCLI();
        try {
            iMakeCLICommentListController.makeCLICommentListController("expense.management.expense.price.description.message");
            description = iRoomsicleCLI.getStringResponse();
            iExpenseAdditionModel.setDescription(description);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}