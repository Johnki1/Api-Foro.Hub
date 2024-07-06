package com.forohub.foro.domain.topico;

import com.forohub.foro.domain.curso.Curso;
import com.forohub.foro.domain.usuario.Usuario;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoDTO(
        Long id,
        @NotNull(message = "No debe haber un titulo repetido")
        String titulo,
        @NotNull(message = "Su mensaje no debe superar los 700 caracteres")
        String mensaje,
        @NotNull(message = "Seleccione un estado valido")
        Estado estado,
        @NotNull(message = "Debe ingresar su ID")
        Long autorId,
        @NotNull(message = "Ingrese el curso")
        Long cursoId,
        LocalDateTime fecha
) {

}
