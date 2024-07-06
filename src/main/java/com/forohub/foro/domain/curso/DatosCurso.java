package com.forohub.foro.domain.curso;

import com.forohub.foro.domain.topico.Topico;
import jakarta.persistence.OneToMany;

import java.util.List;

public record DatosCurso(
        String nombre,
        String categoria
) {
}
