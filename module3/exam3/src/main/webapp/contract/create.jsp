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
            <h2>Add new contract</h2>
            <c:if test="${mess!=null}">
                <p style="color: red">${mess}</p>
            </c:if>
            <form method="post" action="/contracts?action=add" class="row g-3">
                <div class="col-md-6">
                    <label for="plantId" class="form-label">Mã mặt bằng</label>
                    <input type="text" class="form-control" id="plantId" name="plantId" placeholder="Mã mặt bằng">
                    <c:if test="${error!=null}">
                        <span style="color: red">${error.get("plantId")}</span>
                    </c:if>
                </div>
                <div class="col-md-6">
                    <label for="area" class="form-label">Diện tích</label>
                    <input type="text" class="form-control" id="area" name="area" placeholder="Diện tích">
                    <c:if test="${error!=null}">
                        <span style="color: red">${error.get("area")}</span>
                    </c:if>
                </div>
                <div class="col-md-6">
                    <label for="status" class="form-label">Trạng thái</label>
                    <select id="status" name="status" class="form-select">
                        <option>Trống</option>
                        <option>Hạ tầng</option>
                        <option>Đầy đủ</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label for="floor" class="form-label">Tầng</label>
                    <select id="floor" name="floor" class="form-select">
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
                <div class="col-md-6">
                    <label for="plantType" class="form-label">Loại văn phòng</label>
                    <select id="plantType" name="plantType" class="form-select">
                        <option>Cho thuê</option>
                        <option>Trọn gói</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label for="price" class="form-label">Giá cho thuê</label>
                    <input type="text" class="form-control" id="price" name="price" placeholder="Giá cho thuê">
                    <c:if test="${error!=null}">
                        <span style="color: red">${error.get("price")}</span>
                    </c:if>
                </div>
                <div class="col-12">
                    <label for="startDate" class="form-label">Ngày bắt đầu</label>
                    <input type="date" class="form-control" id="startDate" name="startDate">
                    <c:if test="${error!=null}">
                        <span style="color: red">${error.get("startDate")}</span>
                    </c:if>
                </div>
                <div class="col-12">
                    <label for="endDate" class="form-label">Ngày kết thúc</label>
                    <input type="date" class="form-control" id="endDate" name="endDate">
                    <c:if test="${error!=null}">
                        <span style="color: red">${error.get("endDate")}</span>
                    </c:if>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-success">Create</button>
                    <span> | </span>
                    <a class="btn btn-secondary" href="/contracts">Back</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
