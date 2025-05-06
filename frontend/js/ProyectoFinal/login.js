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

    // 👇 Guardamos el nombre del usuario para futuras páginas
    localStorage.setItem("nombreCliente", usuario.nombre);

    window.location.href = window.location.href = "vista-cliente.html";

  } catch (error) {
    document.getElementById("error-msg").textContent = error.message;
  }
}

function toggleRegister() {
  const modal = document.getElementById("register-form");
  modal.style.display = modal.style.display === "flex" ? "none" : "flex";
}

async function registrarUsuario() {
  const nombre = document.getElementById("reg-nombre").value;
  const correo = document.getElementById("reg-correo").value;
  const password = document.getElementById("reg-password").value;
  const errorMsg = document.getElementById("registro-msg");

  if (!nombre || !correo || !password) {
    errorMsg.textContent = "Por favor, completa todos los campos.";
    return;
  }

  const datos = {
    nombre,
    correo,
    password,
    estado: true
  };

  try {
    const response = await fetch("http://localhost:8080/v1/ProyectoFinalJDH/Usuario", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(datos)
    });

    if (!response.ok) {
      throw new Error("Error al registrar usuario");
    }

    alert("Usuario registrado con éxito");
    toggleRegister(); // Cierra el modal

    // Limpia campos del formulario
    document.getElementById("reg-nombre").value = "";
    document.getElementById("reg-correo").value = "";
    document.getElementById("reg-password").value = "";
    errorMsg.textContent = "";

  } catch (error) {
    errorMsg.textContent = error.message;
  }
}