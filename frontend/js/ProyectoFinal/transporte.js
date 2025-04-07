function all(){

    $.ajax({
        url: 'http://localhost:9000/v1/ProyectoFinalJDH/Transporte', // Reemplaza con la URL de tu API
        method: 'GET',
        success: function(data) {
            // Limpiar el cuerpo de la tabla
            $('#loadData').empty();

            // Iterar sobre los datos y agregar filas a la tabla
            $.each(data, function(index, item) {
                if(item.fechaEliminacion == null){
                    $('#loadData').append(`
                    <tr>
                        <td>${item.tipo}</td>
                        <td>${item.empresa}</td>
                        <td>${item.origen}</td>
                        <td>${item.destino}</td>
                        <td>${item.fechaInicio}</td>
                        <td>${item.fechaFinal}</td>
                        <td>${item.horaViajeida}</td>
                        <td>${item.horaViajevuelta}</td>
                        <td>${item.costo}</td>
                        <td>
                            <input type="button" class="btn btn-success" value="Editar" onclick="findById(`+item.id+`)">
                            <input type="button" class="btn btn-warning" value="Eliminar" onclick="deleteLogical(`+item.id+`)">
                            <input type="button" class="btn btn-danger" value="Eliminar" onclick="deletePhysical(`+item.id+`)">
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
        url: 'http://localhost:9000/v1/ProyectoFinalJDH/Transporte/'+id, // Reemplaza con la URL de tu API
        method: 'GET',
        success: function(data) {
            $("#id").val(data.id);
            $("#tipo").val(data.tipo);
            $("#empresa").val(data.empresa);
            $("#origen").val(data.origen);
            $("#destino").val(data.destino);
            $("#fechaInicio").val(data.fechaInicio);
            $("#fechaFinal").val(data.fechaFinal);
            $("#horaViajeida").val(data.horaViajeida);
            $("#horaViajevuelta").val(data.horaViajevuelta);
            $("#costo").val(data.costo);

            // Cambiar el evento onclick y el valor del botón
            $("#botones input").attr("onclick", "update()").val("Actualizar");

        },
        error: function(error) {
            console.error('Error al cargar datos desde la API:', error);
        }
    });
}

function save(){    
     // Crear un objeto JSON con los datos
     var jsonData = {
         "tipo": $("#tipo").val(),
         "empresa": $("#empresa").val(),
         "origen": $("#origen").val(),
         "destino": $("#destino").val(),
         "fechaInicio": $("#fechaInicio").val(),
         "fechaFinal": $("#fechaFinal").val(),
         "horaViajeida": $("#horaViajeida").val(),
         "horaViajevuelta": $("#horaViajevuelta").val(),
         "costo": $("#costo").val(),
     };

     // Enviar datos al servidor mediante AJAX
     $.ajax({
         url: 'http://localhost:9000/v1/ProyectoFinalJDH/Transporte', // Reemplaza con la URL de tu API
         method: 'POST',  // Cambia a 'PUT' si es una actualización
         contentType: 'application/json',
         data: JSON.stringify(jsonData),
         success: function(response) {
             alert('Datos guardados exitosamente:', response);
             // Puedes realizar acciones adicionales después de guardar los datos

             //Cargar o actaulizar los datos
             all();
             cleanData();
         },
         error: function(error) {
             alert('Error al guardar datos:', error);
         }
     });
}

function update(){

    // Crear un objeto JSON con los datos
    var jsonData = {
        "tipo": $("#tipo").val(),
        "empresa": $("#empresa").val(),
        "origen": $("#origen").val(),
        "destino": $("#destino").val(),
        "fechaInicio": $("#fechaInicio").val(),
        "fechaFinal": $("#fechaFinal").val(),
        "horaViajeida": $("#horaViajeida").val(),
        "horaViajevuelta": $("#horaViajevuelta").val(),
        "costo": $("#costo").val(),
    };

    // Enviar datos al servidor mediante AJAX
    $.ajax({
        url: 'http://localhost:9000/v1/ProyectoFinalJDH/Transporte/'+$("#id").val(), // Reemplaza con la URL de tu API
        method: 'PUT',  // Cambia a 'PUT' si es una actualización
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function(response) {
            alert('Datos se modificaron exitosamente:', response);
            // Puedes realizar acciones adicionales después de guardar los datos

            //Cargar o actaulizar los datos
            all();
            cleanData();
        },
        error: function(error) {
            alert('Error al modificar datos:', error);
        }
    });    
}

function deletePhysical(id){
 
    // Enviar datos al servidor mediante AJAX
    $.ajax({
        url: 'http://localhost:9000/v1/ProyectoFinalJDH/Transporte/'+id, // Reemplaza con la URL de tu API
        method: 'DELETE',  // Cambia a 'PUT' si es una actualización
        contentType: 'application/json',
        success: function(response) {
            alert('Datos se eliminó exitosamente de manera permanente:', response);
            // Puedes realizar acciones adicionales después de guardar los datos

            //Cargar o actaulizar los datos
            all();
            cleanData();
        },
        error: function(error) {
            alert('Error al eliminar dato:', error);
        }
    });  
}

function deleteLogical(id){
   // Crear un objeto JSON con los datos
    var jsonData = {
    };
    // Enviar datos al servidor mediante AJAX
    $.ajax({
        url: 'http://localhost:9000/v1/ProyectoFinalJDH/Transporte/deleteLogical/'+id, // Reemplaza con la URL de tu API
        method: 'PUT',  // Cambia a 'PUT' si es una actualización
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function(response) {
            alert('Dato se eliminó exitosamente:', response);
            // Puedes realizar acciones adicionales después de guardar los datos

            //Cargar o actaulizar los datos
            all();
        },
        error: function(error) {
            alert('Error al eliminar el registro:', error);
        }
    });  
}

function cleanData(){
    $("#id").val("");
    $("#tipo").val("");
    $("#empresa").val("");
    $("#origen").val("");
    $("#destino").val("");
    $("#fechaInicio").val("");
    $("#fechaFinal").val("");
    $("#horaViajeida").val("");
    $("#horaViajevuelta").val("");
    $("#costo").val("");
}

