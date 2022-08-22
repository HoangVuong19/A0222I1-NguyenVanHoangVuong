<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Product</h1>
<a href="/product">Return Main Page</a>
<form method="post">
    <pre>Name:         <input type="text" name="name" value="${requestScope["product"].getName()}"> </pre>
    <pre>Price:        <input type="text" name="price" value="${requestScope["product"].getPrice()}"> </pre>
    <pre>Description:  <input type="text" name="description" value="${requestScope["product"].getDescription()}"> </pre>
    <pre>Manufacture:  <input type="text" name="manufacture" value="${requestScope["product"].getManufacture()}"> </pre>
    <pre>           <button>Save</button></pre>
</form>
</body>
</html>
