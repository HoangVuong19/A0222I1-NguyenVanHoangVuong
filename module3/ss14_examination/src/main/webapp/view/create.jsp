<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>

    <style>
        body {
            color: #566787;
            background: #f7f5f2;
            font-family: 'Roboto', sans-serif;
        }

        .table-responsive {
            margin: 30px 0;
        }

        .table-wrapper {
            min-width: 1000px;
            background: #fff;
            padding: 20px 25px;
            border-radius: 3px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }
    </style>
</head>
<body>
<div class="container-lg">
    <div class="table-responsive">
        <div class="table-wrapper">
            <h2>Add new product</h2>
            <c:if test="${mess!=null}">
                <p style="color: red">${mess}</p>
            </c:if>
            <form method="post" action="/products?action=add" class="row g-3">
                <div class="col-md-6">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                    <c:if test="${error!=null}">
                        <span style="color: red">${error.get("name")}</span>
                    </c:if>
                </div>
                <div class="col-md-6">
                    <label for="price" class="form-label">Price</label>
                    <input type="text" class="form-control" id="price" name="price" placeholder="Price">
                    <c:if test="${error!=null}">
                        <span style="color: red">${error.get("price")}</span>
                    </c:if>
                </div>
                <div class="col-12">
                    <label for="quantity" class="form-label">Quantity</label>
                    <input type="text" class="form-control" id="quantity" name="quantity" placeholder="Quantity">
                    <c:if test="${error!=null}">
                        <span style="color: red">${error.get("quantity")}</span>
                    </c:if>
                </div>
                <div class="col-12">
                    <label for="color" class="form-label">Color</label>
                    <input type="text" class="form-control" id="color" name="color" placeholder="Color">
                    <c:if test="${error!=null}">
                        <span style="color: red">${error.get("color")}</span>
                    </c:if>
                </div>
                <div class="col-md-12">
                    <label for="description" class="form-label">Description</label>
                    <textarea class="form-control" id="description" name="description" rows="3"></textarea>
                    <c:if test="${error!=null}">
                        <span style="color: red">${error.get("description")}</span>
                    </c:if>
                </div>
                <div class="col-md-12">
                    <label for="category" class="form-label">Category</label>
                    <select id="category" name="category" class="form-select">
                        <c:forEach var="cate" items="${categoryList}">
                            <option value="${cate.getId()}">${cate.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-success">Create</button>
                    <span> | </span>
                    <a class="btn btn-secondary" href="/products">Back</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
