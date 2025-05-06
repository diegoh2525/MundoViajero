document.addEventListener("DOMContentLoaded", () => {
    cargarOpciones("transporte", "http://localhost:8080/v1/ProyectoFinalJDH/Transporte");
    cargarOpciones("alojamiento", "http://localhost:8080/v1/ProyectoFinalJDH/Alojamiento");
    cargarOpciones("actividad", "http://localhost:8080/v1/ProyectoFinalJDH/Actividades");

    const formReserva = document.getElementById("form-reserva");
    const mensaje = document.getElementById("mensaje-confirmacion");

    formReserva.addEventListener("submit", async (e) => {
        e.preventDefault();

        const nombreCliente = localStorage.getItem("nombreCliente") || "Anónimo";

        const reserva = {
            cliente: nombreCliente,
            transporte: document.getElementById("transporte").value,
            alojamiento: document.getElementById("alojamiento").value,
            actividad: document.getElementById("actividad").value,
            fecha: document.getElementById("fecha").value
        };

        try {
            const respuesta = await fetch("http://localhost:8080/v1/ProyectoFinalJDH/Reserva", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(reserva)
            });

            if (respuesta.ok) {
                mensaje.classList.remove("oculto");
                formReserva.reset();
            } else {
                alert("Hubo un error al realizar la reserva.");
            }
        } catch (error) {
            console.error("Error:", error);
            alert("Error de conexión con el servidor.");
        }
    });
});

async function cargarOpciones(idSelect, url) {
    try {
        const response = await fetch(url);
        const data = await response.json();

        const select = document.getElementById(idSelect);
        select.innerHTML = '<option value="">Selecciona...</option>';

        data.forEach(item => {
            const option = document.createElement("option");
            option.value = item.nombre || item.tipo || item.id;
            option.textContent = item.nombre || item.tipo;
            select.appendChild(option);
        });
    } catch (error) {
        console.error(`Error cargando ${idSelect}:`, error);
    }
}
