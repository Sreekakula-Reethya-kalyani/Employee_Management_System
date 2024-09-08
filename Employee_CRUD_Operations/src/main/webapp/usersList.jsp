<%@page import="java.util.ArrayList"%>
<%@page import="com.tap.model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        center {
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            background: #fff;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background: #007bff;
            color: #fff;
        }
        tr:nth-child(even) {
            background: #f9f9f9;
        }
        tr:hover {
            background: #f1f1f1;
        }
        a {
            text-decoration: none;
            color: #007bff;
        }
        a:hover {
            text-decoration: underline;
        }
        .add-user-link {
            display: inline-block;
            margin: 20px auto;
            padding: 10px 20px;
            background: #28a745;
            color: #fff;
            border-radius: 5px;
            text-align: center;
        }
        .add-user-link:hover {
            background: #218838;
        }
    </style>
</head>
<body>
    <center>
        <h1>User List</h1>
        <table>
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Department</th>
                    <th>Salary</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<UserModel> userList = (ArrayList<UserModel>) session.getAttribute("userList");
                    if (userList != null && !userList.isEmpty()) {
                        for (UserModel user : userList) {
                %>
                <tr>
                    <td><%= user.getEmployeeId() %></td>
                    <td><%= user.getFirstName() %></td>
                    <td><%= user.getLastName() %></td>
                    <td><%= user.getDepartment() %></td>
                    <td><%= user.getSalary() %></td>
                    <td>
                        <a href="modifyUser?employeeId=<%= user.getEmployeeId() %>">Modify</a> |
                        <a href="deleteUser?employeeId=<%= user.getEmployeeId() %>">Delete</a>
                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="6">No users found.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <a class="add-user-link" href="adduser.jsp">Add New User</a>
    </center>
</body>
</html>
