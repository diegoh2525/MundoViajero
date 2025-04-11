async function login() {
    const correo = document.getElementById("correo").value;
    const password = document.getElementById("password").value;

    const datos = {
        correo: correo,
        password: password
    };

    try {
        const response = await fetch("http://localhost:8080/v1/ProyectoFinalJDH/Usuario/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(datos)
        });

        if (!response.ok) {
            throw new Error("Credenciales incorrectas");
        }

        const usuario = await response.json();
        console.log("Usuario logueado:", usuario);

        // Aquí puedes guardar el usuario en localStorage o redirigir a otra página
        // localStorage.setItem("usuario", JSON.stringify(usuario));
        window.location.href = "/index.html"; // redirige al index, o cambia por donde quieras ir

    } catch (error) {
        alert(error.message);
    }
}
