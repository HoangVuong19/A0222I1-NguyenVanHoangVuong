<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculate</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <style>
        h1{
            text-align: center;
        }

        form {
            position: relative;
            width: 200px;
            left: 600px;
        }

        div {
            width: 200px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h1>Simple Calculator</h1>

<form method="post" action="/calculate">
    <div><label>First Operand:</label> <input class="form-control form-control-lg" name="first"></div>
    <div><label>Operator:</label> <select class="form-select" aria-label="Default select example" name="operator">
        <option value="addition">Addition</option>
        <option value="subtraction">Subtraction</option>
        <option value="multiplication">Multiplication</option>
        <option value="division">Division</option>
    </select></div>
    <div><label>Second Operand:</label> <input class="form-control form-control-lg" name="second"></div>
    <div>
        <input type="submit" value="Calculate">
    </div>
</form>
</body>
</html>