package com.forohub.foro.domain.usuario;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DatosCrearUsuario(
        @NotNull(message = "Su nombre no puede estar vacio")
        String nombre,
        @NotNull(message = "Su correo no puede ser vacio")
        String correoElectronico,
        @NotNull(message = "Ingrese una contraseña fuerte")
        String contrasena,
        @NotNull(message = "digite el numero del perfil que pondra")
        List<Long> perfilId
) {
}
