<%@ page import="java.util.*, com.ems.model.Employee" %>

<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/index.css">
</head>

<body>

<h2>Employee Management System</h2>

<div class="content">

<a href="addEmployee.jsp">
    <button class="add">Add Employee</button>
</a>

<div class="table-container">

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Dept</th>
<th>Salary</th>
<th>Action</th>
</tr>

<%
List<Employee> list = (List<Employee>) request.getAttribute("list");

if(list != null){

    int count = 1;   // ✅ correct place

    for(Employee e : list){
%>

<tr>
<td><%= count++ %></td>
<td><%= e.getName() %></td>
<td><%= e.getDepartment() %></td>
<td><%= e.getSalary() %></td>
<td>
<a href="<%=request.getContextPath()%>/editEmployee?id=<%= e.getId() %>">
    <button class="edit">Edit</button>
</a>
|
<a href="<%=request.getContextPath()%>/deleteEmployee?id=<%= e.getId() %>">
   <button class="delete" onclick="return confirmDelete(event, <%= e.getId() %>)">
    Delete
</button>
</a>
</td>
</tr>

<%
    }
}
%>

</table>

</div>
</div>


<script>
function confirmDelete(event, id) {

    event.preventDefault();   // 🔥 STOP default action

    if (confirm("Are you sure you want to delete this employee?")) {
        window.location.href = "<%=request.getContextPath()%>/deleteEmployee?id=" + id;
    }

    return false; // extra safety
}
</script>

<script>
    const params = new URLSearchParams(window.location.search);
    const msg = params.get("msg");

    if (msg === "added") {
        alert("Employee added successfully!");
    } 
    else if (msg === "updated") {
        alert("Employee updated successfully!");
    }
</script>

</body>
</html>