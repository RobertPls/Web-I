function validar(){

    const msgNombre = document.getElementById("msgNombre");
    msgNombre.style.display = "none";

    const msgUser = document.getElementById("msgUser");
    msgUser.style.display = "none";
    
    
    const msgPassword = document.getElementById("msgPassword");
    msgPassword.style.display = "none";
    

    const nombre = document.getElementById("nombre");
    const user = document.getElementById("user");
    const password = document.getElementById("password");


    const valorNombre = nombre.value.trim();
    const valorUser = user.value.trim();
    const valorPassword = password.value.trim();

    let isValid = true;

    if(valorNombre == ""){
        msgNombre.innerHTML = "El nombre es obligatorio";
        msgNombre.style.display = "block";
        isValid = false;
    }

    if(valorUser == ""){
        msgUser.innerHTML = "El Usuario es obligatorio";
        msgUser.style.display = "block";
        isValid = false;
    }

    if(valorPassword == ""){
        msgPassword.innerHTML = "La contraseña es obligatorio";
        msgPassword.style.display = "block";
        isValid = false;
    }

    document.getElementById("nombreCompleto").value =  valorNombre + " " + valorApellido;

    return isValid;
}