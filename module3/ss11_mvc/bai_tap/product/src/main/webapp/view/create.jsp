<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add New Product</h1>
<a href="/product">Return Main Page</a>
<c:if test="${mess!=null}">
    <p style="color: red">${mess}</p>
</c:if>
<form method="post">
    <pre>Name:         <input type="text" name="name"> </pre>
    <c:if test="${error!=null}">
        <span style="color: red">${error.get("name")}</span>
    </c:if>
    <pre>Price:        <input type="text" name="price"> </pre>
    <c:if test="${error!=null}">
        <span style="color: red">${error.get("price")}</span>
    </c:if>
    <pre>Description:  <input type="text" name="description"> </pre>
    <c:if test="${error!=null}">
        <span style="color: red">${error.get("description")}</span>
    </c:if>
    <pre>Manufacture:  <input type="text" name="manufacture"> </pre>
    <c:if test="${error!=null}">
        <span style="color: red">${error.get("manufacture")}</span>
    </c:if>
    <pre>           <button>Save</button></pre>
</form>
</body>
</html>
