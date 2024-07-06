package com.forohub.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActualizarTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Estado estado

) {
}
