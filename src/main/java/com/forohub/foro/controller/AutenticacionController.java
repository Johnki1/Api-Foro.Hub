package com.forohub.foro.controller;

import com.forohub.foro.domain.usuario.DatosAutenticacionUsuaio;
import com.forohub.foro.domain.usuario.Usuario;
import com.forohub.foro.infra.security.DatosJWTToken;
import com.forohub.foro.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticacion(@RequestBody @Valid DatosAutenticacionUsuaio datosAutenticacionUsuaio){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuaio.nombre(),
                datosAutenticacionUsuaio.contrasena());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);

        var token = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(token));
    }
}
