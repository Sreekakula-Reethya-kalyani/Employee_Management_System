package com.srk.mvn.srv;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tap.model.UserModel;
import com.srk.dao.UserDAOImpl;

@WebServlet("/addUser")
public class AddUserServ extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("employeeId");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dep = req.getParameter("department");
        String salStr = req.getParameter("salary");

        try {
            int employeeId = Integer.parseInt(idStr);
            double salary = Double.parseDouble(salStr);

            // Create UserModel object and set properties
            UserModel user = new UserModel();
            user.setEmployeeId(employeeId);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setDepartment(dep);
            user.setSalary(salary);

            // Call DAO to add user
            UserDAOImpl userDAO = new UserDAOImpl();
            userDAO.addUser(user);

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
