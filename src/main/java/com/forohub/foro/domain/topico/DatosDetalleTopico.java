package com.forohub.foro.domain.topico;

import com.forohub.foro.domain.curso.Curso;
import com.forohub.foro.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        Estado estado,
        Usuario usuario,
        Curso curso,
        LocalDateTime fecha
) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getEstado(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getFechaCreacion()
        );
    }
}
