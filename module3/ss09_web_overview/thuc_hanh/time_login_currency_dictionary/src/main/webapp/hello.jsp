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
    <h1>Welcome ${name} to website</h1>

    <h2>Currency Converter</h2>
    <form action="/convert" method="post" >
        <label>Rate: </label><br/>
        <input type="text" name="rate" placeholder="RATE"/><br/>
        <label>USD: </label><br/>
        <input type="text" name="usd" placeholder="USD"/><br/>
        <input type="submit" id="submitConvert" value="Converter"/>
    </form>

    <h2>Vietnamese Dictionary</h2>
    <form action="/translate" method="post" >
        <input type="text" name="txtSearch" placeholder="Enter your word: "/>
        <input type="submit" id="submitTranslate" value="Search"/>
    </form>
</body>
</html>
