package com.forohub.foro.controller;


import com.forohub.foro.domain.respuesta.DatosCrearRespuesta;
import com.forohub.foro.domain.respuesta.DatosListarRespuesta;
import com.forohub.foro.domain.respuesta.RespuestaDto;
import com.forohub.foro.domain.respuesta.RespuestaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respuesta")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @PostMapping("{id}")
    public ResponseEntity<RespuestaDto> crearRespuesta(@Valid @RequestBody DatosCrearRespuesta datos, @PathVariable Long id){
        RespuestaDto respuesta = respuestaService.responderTopico(datos,id);
        return ResponseEntity.status(201).body(respuesta);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListarRespuesta>> listarRespuestas(Pageable paginacion) {
        Page<DatosListarRespuesta> respuestas = respuestaService.listarRespuestas(paginacion);
        return ResponseEntity.ok(respuestas);
    }
}
