package com.forohub.foro.domain.respuesta;

import com.forohub.foro.domain.topico.DatosRespuesta;
import com.forohub.foro.domain.usuario.DatosRespuestaUsuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RespuestaDto(
        Long id,
        String mensaje,
        DatosRespuesta datosRespuesta,
        DatosRespuestaUsuario datosRespuesaUsuario,
        LocalDateTime fecha
) {
}
