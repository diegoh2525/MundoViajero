function all() {

    $.ajax({
        url: 'http://localhost:8080/v1/ProyectoFinalJDH/Reserva',
        method: 'GET',
        success: function (data) {
            // Limpiar el cuerpo de la tabla
            $('#loadData').empty();

            // Iterar sobre los datos y agregar filas a la tabla
            $.each(data, function (index, item) {
                if (item.fechaEliminacion == null) {
                    console.log(item);
                    $('#loadData').append(`
                    <tr>
                        <td>${item.usuarioId.id}</td>
                        <td>${item.transporteId.id}</td>
                        <td>${item.alojamientoId.id}</td>
                        <td>${item.actividadesId.id}</td>
                        <td>${item.estado === true ? 'Confirmada' : 'Cancelada'}</td>
                        <td>
                            <input type="button" class="btn btn-success" value="Editar" onclick="findById(`+ item.id + `)">
                            <input type="button" class="btn btn-warning" value="Eliminar" onclick="deleteLogical(`+ item.id + `)">
                            <input type="button" class="btn btn-danger" value="Eliminar" onclick="deletePhysical(`+ item.id + `)">
                        </td>
                    </tr>
                `);
                }
            });
        },
        error: function (error) {
            console.error('Error al cargar datos desde la API:', error);
        }
    });
}

function findById(id) {
    $.ajax({
        url: 'http://localhost:8080/v1/ProyectoFinalJDH/Reserva/' + id,
        method: 'GET',
        success: function (data) {
            $("#id").val(data.id);
            $("#usuarioId").val(data.usuarioId.id);
            $("#transporteId").val(data.transporteId.id);
            $("#alojamientoId").val(data.alojamientoId.id);
            $("#actividadesId").val(data.actividadesId.id);
            $("#estado").val(data.estado === true ? "1" : "0");

            // Cambiar el evento onclick y el valor del botón
            $("#botones input").attr("onclick", "update()").val("Actualizar");

        },
        error: function (error) {
            console.error('Error al cargar datos desde la API:', error);
        }
    });
}

function save() {
    // Crear un objeto JSON con los datos
    var nuevoUsuarioId = parseInt($("#usuarioId").val(), 10);
    var nuevoTransporteId = parseInt($("#transporteId").val(), 10);
    var nuevoAlojamientoId = parseInt($("#alojamientoId").val(), 10);
    var nuevoActividadesId = parseInt($("#actividadesId").val(), 10);

    // Crear un objeto JSON con la estructura similar a la de Postman
    var jsonData = {
        "usuarioId": {
            "id": nuevoUsuarioId
        },
        "transporteId": {
            "id": nuevoTransporteId
        },
        "alojamientoId": {
            "id": nuevoAlojamientoId
        },
        "actividadesId": {
            "id": nuevoActividadesId
        },
        "estado": ($("#estado").val() == "1" ? true : false)
    };

    // Enviar datos al servidor mediante AJAX
    $.ajax({
        url: 'http://localhost:8080/v1/ProyectoFinalJDH/Reserva',
        method: 'POST',  // Cambia a 'PUT' si es una actualización
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function (response) {
            alert('Datos guardados exitosamente:', response);
            // Puedes realizar acciones adicionales después de guardar los datos

            //Cargar o actaulizar los datos
            all();
            cleanData();
        },
        error: function (error) {
            alert('Error al guardar datos:', error);
        }
    });
}

function update() {

    // Crear un objeto JSON con los datos
    var nuevoUsuarioId = parseInt($("#usuarioId").val(), 10);
    var nuevoTransporteId = parseInt($("#transporteId").val(), 10);
    var nuevoAlojamientoId = parseInt($("#alojamientoId").val(), 10);
    var nuevoActividadesId = parseInt($("#actividadesId").val(), 10);

    // Crear un objeto JSON con los datos para la actualización
    var jsonData = {
        "usuarioId": {
            "id": nuevoUsuarioId
        },
        "transporteId": {
            "id": nuevoTransporteId
        },
        "alojamientoId": {
            "id": nuevoAlojamientoId
        },
        "actividadesId": {
            "id": nuevoActividadesId
        },
        "estado": ($("#estado").val() == "1" ? true : false)
    };

    // Enviar datos al servidor mediante AJAX
    $.ajax({
        url: 'http://localhost:8080/v1/ProyectoFinalJDH/Reserva/' + $("#id").val(),
        method: 'PUT',  // Cambia a 'PUT' si es una actualización
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function (response) {
            alert('Datos se modificaron exitosamente:', response);
            // Puedes realizar acciones adicionales después de guardar los datos

            //Cargar o actaulizar los datos
            all();
            cleanData();
        },
        error: function (error) {
            alert('Error al modificar datos:', error);
        }
    });
}

function deletePhysical(id) {

    // Enviar datos al servidor mediante AJAX
    $.ajax({
        url: 'http://localhost:8080/v1/ProyectoFinalJDH/Reserva/' + id,
        method: 'DELETE',  // Cambia a 'PUT' si es una actualización
        contentType: 'application/json',
        success: function (response) {
            alert('Datos se eliminó exitosamente de manera permanente:', response);
            // Puedes realizar acciones adicionales después de guardar los datos

            //Cargar o actaulizar los datos
            all();
            cleanData();
        },
        error: function (error) {
            alert('Error al eliminar dato:', error);
        }
    });
}

function deleteLogical(id) {
    // Crear un objeto JSON con los datos
    var jsonData = {
    };
    // Enviar datos al servidor mediante AJAX
    $.ajax({
        url: 'http://localhost:8080/v1/ProyectoFinalJDH/Reserva/' + id,
        method: 'PUT',  // Cambia a 'PUT' si es una actualización
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function (response) {
            alert('Dato se eliminó exitosamente:', response);
            // Puedes realizar acciones adicionales después de guardar los datos

            //Cargar o actaulizar los datos
            all();
        },
        error: function (error) {
            alert('Error al eliminar el registro:', error);
        }
    });
}

function cleanData() {
    $("#id").val("");
    $("#usuarioId").val("");
    $("#transporteId").val("");
    $("#alojamientoId").val("");
    $("#actividadesId").val("");
    $("#estado").val("");
}

