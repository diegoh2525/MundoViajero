function all(){
    $.ajax({
        url: 'http://localhost:8080/v1/ProyectoFinalJDH/Usuario',
        method: 'GET',
        success: function(data) {
            $('#loadData').empty();
            $.each(data, function(index, item) {
                if(item.fechaEliminacion == null){
                    $('#loadData').append(`
                        <tr>
                            <td>${item.nombre}</td>
                            <td>${item.correo}</td>
                            <td>${item.password}</td>
                            <td>${item.estado ? 'Activo' : 'Inactivo'}</td>
                            <td>
                                <input type="button" class="btn btn-success" value="Editar" onclick="findById(${item.id})">
                                <input type="button" class="btn btn-warning" value="Eliminar Lógico" onclick="deleteLogical(${item.id})">
                                <input type="button" class="btn btn-danger" value="Eliminar Físico" onclick="deletePhysical(${item.id})">
                            </td>
                        </tr>
                    `);
                }
            });
        },
        error: function(error) {
            console.error('Error al cargar datos desde la API:', error);
        }
    });
}

function findById(id){
    $.ajax({
        url: 'http://localhost:8080/v1/ProyectoFinalJDH/Usuario/' + id,
        method: 'GET',
        success: function(data) {
            $("#id").val(data.id);
            $("#nombre").val(data.nombre);
            $("#correo").val(data.correo);
            $("#password").val(data.password);
            $("#estado").val(data.estado.toString());
            $("#botones input").attr("onclick", "update()").val("Actualizar");
        },
        error: function(error) {
            console.error('Error al buscar usuario:', error);
        }
    });
}

function save(){
    var jsonData = {
        "nombre": $("#nombre").val(),
        "correo": $("#correo").val(),
        "password": $("#password").val(),
        "estado": $("#estado").val() === "true"
    };

    $.ajax({
        url: 'http://localhost:8080/v1/ProyectoFinalJDH/Usuario',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function(response) {
            alert('Datos guardados exitosamente');
            all();
            cleanData();
        },
        error: function(error) {
            alert('Error al guardar datos');
        }
    });
}

function update(){
    var jsonData = {
        "nombre": $("#nombre").val(),
        "correo": $("#correo").val(),
        "password": $("#password").val(),
        "estado": $("#estado").val() === "true"
    };

    $.ajax({
        url: 'http://localhost:8080/v1/ProyectoFinalJDH/Usuario/' + $("#id").val(),
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function(response) {
            alert('Datos actualizados exitosamente');
            all();
            cleanData();
            $("#botones input").attr("onclick", "save()").val("Guardar");
        },
        error: function(error) {
            alert('Error al actualizar datos');
        }
    });
}

function deletePhysical(id){
    $.ajax({
        url: 'http://localhost:8080/v1/ProyectoFinalJDH/Usuario/' + id,
        method: 'DELETE',
        success: function(response) {
            alert('Usuario eliminado permanentemente');
            all();
            cleanData();
        },
        error: function(error) {
            alert('Error al eliminar usuario');
        }
    });
}

function deleteLogical(id){
    $.ajax({
        url: 'http://localhost:8080/v1/ProyectoFinalJDH/Usuario/deleteLogical/' + id,
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({}),
        success: function(response) {
            alert('Usuario eliminado lógicamente');
            all();
        },
        error: function(error) {
            alert('Error al eliminar lógicamente');
        }
    });
}

function cleanData(){
    $("#id").val("");
    $("#nombre").val("");
    $("#correo").val("");
    $("#password").val("");
    $("#estado").val("true");
}
