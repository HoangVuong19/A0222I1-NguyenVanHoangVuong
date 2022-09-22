<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Calculator</h2>
  <form method="post" action="/calculator">
    <div>
      <input name="num1">
      <input name="num2">
      <input type="hidden" name="operator" id="operator">
    </div>
    <div>
      <button type="submit" onclick="document.getElementById('operator').value = '+'">Addition (+)</button>
      <button type="submit" onclick="document.getElementById('operator').value = '-'">Subtraction (-)</button>
      <button type="submit" onclick="document.getElementById('operator').value = '*'">Multiplication (*)</button>
      <button type="submit" onclick="document.getElementById('operator').value = '/'">Division (/)</button>
    </div>
  </form>

  Result: ${result}
  </body>
</html>
