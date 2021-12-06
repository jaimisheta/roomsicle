package database;

import models.OwnerDetailsModel;

import java.util.ArrayList;

public interface IOwnersDetailsDAO {
    public ArrayList<OwnerDetailsModel> getOwnersDetails();
}
