package com.forohub.foro.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicoRepository  extends JpaRepository<Topico,Long> {

    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    Page<Topico> findByActivoTrue(Pageable pageable);

}
