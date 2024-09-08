package com.srk.mvn.srv;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.srk.dao.UserDAOImpl;
import com.tap.model.UserModel;

@WebServlet("/modifyUser")
public class ModifyUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get the employee ID from the request
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));

            // Fetch the user details from the database
            UserDAOImpl userDAO = new UserDAOImpl();
            UserModel user = userDAO.getUserById(employeeId);

            // Check if user exists
            if (user != null) {
                // Set the user attribute and forward to modifyUser.jsp
                request.setAttribute("user", user);
                request.getRequestDispatcher("modify.jsp").forward(request, response);
            } else {
                // If user not found, redirect to user list page or an error page
                response.sendRedirect("usersList.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to an error page or handle accordingly
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get parameters from the form
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String department = request.getParameter("department");
            double salary = Double.parseDouble(request.getParameter("salary"));

            // Create a UserModel object with updated details
            UserModel updatedUser = new UserModel(employeeId, firstName, lastName, department, salary);

            // Update the user in the database
            UserDAOImpl userDAO = new UserDAOImpl();
            userDAO.updateUser(updatedUser);

            // Fetch the updated user list
            ArrayList<UserModel> userList = userDAO.getAllUsers();

            // Store the updated user list in the session
            HttpSession session = request.getSession();
            session.setAttribute("userList", userList);

            // Forward to the user list JSP page
            request.getRequestDispatcher("usersList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to an error page or handle accordingly
        }
    }
}
