<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                    <form action="/contracts?action=search" method="post">
                        <div class="col-sm-2 d-inline-block">
                            <label for="plantType" class="form-label">Loại mặt bằng</label>
                            <select id="plantType" name="plantType" class="headers form-select">
                                <option>Cho thuê</option>
                                <option>Trọn gói</option>
                            </select>
                        </div>
                        <div class="col-sm-2 d-inline-block">
                            <label for="floor" class="form-label">Tầng</label>
                            <select id="floor" name="floor" class="headers form-select">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                                <option>11</option>
                                <option>12</option>
                                <option>13</option>
                                <option>14</option>
                                <option>15</option>
                            </select>
                        </div>
                        <div class="col-sm-2 d-inline-block">
                            <label for="price" class="form-label">Giá</label>
                            <input type="text" id="price" name="price" class="headers form-control"
                                   placeholder="Giá cho thuê">
                        </div>
                        <div class="col-sm-2 d-inline-block">
                            <label for="startDate" class="form-label">Ngày bắt đầu</label>
                            <input type="date" id="startDate" name="startDate" class="headers form-control">

                        </div>
                        <div class="col-sm-2 d-inline-block">
                            <label for="endDate" class="form-label">Ngày kết thúc</label>
                            <input type="date" id="endDate" name="endDate" class="headers form-control">
                        </div>
                        <div class="col-sm-2">
                            <input class="btn btn-primary headers" type="submit" value="Search">
                        </div>
                    </form>
                </div>
            </div>
            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <div class="col-sm-12 d-inline-block">
                        <a class="btn btn-primary headers" href="/contracts?action=create">Add new contract</a>
                    </div>
                    <p style="text-align: center">Contract List</p>
                </tr>
                <tr>
                    <th>Mã MB</th>
                    <th>Diện tích</th>
                    <th>Trạng thái</th>
                    <th>Tầng</th>
                    <th>Loại văn phòng</th>
                    <th>Giá cho thuê</th>
                    <th>Ngày bắt đầu</th>
                    <th>Ngày kết thúc</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${contractList}">
                    <tr>
                        <td>${c.getPlantId()}</td>
                        <td>${c.getArea()}</td>
                        <td>${c.getStatus()}</td>
                        <td>${c.getFloor()}</td>
                        <td>${c.getPlantType()}</td>
                        <td>${c.getPrice()}</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${c.getStartDate()}"/></td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${c.getEndDate()}"/></td>
                        <td>
                            <button type="button" onclick="deleteInfo('${c.getId()}','${c.getPlantId()}')"
                                    class="delete"
                                    data-bs-toggle="modal" data-bs-target="#modal1">
                                <i class="material-icons">&#xE872;</i>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


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
                    <span>Bạn có chắc chắn muốn xoá mặt bằng với mã số </span><span id="deletePlantId"></span><span> không?</span>
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
    function deleteInfo(id, plantId) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deletePlantId").innerText = plantId;
    }
</script>
</body>
</html>
