<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        input {
            padding: 5px;
            margin: 5px
        }
    </style>
</head>
<body>
<h2>Currency Converter</h2>
<form method="post" action="/convert">
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD"/><br/>
    <input type="submit" id="submit" value="Converter"/>
</form>
</body>
</html>
