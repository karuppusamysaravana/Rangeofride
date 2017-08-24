<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-1.11.1.js"></script>
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<link href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
<script> $(decument).ready(function(){
	$('#table_id').dataTable({
		"pagingType":"full_number",
        "lengthMenu":[[2,5,10,-1],[2,5,10,"ALL"]]
	});
	
});
</script>
<title>product</title>
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
 <form:form class="form-horizontal" action="getproduct" modelAttribute="ProModel" enctype="multipart/form-data">
<fieldset>

<!-- Form Name -->
<legend></legend>



<!-- Text input-->
<!-- <div class="form-group"> -->
<!--   <label class="col-md-4 control-label" for="textinput">Product Id</label>   -->
<!--   <div class="col-md-4"> -->
<%--   <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="Id"/> --%>
    
<!--   </div> -->
<!-- </div> -->
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">NAME</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="pName"/>
 </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="textarea">DISCRIPTION</label>
  <div class="col-md-4">                     
    <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="pDiscription"/>
     </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">QTY</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="pQty"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">PRICE</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="pprice"/>
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="textarea">SUPPLIERNAME</label>
  <div class="col-md-4">                     
    <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="pCategoryName"/>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="textarea">CATEGORYNAME</label>
  <div class="col-md-4">                     
    <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="pSupplierName"/>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="textarea">Product Image</label>
  <div class="col-md-4">                     
    <form:input id="file" name="file" type="file" placeholder="" class="form-control input-md" path="productImage"/>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">ADD</button>
  </div>
</div>
</fieldset>
</form:form>
</c:if>


<c:if test="${check}">
 <form:form class="form-horizontal" action="putproduct" modelAttribute="ProModel">
<fieldset>

<!-- Form Name -->
<legend></legend>

   
<div class="form-group">
<!--   <label class="col-md-4 control-label" for="textinput">ID</label>   -->
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="hidden" placeholder="" class="form-control input-md" path="pId"/>
 </div>
</div>
   
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">NAME</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="pName"/>
 </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="textarea">DISCRIPTION</label>
  <div class="col-md-4">                     
    <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="pDiscription"/>
     </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">QTY</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="pQty"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">PRICE</label>  
  <div class="col-md-4">
  <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="pprice"/>
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="textarea">CATEGORYNAME</label>
  <div class="col-md-4">                     
    <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="pCategoryName"/>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="textarea">SUPPLIERNAME</label>
  <div class="col-md-4">                     
    <form:input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" path="pSupplierName"/>
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
     
     <div  class="container">
        <table id="table_id" class="table table-striped table-bordered table-list">
           <thead>
            <tr>
              
              <td><b>ID</b></td>
              <td><b>PRODUCT IMG</b></td>
              <td><b>NAME</b></td>
               <td><b>DISCRIPTION</b></td>
              <td><b>QTY</b></td>
              <td><b>PRICE</b></td>
               <td><b>SUPPLIERNAME</b></td>
              <td><b>CATEGORYNAME</b></td>
              <td><b>PRODUCT ACTION</b></td>
                 </tr>
                  </thead>
                   <tbody>
                    <c:forEach items="${ProTable}" var="p">
                      <tr>
                      
                      
                        <td>${p.getpId()}</td>
                        <td class=""><img style="vertical-align:bottom;" src="resources/productimages/${p.getpId()}.jpg  "width="100" height="60" /></td>
                         <td>${p.getpName()}</td>
                           <td>${p. getpDiscription()}</td>
                             <td>${p.  getpQty()}</td>
                                <td>${p. getPprice()}</td>
                                   <td>${p. getpSupplierName()}</td>
                                    <td>${p. getpCategoryName()}</td>
                                    <td>
                                       <div class="col-md-4">
                                       <a href="removepro/${p.getpId()}">
                                           <button id="removebuttons" type="button" class="btn btn-primary">DELETE</button></a>
                                           </div>
                                           <div class="col-md-4">    
                                         <a href="proedit?getpId=${p.getpId()}">
                                           <button id="editbuttons" type="button" class="btn btn-primary">EDIT</button>
                                           </a>
                                          </div>
                                          </td>
                                    </tr>
                                        </c:forEach>
                                               </tbody>
                                                    </table>
                                                    </div>
                  <br>
       <br>
       <br>
       <br>
       <br>
       <br>
       <br>                                                               
  <jsp:include page="footer.jsp"/>
  
  
 