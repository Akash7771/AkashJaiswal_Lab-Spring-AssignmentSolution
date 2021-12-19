<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<style>
    .container{
        width:800px;
        margin:0 auto;
        padding-top : 25px ;
    }
</style>
<body>
    <div class="container">
        <h1>OOPS!</h1>
        <h2>HTTP Status 403 - Access is denied</h2>
        <h3>${msg}</h3>
        <h5><a href="${pageContext.request.contextPath}/student-list">go to home page</h5>
    </div>
</body>
</html>