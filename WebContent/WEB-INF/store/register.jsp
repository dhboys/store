<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
﻿<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>﻿
<%@include file="../includes/header.jsp" %>
                  
                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800">Register Page</h1>
                    
<form class="form-horizontal" action="/store/register" method="post" >
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">NAME</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" value=""/>
    </div>
    </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="lat">Lat</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="lat" value=""/>
    </div>
    </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="lng">LNG</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="lng" value=""/>
    </div>
    </div>
     <div class="form-group">
    <label class="control-label col-sm-2" for="menu">MENU</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="menu" value=""/>
    </div>
    </div>
	<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">Register</button>
    </div>
    </div>                  
</form>
                    
                    
<%@include file="../includes/footer.jsp" %>