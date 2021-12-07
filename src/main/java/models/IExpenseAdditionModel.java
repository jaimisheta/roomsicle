package models;

public interface IExpenseAdditionModel {
    int getExpensePrice();
    void setExpensePrice( int expensePrice );
    String getUserEmailId();
    void setUserEmailId(String userEmailId);
    String[] getReceiverEmailId();
    void setReceiverEmailId(String[] receiverEmailId);
    int getGroupId();
    void setGroupId(int groupId);
    String getDescription();
    void setDescription(String description);
}
