package com.forohub.foro.domain.topico;

import com.forohub.foro.domain.curso.Curso;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistrarTopico(
        @NotNull(message = "Ingrese su Id de usuario")
        Long idUsuario,
        @NotNull(message = "Titulo obligatorio")
        String titulo,
        @NotNull(message = "Mensaje obligatorio")
        String mensaje,
        @NotNull(message = "Nombre del curso obligatorio")
        Long cursoId
) {
        public DatosRegistrarTopico(Long idUsuario, String titulo, String mensaje, Long cursoId){
                this.idUsuario = idUsuario;
                this.titulo= titulo;
                this.mensaje=mensaje;
                this.cursoId = cursoId;
        }
}
