<%@page import="com.entity.Student"%>
<%@page import="com.dao.sDAO"%>
<%@page import="com.conn.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="all_css.jsp"  %>
</head>
<body class="bg-light">
<%@ include file="navbar.jsp" %>

<div class="container m-4">
<div class="row">
<div class="col-md-6 offset-md-3">
<div  class="card">
<div class="card-body">
<p class="fs-3 text-center" > Edit Student</p>



<%
int id=Integer.parseInt(request.getParameter("id"));
sDAO dao=new sDAO(DBConnect.getConn());
Student s=dao.getStudentById(id);


%>

<form action="update"  method="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Full Name</label>
    <input type="text" class="form-control"  name="name" value="<%=s.getFullName() %>"></div>
    
     <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Date of Birth</label>
    <input type="date" class="form-control"  name="dob" value="<%= s.getDob()%>"></div>
    
     <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Address</label>
    <input type="text" class="form-control" name="address" value="<%= s.getAddress()%>"></div>
    
     <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Qualification</label>
    <input type="text" class="form-control"  name="qua" value="<%= s.getQualification() %>"></div>
    
     <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email</label>
    <input type="email" class="form-control" name="eamil" value="<%= s.getEmail()%>" ></div>
    
    <input type="hidden"  name="id" value="<%=s.getId()%> ">
          <%-- particular id ne update krva but id dekhay ny--%>
    
    
   
  
  <button type="submit" class="btn btn-primary col-md-12">Update</button>
</form>

</div></div>

</div>
</div></div>


</body>
</html>