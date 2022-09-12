<html>
<body>
<h1>Add New Record</h1>
<form action="Serv.SaveServlet" method="post">
  <table>
    <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
    <tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
    <tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
        <tr><td>Reason:</td><td><input type="reason" name="reason"/></td></tr>
        <tr><td>Amount:</td><td><input type="amount" name="amount"/></td></tr>

        <tr><td>Role:</td><td><input type="role" name="role"/></td></tr>
     <tr><td>Country:</td><td>
           <select name="country" style="width:150px">
             <option>India</option>
             <option>USA</option>
             <option>UK</option>
             <option>Other</option>
           </select>
         </td></tr>
         <tr><td colspan="2"><input type="submit" value="Save Employee"/></td></tr>
       </table>
       </form>
<h2>View Record</h2>
<form action="Serv.SpecificServlet" method="post">
<tr><td>Enter Role Number:</td><td><input type = role name = role></td><tr>
<tr><td colspan="2"><input type="submit" value="View Employee"/></td></tr>
</form>
</body>
</html>
