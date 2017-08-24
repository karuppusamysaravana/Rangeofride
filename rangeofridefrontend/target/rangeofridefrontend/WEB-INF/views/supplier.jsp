<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.4/css/jquery.dataTables.min.css">
<script> $(decument).ready(function(){
	$('#table_id').dataTable({
		"pagingType":"full_number",
        "lengthMenu":[[2,5,10,-1],[2,5,10,"ALL"]]
	});
	
});
</script>

<title>supplier page </title>
<jsp:include page="header.jsp"/>
<div class="container">
<c:if test="${!check}">
<form:form class="form-horizontal" action="getsupplier" modelAttribute="SuppModel">
<fieldset>

<!-- Form Name -->
<legend> <u><u> </legend>

<!-- Select Basic -->

<br>
<br>
<br>
<!-- Select Basic -->
 
<div class="form-group"form-group">
  <label class="col-md-4 control-label" for="category_name_fr">NAME</label>
  <div class="col-md-4">
      <form:input id="text" name="textinput" type="text" placeholder="" class="form-control input-md" path="sName"/>
  </div>
  </div>
<br>

<div class="form-group"form-group">
  <label class="col-md-4 control-label" for="category_name">PHONE</label>
  <div class="col-md-4">
     <form:input id="text" name="textinput" type="text" placeholder="" class="form-control input-md" path="sPhone"/>
  </div>
</div>
<br>


<div class="form-group"form-group">
  <label class="col-md-4 control-label" for="category_name_fr">ADDRESS</label>
  <div class="col-md-4">
      <form:textarea class="form-control" id="text" name="textarea" path="sAddress"/>
</div>
</div>

<!--------------->


<!-- Button -->
<div class="form-group"form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" name="" class="btn btn-primary">SUBMIT</button>
  </div>
</div>

</fieldset>
</form:form>
 </c:if>
 </div>

<div class="container">
<c:if test="${check}">
<form:form class="form-horizontal" action="putsupplier" modelAttribute="SuppModel">
<fieldset>

<!-- Form Name -->
<legend> <u><u> </legend>

<!-- Select Basic -->

<br>
<br>
<br>

<div class="form-group"form-group">
<!--   <label class="col-md-4 control-label" for="category_name_fr">ID</label> -->
  <div class="col-md-4">
      <form:input id="text" name="textinput" type="hidden" placeholder="" class="form-control input-md" path="sid"/>
  </div>
</div>


<!-- Select Basic -->
<div class="form-group"form-group">
  <label class="col-md-4 control-label" for="category_name_fr">NAME</label>
  <div class="col-md-4">
      <form:input id="text" name="textinput" type="text" placeholder="" class="form-control input-md" path="sName"/>
  </div>
</div>
<br>

<div class="form-group"form-group">
  <label class="col-md-4 control-label" for="category_name_fr">PHONE</label>
  <div class="col-md-4">
      <form:input id="text" name="textarea" class="form-control input-md" path="sPhone"/>
  </div>
</div>
<br>

<div class="form-group"form-group">
  <label class="col-md-4 control-label" for="category_name_fr">ADDRESS</label>
  <div class="col-md-4">
      <form:textarea class="form-control" id="textarea" name="textarea" path="sAddress"/>
</div>
</div>


<!-- Button -->
<div class="form-group"form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" name="" class="btn btn-primary">UPDATE</button>
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
            <td><b>SUPPLIER ID</b></td>
              <td><b>SUPPLIER NAME</b></td>
              <td><b>SUPPLIER ADDRESS</b></td>
               <td><b>SUPPLIER PHONE</b></td>
                 <td><b>SUPPLIER ACTION</b></td>
                 </tr>
                  </thead>
                   <tbody>
                    <c:forEach items="${SuppTable}" var="s">
                      <tr>
                      <td>${s.getSid()}</td>
                        <td>${s.getsName()}</td>
                         <td>${s.getsAddress()}</td>
                           <td>${s.getsPhone()}</td>
                                    <td>
                                       <div class="col-md-4">
                                       <a href="removesupp/${s.getSid()}">
                                           <button id="removebuttons" type="button" class="btn btn-primary">DELETE</button></a>
                                           </div>
                                           <div class="col-md-4">    
                                         <a href="suppedit?getSid=${s. getSid()}">
                                           <button id="editbuttons" type="button" class="btn btn-primary">EDIT</button>
                                           </a>
                                          </div>
                                          </td>
                                    </tr>
                                        </c:forEach>
                                               </tbody>
                                                    </table>
                                                       </div> 
  <jsp:include page="footer.jsp"/>
  
  
 