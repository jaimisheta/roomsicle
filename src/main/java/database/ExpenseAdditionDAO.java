package database;

import models.IExpenseAdditionModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ExpenseAdditionDAO implements IExpenseAdditionDAO{
    DatabaseConnection databaseConnection = DatabaseConnection.getDatabaseConnectionObject();
    Connection connection = databaseConnection.getConnectionObject();

    Statement statement;

    @Override
    public void addExpense(IExpenseAdditionModel expenseAdditionModel) {
        String query;
        int expensePrice;
        String userEmailId;
        String[] receiverEmailId;
        String description;
        int groupId;

        expensePrice = expenseAdditionModel.getExpensePrice();
        userEmailId = expenseAdditionModel.getUserEmailId();
        receiverEmailId = expenseAdditionModel.getReceiverEmailId();
        description = expenseAdditionModel.getDescription();
        groupId = expenseAdditionModel.getGroupId();
        for (int i=0; i<receiverEmailId.length; i++) {
            try {
                statement = connection.createStatement();
                query = DatabaseQueryProperties.getDatabaseQueryPropertyValue("expense.entry.query")
                        .replace("GroupId", String.valueOf(groupId))
                        .replace("UserEmailId", userEmailId)
                        .replace("ReceiverEmailId", receiverEmailId[i])
                        .replace("Amount", String.valueOf(expensePrice))
                        .replace("Description", description);
                statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
