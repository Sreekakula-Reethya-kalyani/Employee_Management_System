package com.srk.mvn.srv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.srk.dao.UserDAOImpl;
import com.tap.model.UserModel;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("employeeId");

        try {
            int employeeId = Integer.parseInt(idStr);

            // Call DAO to delete user
            UserDAOImpl userDAO = new UserDAOImpl();
            userDAO.deleteUser(employeeId);

            // Fetch all users to update the session
            ArrayList<UserModel> userList = userDAO.getAllUsers();
            req.getSession().setAttribute("userList", userList);

            // Redirect to user list page
            resp.sendRedirect("usersList.jsp");

        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
}
