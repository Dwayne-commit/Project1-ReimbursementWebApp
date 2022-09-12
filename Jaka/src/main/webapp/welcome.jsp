<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Service</title>
</head>
<body>

<h1>Add New Record</h1>
<form action="Serv.SaveServlet" method="post">
  <table>
    <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
    <tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
    <tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
    <tr><td>Country:</td><td>
    <tr><td>Reason:</td><td><input type="reason" name="reason"/></td></tr>
    <tr><td>Amount:</td><td><input type="amount" name="amount"/></td></tr>
    <tr><td>Status:</td><td>
    <tr><td>Role:</td><td><input type="role" name="role"/></td></tr>
      <select name="country" style="width:150px">
        <option>India</option>
        <option>USA</option>
        <option>UK</option>
        <option>Other</option>
      </select>
       <select name="status" style="width:150px">
              <option>Approved</option>
              <option>Denied</option>
              <option>Pending</option>
            </select>
    </td></tr>
    <tr><td colspan="2"><input type="submit" value="Save Employee"/></td></tr>
  </table>
  <a href ="Serv.LogoutServlet">Logout</a>
</form>

<br/>
<form action="Serv.SpecificServlet" method="post">
<tr><td>Enter Role Number:</td><td><input type = role name = role></td><tr>
<tr><td colspan="2"><input type="submit" value="View Employee"/></td></tr>
</form>
<a href="Serv.ViewServlet">view employees</a>

</body>
</html>