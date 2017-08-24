<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"></jsp:include>

<body>
<div class="container">
   
    <form:form  action="getreg" modelAttribute="RegModel" method="post">
    <br>
    <br>
    <label>USERNAME</label>
    <br>
    <form:input type="text"  name="Username" path="Username"/>
    <br>
    <br>
    <label>EMAIL ADDRESS</label>
    <br>
    <form:input type="Email" name="Email"  path="Email"/>
    <br>
    <br>
    <label>PASSWORD</label>
    <br>
    <form:input type="password" name="Upassword" path="Upassword"/>
    <br>
    <br>
    <button type="submit" value="Sign up" class="btn btn-primary">SIGN UP</button>
    <br>
    <div class="clearfix"></div>
    <br>
    </form:form>
</div>
</body>

<jsp:include page="footer.jsp"></jsp:include>
