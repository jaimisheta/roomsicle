package database;

import models.UserDetailsModel;

import java.util.ArrayList;

public interface IUserDetailsDAO {
     ArrayList<UserDetailsModel> getUserDetails();
     ArrayList<UserDetailsModel> getOwnersDetails();
}
