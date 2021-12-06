package database;

import models.IOwnerPropertyDetailsModel;

import java.util.ArrayList;

public interface IOwnerPropertyDetailsDAO {
    ArrayList<IOwnerPropertyDetailsModel> getOwnersPropertyDetails();
}
