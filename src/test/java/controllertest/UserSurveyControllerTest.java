package controllertest;

import controller.UserSurveyController;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class UserSurveyControllerTest {

    UserSurveyController userSurveyController = Mockito.mock(UserSurveyController.class);

    @Test
    public void testGetUserGenderFromUser() {
        String result;
        Mockito.when(userSurveyController.getUserGenderFromUser()).thenReturn("Male");
        result = userSurveyController.getUserGenderFromUser();
        Assert.assertEquals(result, "Male");
    }

    @Test
    public void testGetUserFoodHabitsFromUser() {
        String result;
        Mockito.when(userSurveyController.getUserFoodHabitsFromUser()).thenReturn("Veg");
        result = userSurveyController.getUserFoodHabitsFromUser();
        Assert.assertEquals(result, "Veg");
    }

    @Test
    public void testGetUserSmokingHabitsFromUser() {
        int result;
        Mockito.when(userSurveyController.getUserSmokingHabitsFromUser()).thenReturn(1);
        result = userSurveyController.getUserSmokingHabitsFromUser();
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testGetUserAlcoholHabitsFromUser() {
        int result;
        Mockito.when(userSurveyController.getUserAlcoholHabitsFromUser()).thenReturn(1);
        result = userSurveyController.getUserAlcoholHabitsFromUser();
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testGetUserBudgetFromUser() {
        int result;
        Mockito.when(userSurveyController.getUserBudgetFromUser()).thenReturn(500);
        result = userSurveyController.getUserBudgetFromUser();
        Assert.assertEquals(result, 500);
    }

    @Test
    public void testGetUsersProximityToDalhousieUniversityFromUser() {
        int result;
        Mockito.when(userSurveyController.getUsersProximityToDalhousieUniversityFromUser()).thenReturn(2000);
        result = userSurveyController.getUsersProximityToDalhousieUniversityFromUser();
        Assert.assertEquals(result, 2000);
    }

    @Test
    public void testGetRoommateGenderPreferenceFromUser() {
        String result;
        Mockito.when(userSurveyController.getRoommateGenderPreferenceFromUser()).thenReturn("Female");
        result = userSurveyController.getRoommateGenderPreferenceFromUser();
        Assert.assertEquals(result, "Female");
    }

    @Test
    public void testGetRoommateFoodHabitsPreferenceFromUser() {
        String result;
        Mockito.when(userSurveyController.getRoommateFoodHabitsPreferenceFromUser()).thenReturn("Non-Veg");
        result = userSurveyController.getRoommateFoodHabitsPreferenceFromUser();
        Assert.assertEquals(result, "Non-Veg");
    }

    @Test
    public void testGetRoommateSmokingHabitsPreferenceFromUser() {
        String result;
        Mockito.when(userSurveyController.getRoommateSmokingHabitsPreferenceFromUser()).thenReturn("No");
        result = userSurveyController.getRoommateSmokingHabitsPreferenceFromUser();
        Assert.assertEquals(result, "No");
    }

    @Test
    public void testGetRoommateAlcoholHabitsPreferenceFromUser() {
        String result;
        Mockito.when(userSurveyController.getRoommateAlcoholHabitsPreferenceFromUser()).thenReturn("Yes");
        result = userSurveyController.getRoommateAlcoholHabitsPreferenceFromUser();
        Assert.assertEquals(result, "Yes");
    }

}
