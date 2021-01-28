<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
                  
       <!-- Page Heading -->
       <h1 class="h3 mb-4 text-gray-800">Store Modify Page</h1>

<form class="form-horizontal" action="/store/modify?sno=${store.sno }" method="post" >
  <div class="form-group">
    <label class="control-label col-sm-2" for="sno">SNO</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="sno" value="${store.sno }" readonly="readonly"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">NAME</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" value="${store.name }" >
    </div>
    </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="lat">Lat</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="lat" value="${store.lat }" >
    </div>
    </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="lng">LNG</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="lng" value="${store.lng }" >
    </div>
    </div>
     <div class="form-group">
    <label class="control-label col-sm-2" for="menu">MENU</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="menu" value="${store.menu }" >
    </div>
    </div>
	<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">Modify</button>
    </div>
    </div>
</form>

   <form class="form-horizontal" action="/store/delete?sno=${store.sno }" method="post" >

    <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    	<button type="submit" class="btn btn-danger">Delete</button>
    </div>
    </div>
    
   </form>

<%@include file="../includes/footer.jsp" %>