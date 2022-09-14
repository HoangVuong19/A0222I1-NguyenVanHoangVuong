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
            <h2>Edit contract</h2>
            <form method="post" class="row g-3">
                <div class="col-md-6">
                    <label for="date" class="form-label">Date</label>
                    <input type="text" class="form-control" id="date" name="date" placeholder="yyyy-MM-dd"
                           value="${contract.getDate()}">
                </div>
                <div class="col-md-6">
                    <label for="status" class="form-label">Status</label>
                    <select id="status" name="status" class="form-select">
                        <option>Đang thuê</option>
                        <option>Đã trả</option>
                    </select>
                </div>
                <div class="col-12">
                    <label for="rentAmount" class="form-label">Rent Amount</label>
                    <input type="text" class="form-control" id="rentAmount" name="rentAmount" placeholder="Rent Amount"
                           value="${contract.getRentAmount()}">
                </div>
                <div class="col-12">
                    <label for="bookId" class="form-label">Book name</label>
                    <c:forEach var="b" items="${bookList}">
                        <c:if test="${b.getId() == contract.getBookId()}">
                            <input hidden name="bookId" id="bookId" value="${b.getId()}">
                            <p class="form-control">${b.getName()}</p>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="col-md-12">
                    <label for="customerId" class="form-label">Customer name</label>
                    <select id="customerId" name="customerId" class="form-select">
                        <c:forEach var="c" items="${customerList}">
                            <option value="${c.getId()}">${c.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-success">Edit</button>
                    <span> | </span>
                    <a class="btn btn-secondary" href="/contracts">Back</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

