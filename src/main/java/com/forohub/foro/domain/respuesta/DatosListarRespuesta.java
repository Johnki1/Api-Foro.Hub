package com.forohub.foro.domain.respuesta;

import com.forohub.foro.domain.topico.DatosRespuesta;
import com.forohub.foro.domain.usuario.DatosRespuestaUsuario;

import java.time.LocalDateTime;

public record DatosListarRespuesta(
        String mensaje,
        DatosRespuesta datosRespuesta,
        DatosRespuestaUsuario datosRespuestaUsuario,
        LocalDateTime fecha
) {
    public DatosListarRespuesta(String mensaje, DatosRespuesta datosRespuesta,
                                DatosRespuestaUsuario datosRespuestaUsuario, LocalDateTime fecha) {
        this.mensaje = mensaje;
        this.datosRespuesta = datosRespuesta;
        this.datosRespuestaUsuario = datosRespuestaUsuario;
        this.fecha = fecha;
    }
}