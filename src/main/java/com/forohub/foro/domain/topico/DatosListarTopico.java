package com.forohub.foro.domain.topico;

import java.time.LocalDateTime;

public record DatosListarTopico(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso,
        LocalDateTime fecha
) {
    public DatosListarTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor().getNombre(),topico.getCurso().getNombre(),topico.getFechaCreacion());
    }
}
