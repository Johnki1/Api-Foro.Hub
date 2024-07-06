package com.forohub.foro.domain.usuario;

import com.forohub.foro.domain.perfil.DatosPerfil;

import java.util.List;

public record DatosListarUsuario(
        String nombre,
        String correoElectronico,
        List<DatosPerfil> perfiles
) {
    public DatosListarUsuario(Usuario usuario){
        this(
                usuario.getNombre(),
                usuario.getCorreoElectronico(),
                usuario.getPerfiles().stream().map(perfil -> new DatosPerfil(perfil.getNombre())).toList()
        );
    }
}
