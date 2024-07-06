package com.forohub.foro.domain.usuario;

import com.forohub.foro.domain.perfil.DatosPerfil;
import com.forohub.foro.domain.perfil.Perfil;
import com.forohub.foro.domain.perfil.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerfilRepository perfilRepository;

    public DatosDetalleusuario crearUsuario (DatosCrearUsuario datos){
        String password = passwordEncoder.encode(datos.contrasena());
        List<Perfil> perfiles = perfilRepository.findAllById(datos.perfilId());

        Usuario usuario = new Usuario();
        usuario.setNombre(datos.nombre());
        usuario.setCorreoElectronico(datos.correoElectronico());
        usuario.setContrasena(password);
        usuario.setPerfiles(perfiles);
        usuarioRepository.save(usuario);

        List<DatosPerfil> datosPerfils = usuario.getPerfiles().stream()
                .map(perfil -> new DatosPerfil(perfil.getNombre())).collect(Collectors.toList());

        return new DatosDetalleusuario(
                datos.nombre(),
                datos.correoElectronico(),
                datos.contrasena(),
                datosPerfils
        );
    }

    public Page<DatosListarUsuario> listarUsuarios(Pageable pageable) {
        return usuarioRepository.findAll(pageable).map(DatosListarUsuario::new);
    }

}
