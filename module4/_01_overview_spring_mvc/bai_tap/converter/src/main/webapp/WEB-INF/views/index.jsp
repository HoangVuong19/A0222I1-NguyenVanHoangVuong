<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Currency Converter</h2>
  <form action="/converter" method="post">
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD"/><br/>
    <input type = "submit" id = "submit"/>
  </form>
  </body>
</html>
