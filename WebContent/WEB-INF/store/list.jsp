<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
﻿<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>﻿
<%@include file="../includes/header.jsp" %>
                  
                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800">Store List Page</h1>
         
          <a href="/store/register"><button type="button" class="btn btn-primary">Register</button></a>
         
    <div>      
<table class="table">
  <thead>
    <tr>
      <th scope="col">SNO</th>
      <th scope="col">NAME</th>
      <th scope="col">LAT</th>
      <th scope="col">LNG</th>
      <th scope="col">MENU</th>
      <th scope="col">REGDATE</th>
      <th scope="col">UPDATE DATE</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${stores}" var="store">
    <tr>
      <td>${store.sno }</td>
      <td><a href='/store/view?sno=${store.sno}'>${store.name }</a></td>
      <td>${store.lat }</td>
      <td>${store.lng }</td>
      <td>${store.menu }</td>
      <td>${store.regdate }</td>
      <td>${store.updateDate }</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
   </div>             

                    
<%@include file="../includes/footer.jsp" %>