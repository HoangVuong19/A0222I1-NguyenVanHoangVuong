function addPhone() {
    let producer = $('#producer').val();
    let model = $('#model').val();
    let price = $('#price').val();
    let data = {
        producer: producer,
        model: model,
        price: price
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(data),
        url: "http://localhost:8080/phone/create",
        success: successHandler
    });
}

function successHandler() {
    $.ajax({
        dataType: 'json',
        type: "GET",
        url: "http://localhost:8080/phone/list",
        success: function (event) {
            let content = '<table class="table table-striped"> <thead>    <tr>\n' +
                '        <td>Producer</td>\n' +
                '        <td>Model</td>\n' +
                '        <td>Price</td>\n' +
                '        <td>Edit</td>\n' +
                '        <td>Delete</td>\n' +
                '    </tr> </thead> <tbody>';
            for (let i = 0; i < event.length; i++) {
                content += getPhone(event[i]);
            }
            content += "</tbody></table>"
            document.getElementById('phoneList').innerHTML = content;
        }
    });

}
successHandler();

function getPhone(phone) {
    return `<tr><td>${phone.producer}</td>
                <td>${phone.model}</td>
                <td >${phone.price}</td>
                <td>
                    <button onclick="showFormEdit(${phone.id},'${phone.producer}','${phone.model}',${phone.price})" type="button"
                    class="btn btn-outline-warning"
                    data-bs-toggle="modal" data-bs-target="#editModal">
                    <i class="fa-solid fa-highlighter"></i></button> 
                </td>
                <td><button id="btnDelete" onclick="deletePhone(${phone.id})">Delete</button></td>
            </tr>`;
}

function showFormEdit(id, producer, model, price) {
    document.getElementById("idEdit").value = id;
    document.getElementById("edit-producer").value = producer;
    document.getElementById("edit-model").value = model;
    document.getElementById("edit-price").value = price;
}

function editPhone() {
    let newId = $('#idEdit').val();
    let newProducer = $('#edit-producer').val();
    let newModel = $('#edit-model').val();
    let newPrice = $('#edit-price').val();
    let data = {
        id: newId,
        producer: newProducer,
        model: newModel,
        price: newPrice
    }
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/phone/edit",
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(data),
        success: successHandler,
    });
    $('#editModal').modal("hide")
}

function deletePhone(id) {
    let phoneId = id;
    $.ajax({
        type: "DELETE",
        url: `http://localhost:8080/phone/delete/${phoneId}`,
        success: function () {
            successHandler();
        }

    });
}


