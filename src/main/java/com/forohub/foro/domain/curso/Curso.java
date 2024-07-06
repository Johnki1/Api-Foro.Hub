package com.forohub.foro.domain.curso;
import com.forohub.foro.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;

    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;

    public Curso(DatosCurso datosCurso){
        this.nombre = datosCurso.nombre();
        this.categoria = datosCurso.categoria();

    }

}
