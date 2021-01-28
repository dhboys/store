<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
                  
       <!-- Page Heading -->
       <h1 class="h3 mb-4 text-gray-800">Store View Page</h1>

<form class="form-horizontal" >
  <div class="form-group">
    <label class="control-label col-sm-2" for="sno">SNO</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="sno" value="${store.sno }" readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">NAME</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" value="${store.name }" readonly="readonly">
    </div>
    </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="lat">Lat</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="lat" value="${store.lat }" readonly="readonly">
    </div>
    </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="lng">LNG</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="lng" value="${store.lng }" readonly="readonly">
    </div>
    </div>
     <div class="form-group">
    <label class="control-label col-sm-2" for="menu">MENU</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="menu" value="${store.menu }" readonly="readonly">
    </div>
    </div>
</form>
	<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    	<a href="/store/modify?sno=${store.sno }"><button type="button" class="btn btn-danger">Modify / Delete</button></a>
    </div>
    </div>
   
    


<%@include file="../includes/footer.jsp" %>