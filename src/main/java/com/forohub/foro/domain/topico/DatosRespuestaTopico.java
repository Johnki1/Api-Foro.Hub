package com.forohub.foro.domain.topico;

import com.forohub.foro.domain.curso.DatosCurso;
import com.forohub.foro.domain.usuario.DatosUsuario;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        Estado estado,
        DatosUsuario usuario,
        DatosCurso curso,
        LocalDateTime fecha
) {
    public DatosRespuestaTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getEstado(),
                new DatosUsuario(
                        topico.getAutor().getNombre(),
                        topico.getAutor().getCorreoElectronico()
                ),
                new DatosCurso(
                        topico.getCurso().getNombre(),
                        topico.getCurso().getCategoria()),
                topico.getFechaCreacion()
        );
    }
}
