<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <form method="post" action="registrationServlet">
           
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstName" required /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastName" required /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="email" required /></td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="username" required /></td>
                    </tr>
                    
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password"  pattern="((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})"
					title="must be 8 alphabet with special symbol" required/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="Login.jsp">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
       
        </form>
    </body>
</html>
