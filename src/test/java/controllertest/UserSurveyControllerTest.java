package controllertest;

import controller.UserSurveyController;
import org.junit.Test;
import org.mockito.Mockito;

public class UserSurveyControllerTest {

    UserSurveyController userSurveyController = Mockito.mock(UserSurveyController.class);

    @Test
    public void testSetUserGender() {
        Mockito.doNothing().when(userSurveyController).setUserGender();
        userSurveyController.setUserGender();
        Mockito.verify(userSurveyController, Mockito.times(1)).setUserGender();
    }

    @Test
    public void testSetUserFoodHabits() {
        Mockito.doNothing().when(userSurveyController).setUserFoodHabits();
        userSurveyController.setUserFoodHabits();
        Mockito.verify(userSurveyController, Mockito.times(1)).setUserFoodHabits();
    }

    @Test
    public void testSetUserSmokingHabits() {
        Mockito.doNothing().when(userSurveyController).setUserSmokingHabits();
        userSurveyController.setUserSmokingHabits();
        Mockito.verify(userSurveyController, Mockito.times(1)).setUserSmokingHabits();
    }

    @Test
    public void testSetUserAlcoholHabits() {
        Mockito.doNothing().when(userSurveyController).setUserAlcoholHabits();
        userSurveyController.setUserAlcoholHabits();
        Mockito.verify(userSurveyController, Mockito.times(1)).setUserAlcoholHabits();
    }

    @Test
    public void testSetUserBudget() {
        Mockito.doNothing().when(userSurveyController).setUserBudget();
        userSurveyController.setUserBudget();
        Mockito.verify(userSurveyController, Mockito.times(1)).setUserBudget();
    }

    @Test
    public void testSetUsersProximityToDalhousieUniversity() {
        Mockito.doNothing().when(userSurveyController).setUsersProximityToDalhousieUniversity();
        userSurveyController.setUsersProximityToDalhousieUniversity();
        Mockito.verify(userSurveyController, Mockito.times(1)).setUsersProximityToDalhousieUniversity();
    }

    @Test
    public void testSetRoommateGenderPreference() {
        Mockito.doNothing().when(userSurveyController).setRoommateGenderPreference();
        userSurveyController.setRoommateGenderPreference();
        Mockito.verify(userSurveyController, Mockito.times(1)).setRoommateGenderPreference();
    }

    @Test
    public void testSetRoommateFoodHabitsPreference() {
        Mockito.doNothing().when(userSurveyController).setRoommateSmokingHabitsPreference();
        userSurveyController.setRoommateSmokingHabitsPreference();
        Mockito.verify(userSurveyController, Mockito.times(1)).setRoommateSmokingHabitsPreference();
    }

    @Test
    public void testSetRoommateSmokingHabitsPreference() {
        Mockito.doNothing().when(userSurveyController).setRoommateSmokingHabitsPreference();
        userSurveyController.setRoommateSmokingHabitsPreference();
        Mockito.verify(userSurveyController, Mockito.times(1)).setRoommateSmokingHabitsPreference();
    }

    @Test
    public void testSetRoommateAlcoholHabitsPreference() {
        Mockito.doNothing().when(userSurveyController).setRoommateAlcoholHabitsPreference();
        userSurveyController.setRoommateAlcoholHabitsPreference();
        Mockito.verify(userSurveyController, Mockito.times(1)).setRoommateAlcoholHabitsPreference();
    }
}
