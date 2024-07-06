package com.forohub.foro.controller;

import com.forohub.foro.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<?> registrarTopico(@Valid @RequestBody DatosRegistrarTopico datos) {
        if (topicoService.isTituloMensajeDuplicado(datos.titulo(), datos.mensaje())) {
            return ResponseEntity.status(409).body("Tópico duplicado");
        }

        TopicoDTO topicoDTO = topicoService.registrarTopico(datos);
        return ResponseEntity.status(201).body(topicoDTO);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListarTopico>> listadoTopico(@PageableDefault(size = 20) Pageable paginacion) {
        Page<DatosListarTopico> topicos = topicoService.listarTopicos(paginacion);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DatosRespuestaTopico>> getTopicoById(@PathVariable Long id) {
        var getByIdTopico = topicoService.getTopicoById(id);
        return ResponseEntity.ok(getByIdTopico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@PathVariable Long id, @Valid @RequestBody ActualizarTopico dto) {
        Optional<DatosRespuestaTopico> topico = topicoService.actualizarTopico(id, dto);
        return topico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        if (topicoService.eliminarTopico(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/del/{id}")
    @Transactional
    public ResponseEntity<Void> desactivarTopico(@PathVariable Long id){
        topicoService.desactivarTopico(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/act/{id}")
    @Transactional
    public ResponseEntity<Void> activarTopico(@PathVariable Long id) {
        if (topicoService.activarTopico(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
