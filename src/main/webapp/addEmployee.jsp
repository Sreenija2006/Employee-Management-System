
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/form.css">



</head>
<body>
<div class="heading">
<h2>Add Employee</h2>
</div>
<div class="form">
<form action="<%=request.getContextPath()%>/addEmployees" method="post">
 <label>Name:</label><br>
 <input type="text" name="name" required><br><br>
 <label>Department:</label><br>
 <input type="text" name="department" required><br><br>
 <label>Salary:</label><br>
 <input type="text" name="salary" required><br><br>
 <input type="submit" value="Add"><br><br>
</form>
</div>
</body>
</html>