
package com.srk.dao;

import java.util.ArrayList;

import com.tap.model.UserModel;

public interface UserDAO {


	public void addUser(UserModel u);

	public int updateUser(UserModel user);

	public void deleteUser(int employeeId);

	public ArrayList<UserModel> getAllUsers();

	public UserModel getUserById(int employeeId);


}
