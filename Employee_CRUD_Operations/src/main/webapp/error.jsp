<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* Full-height for centering */
            background-color: #f8d7da; /* Light red background for error */
        }

        .message-box {
            text-align: center;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .message-box h1 {
            color: #dc3545; /* Red color for error message */
        }

        .message-box p {
            margin: 20px 0;
        }

        .message-box a {
            display: inline-block;
            padding: 10px 20px;
            color: white;
            background-color: #dc3545;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 10px;
        }

        .message-box a:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="message-box">
        <h1>Operation Failed!</h1>
        <p>There was an error processing your request. Please try again.</p>
        <a href="adduser.jsp">Go Back to Form</a>
    </div>
</body>
</html>
