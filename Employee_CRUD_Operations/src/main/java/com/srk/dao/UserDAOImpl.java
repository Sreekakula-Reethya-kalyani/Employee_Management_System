package com.srk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.connection.code.ConnectionCode;
import com.tap.model.UserModel;

public class UserDAOImpl implements UserDAO {

    private static final String ADD_USER_QUERY = "INSERT INTO employees(employeeid, firstname, lastname, department, salary) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_QUERY = "UPDATE employees SET firstname = ?, lastname = ?, department = ?, salary = ? WHERE employeeid = ?";
    private static final String DELETE_USER_QUERY = "DELETE FROM employees WHERE employeeid = ?";
    private static final String GET_ALL_USERS_QUERY = "SELECT * FROM employees";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM employees WHERE employeeid = ?";

    @Override
    public void addUser(UserModel user) {
        try (Connection conn = ConnectionCode.myConnect();
             PreparedStatement pstmt = conn.prepareStatement(ADD_USER_QUERY)) {

            pstmt.setInt(1, user.getEmployeeId());
            pstmt.setString(2, user.getFirstName());
            pstmt.setString(3, user.getLastName());
            pstmt.setString(4, user.getDepartment());
            pstmt.setDouble(5, user.getSalary());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");

        } catch (SQLException e) {
            System.err.println("SQL Exception in addUser: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public int updateUser(UserModel user) {
        int rowsAffected = 0;
        try (Connection conn = ConnectionCode.myConnect();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_USER_QUERY)) {

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getDepartment());
            pstmt.setDouble(4, user.getSalary());
            pstmt.setInt(5, user.getEmployeeId());

            rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");

        } catch (SQLException e) {
            System.err.println("SQL Exception in updateUser: " + e.getMessage());
            e.printStackTrace();
        }
        return rowsAffected;
    }

    @Override
    public void deleteUser(int employeeId) {
        try (Connection conn = ConnectionCode.myConnect();
             PreparedStatement pstmt = conn.prepareStatement(DELETE_USER_QUERY)) {

            pstmt.setInt(1, employeeId);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");

        } catch (SQLException e) {
            System.err.println("SQL Exception in deleteUser: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<UserModel> getAllUsers() {
        ArrayList<UserModel> userList = new ArrayList<>();
        try (Connection conn = ConnectionCode.myConnect();
             PreparedStatement pstmt = conn.prepareStatement(GET_ALL_USERS_QUERY);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                UserModel user = new UserModel();
                user.setEmployeeId(rs.getInt("employeeid"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setDepartment(rs.getString("department"));
                user.setSalary(rs.getDouble("salary"));
                userList.add(user);
            }

        } catch (SQLException e) {
            System.err.println("SQL Exception in getAllUsers: " + e.getMessage());
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public UserModel getUserById(int employeeId) {
        UserModel user = null;
        try (Connection conn = ConnectionCode.myConnect();
             PreparedStatement pstmt = conn.prepareStatement(GET_USER_BY_ID_QUERY)) {

            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new UserModel();
                user.setEmployeeId(rs.getInt("employeeid"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setDepartment(rs.getString("department"));
                user.setSalary(rs.getDouble("salary"));
            }

        } catch (SQLException e) {
            System.err.println("SQL Exception in getUserById: " + e.getMessage());
            e.printStackTrace();
        }
        return user;
    }
}
