<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome To CreativeMind</h1>
<form action="EmployeeAddServlet" method="post">
   <input name="id">
   <input name="name">
   <input name="role">
   <input name="salary">
   <input name="fresher">
   <button value="submit">submit</button>
</form>
<br><hr>
<a href="http://localhost:8080/EmployeeData/FetchData"><button>Fetch Employee</button></a>
</body>
</html>