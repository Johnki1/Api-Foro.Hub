package com.forohub.foro.domain.topico;

import com.forohub.foro.domain.curso.Curso;
import com.forohub.foro.domain.curso.CursoRepository;
import com.forohub.foro.domain.curso.DatosCurso;
import com.forohub.foro.domain.usuario.DatosUsuario;
import com.forohub.foro.domain.usuario.Usuario;
import com.forohub.foro.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public TopicoDTO registrarTopico(DatosRegistrarTopico datos) {
        Optional<Usuario> autor = usuarioRepository.findById(datos.idUsuario());
        Optional<Curso> curso = cursoRepository.findById(datos.cursoId());

        if (autor.isPresent() && curso.isPresent()) {
            Topico topico = new Topico();
            topico.setTitulo(datos.titulo());
            topico.setMensaje(datos.mensaje());
            topico.setFechaCreacion(LocalDateTime.now());
            topico.setEstado(Estado.ACTIVO);
            topico.setAutor(autor.get());
            topico.setCurso(curso.get());
            topico.setActivo(true);

            topicoRepository.save(topico);

            return new TopicoDTO(
                    topico.getId(),
                    topico.getTitulo(),
                    topico.getMensaje(),
                    topico.getEstado(),
                    topico.getAutor().getId(),
                    topico.getCurso().getId(),
                    topico.getFechaCreacion()


            );
        } else {
            throw new IllegalArgumentException("Autor o curso no encontrado");
        }
    }

    public boolean isTituloMensajeDuplicado(String titulo, String mensaje) {
        return topicoRepository.existsByTituloAndMensaje(titulo, mensaje);
    }

    public Page<DatosListarTopico> listarTopicos(Pageable paginacion) {
        return topicoRepository.findByActivoTrue(paginacion).map(DatosListarTopico::new);
    }

    public Optional<DatosRespuestaTopico> getTopicoById(Long id) {
        return topicoRepository.findById(id).map(topico ->
                new DatosRespuestaTopico(
                        topico.getId(),
                        topico.getTitulo(),
                        topico.getMensaje(),
                        topico.getEstado(),
                        new DatosUsuario(
                                topico.getAutor().getNombre(),
                                topico.getAutor().getCorreoElectronico()
                        ),
                        new DatosCurso(
                                topico.getCurso().getNombre(),
                                topico.getCurso().getCategoria()
                        ),
                        topico.getFechaCreacion()
                )
        );
    }

    public Optional<DatosRespuestaTopico> actualizarTopico(Long id, ActualizarTopico dto) {
        return topicoRepository.findById(id).map(topico -> {
            topico.setTitulo(dto.titulo());
            topico.setMensaje(dto.mensaje());
            topico.setEstado(dto.estado());
            topicoRepository.save(topico);
            return new  DatosRespuestaTopico(topico);
        });
    }
    public boolean eliminarTopico(Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void desactivarTopico(Long id) {
        Topico topico= topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
    }

    public boolean activarTopico(Long id) {
        Topico topico = topicoRepository.findById(id).orElse(null);
        if (topico != null) {
            topico.activarTopico();
            return true;
        }
        return false;
    }

}
