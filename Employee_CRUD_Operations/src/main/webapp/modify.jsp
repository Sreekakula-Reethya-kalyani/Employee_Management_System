<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.tap.model.UserModel"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modify User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff; 
            margin: 0;
            padding: 0;
        }
        center {
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        form {
            background-color: #ffffff; 
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 50%;
            margin: auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        td {
            padding: 12px;
            text-align: left;
        }
        input[type="text"] {
            width: calc(100% - 24px);
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #80deea; 
            color: #00796b; 
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #4dd0e1;
        }
        a {
            text-decoration: none;
            color: #00796b; 
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <center>
        <h1>Modify User Details</h1>
        <%
            UserModel user = (UserModel) request.getAttribute("user");
            if (user != null) {
        %>
        <form action="modifyUser" method="post">
            <table>
                <tr>
                    <td>Employee ID:</td>
                    <td><input type="text" name="employeeId" value="<%= user.getEmployeeId() %>" readonly /></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="firstName" value="<%= user.getFirstName() %>" required /></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="lastName" value="<%= user.getLastName() %>" required /></td>
                </tr>
                <tr>
                    <td>Department:</td>
                    <td><input type="text" name="department" value="<%= user.getDepartment() %>" required /></td>
                </tr>
                <tr>
                    <td>Salary:</td>
                    <td><input type="text" name="salary" value="<%= user.getSalary() %>" required /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Modify" /></td>
                </tr>
            </table>
        </form>
        <%
            } else {
        %>
        <p>User not found. Please go back to the <a href="usersList.jsp">user list</a>.</p>
        <%
            }
        %>
    </center>
</body>
</html>
