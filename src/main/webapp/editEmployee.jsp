<%@ page import="com.ems.model.Employee" %>
<%
Employee e = (Employee) request.getAttribute("emp");
%>
<html>
<head>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/form.css">
</head>
<body>
<div class="heading">
<h2>Edit Employee</h2>
</div>
<div class="form">
<form action="<%=request.getContextPath()%>/updateEmployee" method="post">
<input type="hidden" name="id" value="<%= e.getId() %>">

 <label>Name:</label><br>
 <input type="text" name="name" value="<%= e.getName() %>"><br><br>
 
<label>Department:</label><br>
 <input type="text" name="department" value="<%= e.getDepartment() %>"><br><br>
<label>Salary:</label> <br>
<input type="text" name="salary" value="<%= e.getSalary() %>"><br><br>

<input type="submit" value="Update">
</form>
</div>
</body>


</html>
