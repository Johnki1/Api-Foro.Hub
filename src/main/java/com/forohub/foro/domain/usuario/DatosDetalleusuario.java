package com.forohub.foro.domain.usuario;

import com.forohub.foro.domain.perfil.DatosPerfil;

import java.util.List;

public record DatosDetalleusuario(
        String nombre,
        String correoElectronico,
        String contrasena,
        List<DatosPerfil> perfiles
) {
}
