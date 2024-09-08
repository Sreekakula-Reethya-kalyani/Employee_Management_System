<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* Full-height for centering */
            background-color: #e7f5e6; /* Light green background for success */
        }

        .message-box {
            text-align: center;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .message-box h1 {
            color: #4CAF50; /* Green color for success message */
        }

        .message-box p {
            margin: 20px 0;
        }

        .message-box a {
            display: inline-block;
            padding: 10px 20px;
            color: white;
            background-color: #4CAF50;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 10px;
        }

        .message-box a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="message-box">
        <h1>Operation Successful!</h1>
        <p>Your request has been processed successfully.</p>
        <a href="adduser.jsp">Go Back to Form</a>
    </div>
</body>
</html>
