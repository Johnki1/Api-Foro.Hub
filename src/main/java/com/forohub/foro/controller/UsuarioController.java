package com.forohub.foro.controller;

import com.forohub.foro.domain.usuario.DatosCrearUsuario;
import com.forohub.foro.domain.usuario.DatosDetalleusuario;
import com.forohub.foro.domain.usuario.DatosListarUsuario;
import com.forohub.foro.domain.usuario.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<DatosDetalleusuario> crearUsuario(@RequestBody @Valid DatosCrearUsuario datos){
        var usuarioCreado = usuarioService.crearUsuario(datos);
        return ResponseEntity.status(201).body(usuarioCreado);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListarUsuario>> listarUsuario(@PageableDefault(size = 20) Pageable paginacion) {
        var usuarios = usuarioService.listarUsuarios(paginacion);
        return ResponseEntity.ok().body(usuarios);
    }

}
