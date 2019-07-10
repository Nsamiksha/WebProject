<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Example</title>
    </head>
    <body>
        <form method="post" action="loginServlet">
           
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Login Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" required /></td>
                    </tr>
                   
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" pattern="((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})"
					title="must be 8 alphabet with special symbol" required/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Yet Not Registered!! <a href="Registration.jsp">Register Here</a></td>
                    </tr>
                     <tr>
                        <td colspan="2">Forgot Password!! <a href="ForgotPassword.jsp">Set Here</a></td>
                    </tr>
                </tbody>
            </table>
           
        </form>
    </body>
</html>