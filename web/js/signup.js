function validar(){

    const msgNombre = document.getElementById("msgNombre");
    msgNombre.style.display = "none";

    const msgUser = document.getElementById("msgUser");
    msgUser.style.display = "none";
    
    
    const msgPassword = document.getElementById("msgPassword");
    msgPassword.style.display = "none";

    const msgPassword2 = document.getElementById("msgPassword2");
    msgPassword2.style.display = "none";
    

    const nombre = document.getElementById("nombre");
    const user = document.getElementById("user");
    const password = document.getElementById("password");
    const password2 = document.getElementById("password2");


    const valorNombre = nombre.value.trim();
    const valorUser = user.value.trim();
    const valorPassword = password.value.trim();
    const valorPassword2 = password2.value.trim();


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
        msgPassword.innerHTML = "La contraseña es obligatoria";
        msgPassword.style.display = "block";
        isValid = false;
    }

    if(valorPassword2 == ""){
        msgPassword2.innerHTML = "Debe repetir la contraseña";
        msgPassword2.style.display = "block";
        isValid = false;
    }

    if(valorPassword2 != valorPassword){
        msgPassword2.innerHTML = "Las contraseñas deben coincidir";
        msgPassword2.style.display = "block";
        isValid = false;
    }

    

    document.getElementById("nombreCompleto").value =  valorNombre + " " + valorApellido;

    return isValid;
}