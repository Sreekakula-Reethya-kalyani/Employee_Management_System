<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add User</title>
    <style>
        body {
            font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
             background: linear-gradient(120deg, #d1faff, #ee8ec6); 
            color: #0b0b0b;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background: rgba(255, 255, 255, 0.8); 
            border-radius: 10px;
            padding: 30px;
            width: 400px;
            max-width: 100%;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2); 
            backdrop-filter: blur(10px); 
            border: 1px solid rgba(0, 0, 0, 0.2); 
            text-align: center;
        }

        h1 {
            font-size: 2rem;
            margin-bottom: 20px;
            color: #333;
        }

        table {
            width: 100%;
            margin: 20px 0;
            border-collapse: collapse;
        }

        td {
            padding: 10px;
            text-align: left;
        }

        input[type="text"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: none;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 1rem;
        }

        input[type="text"] {
            background: rgba(255, 255, 255, 0.9);
            color: #333;
            border: 1px solid rgba(0, 0, 0, 0.2);
        }

        input[type="text"]:focus {
            outline: none;
            border: 1px solid #00796b;
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.2);
        }

        input[type="submit"] {
            background: #00796b;
            color: #fff;
            font-weight: bold;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        input[type="submit"]:hover {
            background: #004d40; 
        }

        a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #00796b;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        a:hover {
            color: #004d40; 
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Add User</h1>
        <form action="addUser" method="post">
            <table>
                <tr>
                    <td><strong>Employee ID:</strong></td>
                    <td><input type="text" name="employeeId" required /></td>
                </tr>
                <tr>
                    <td><strong>First Name:</strong></td>
                    <td><input type="text" name="firstName" required /></td>
                </tr>
                <tr>
                    <td><strong>Last Name:</strong></td>
                    <td><input type="text" name="lastName" required /></td>
                </tr>
                <tr>
                    <td><strong>Department:</strong></td>
                    <td><input type="text" name="department" required /></td>
                </tr>
                <tr>
                    <td><strong>Salary:</strong></td>
                    <td><input type="text" name="salary" required /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Add User" /></td>
                </tr>
            </table>
        </form>
        <a href="usersList.jsp">View User List</a>
    </div>
</body>
</html>
