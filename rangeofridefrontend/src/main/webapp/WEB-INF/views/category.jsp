<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.4/css/jquery.dataTables.min.css">
<script> 

   $(decument).ready(function(){
	$('#table_id').dataTable({
		"pagingType":"full_number",
        "lengthMenu":[[2,5,10,-1],[2,5,10,"ALL"]]
	});
	
  });
   
</script>
<title>categorypage</title>
<style>
fieldset fieldset{
    margin:0 70px;   
}
fieldset {
    border: 0;
border-bottom: 1px solid #e5e5e5;
}
</style>
<jsp:include page="header.jsp"/>

<div class="container">

    <c:if test="${!check}">
    <form:form class="form-horizontal" action="getcat" modelAttribute="CatModel">
<fieldset>


<legend></legend>

<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">NAME</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="cName"/>
    
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="textarea">DISCRIPTION</label>
  <div class="col-md-4">                     
    <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="cDiscription"/>
     </div>
</div>
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
  
    <form:button id="singlebutton" name="singlebutton" class="btn btn-success" params="add">SUBMIT</form:button>
    
  </div>
</div>
</fieldset>
</form:form>
</c:if>
<c:if test="${check}">

    <form:form class="form-horizontal" action="putcat" modelAttribute="CatModel">
<fieldset>

<!-- Form Name -->
<legend></legend>



<!-- Text input-->
<!-- <div class="form-group"> -->
<!--   <label class="col-md-4 control-label" for="textinput">Product Id</label>   -->
<!--   <div class="col-md-4"> -->
<%--   <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="Id"/> --%>
    
<div class="form-group">
   
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="hidden" placeholder="" class="form-control input-md" path="cid"/>
</div>
</div>

<div class="form-group">
<!--   <label class="col-md-4 control-label" for="textinput">CATEGORY ID</label>   -->
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="hidden" placeholder="" class="form-control input-md" path="cid"/>
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">CATEGORY NAME</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="cName"/>
    
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="textarea">CATEGORY DISCRIPTION</label>
  <div class="col-md-4">                     
    <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="cDiscription"/>
     </div>
</div>
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    
    <form:button id="singlebutton" name="singlebutton" class="btn btn-success" params="update">UPDATE</form:button>
    
  </div>
</div>
</fieldset>
</form:form>
</c:if>
  </div>
  <div  class="container">
  <table id="table_id" class="table table-striped table-bordered table-list">
  <thead>
  <tr>
  <td><b>CATEGORY ID</b></td>
  <td><b>CATEGORY NAME</b></td>
  <td><b>CATEGORY DISCRIPTION</b></td>
  <td><b>CATEGORY ACTION</b></td>
  
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${CatTable}" var="c">
  <tr>
  <td>${c.getCid()}</td>
    <td>${c.getcName()}</td>
      <td>${c.getcDiscription()}</td>
          <td>
             <div class="col-md-4">
                 <a href="removecat/${c.getCid()}">
                   <button id="removebuttons" type="button" class="btn btn-primary">DELETE</button></a>
                      </div>
                       <div class="col-md-4">    
                          <a href="catedit?getcId=${c.getCid()}">
                              <button type="button" class="btn btn-primary">EDIT</button>
                              </a>
                                    </div>
                                     </td>
                                        </tr>
                                          </c:forEach>    
                                            </tbody>
                                             </table>
                                              </di>
                                          
  <jsp:include page="footer.jsp"/> 