package com.forohub.foro.domain.respuesta;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosCrearRespuesta(
        @NotNull(message = "Tu texto en mensaje no puede estar vacio")
        String mensaje
) {
}
