package database;

import models.UsersModel;

public interface UsersDAO {
	public UsersModel getUserCreds();
	public UsersModel roomSeeker();
	public UsersModel owner();
}
