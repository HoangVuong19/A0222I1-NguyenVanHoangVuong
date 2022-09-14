<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
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

        .table-title {
            color: #fff;
            background: #40b2cd;
            padding: 16px 25px;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }

        .headers {
            height: 35px;
        }

        table.table td a.edit {
            color: #FFC107;
        }

        table.table td button.delete {
            border: none;
            background: none;
            color: #E34724;
        }
    </style>
</head>
<body>
<div class="container-lg">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8">
                        <a class="btn btn-primary headers" href="/contracts?action=create">Add new contract</a>
                    </div>
                    <div class="col-sm-4">
                        <form action="/contracts?action=search" method="post">
                            <input class="headers" type="text" name="search" value="${character}"
                                   placeholder="Search by book name">
                            <input class="btn btn-primary headers" type="submit" value="Search">
                        </form>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <p>Contract List</p>
                </tr>
                <tr>
                    <th>#</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Rent amount</th>
                    <th>Book name</th>
                    <th>Customer name</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="con" items="${contractList}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${con.getDate()}</td>
                        <td>${con.getStatus()}</td>
                        <td>${con.getRentAmount()}</td>
                        <c:forEach var="b" items="${bookList}">
                            <c:if test="${b.getId() == con.getBookId()}">
                                <td>${b.getName()}</td>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="c" items="${customerList}">
                            <c:if test="${c.getId() == con.getCustomerId()}">
                                <td>${c.getName()}</td>
                            </c:if>
                        </c:forEach>
                        <td>
                            <a href="/contracts?action=edit&id=${con.getId()}" class="edit"><i class="material-icons">&#xE254;</i></a>
                            <button type="button" onclick="deleteInfo('${con.getId()}')"
                                    class="delete"
                                    data-bs-toggle="modal" data-bs-target="#modal1">
                                <i class="material-icons">&#xE872;</i>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="col-sm-12">
                <a class="btn btn-primary" href="/customers">Show list Customer</a>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="modal1" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form method="post" action="/contracts?action=delete">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalLabel">Modal title</h5>
                    <input hidden name="id" id="deleteId">
                </div>
                <div class="modal-body">
                    <span>Bạn có muốn xoá sản phẩm không?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">OK</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    function deleteInfo(id) {
        document.getElementById("deleteId").value = id;
    }
</script>
</body>
</html>