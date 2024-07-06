package com.forohub.foro.domain.respuesta;

import com.forohub.foro.domain.topico.DatosRespuesta;
import com.forohub.foro.domain.topico.Topico;
import com.forohub.foro.domain.topico.TopicoRepository;
import com.forohub.foro.domain.usuario.DatosRespuestaUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RespuestaService {
    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    public RespuestaDto responderTopico(DatosCrearRespuesta datos, Long id){
        Optional<Topico> topico =  topicoRepository.findById(id);

        if (topico.isPresent() ){
            Respuesta respuesta = new Respuesta();
            respuesta.setMensaje(datos.mensaje());
            respuesta.setFechaCreacion(LocalDateTime.now());
            respuesta.setTopico(topico.get());
            respuesta.setAutor(topico.get().getAutor());
            respuesta.setActivo(true);
            respuesta.setSolucion(true);
            respuestaRepository.save(respuesta);

            return new  RespuestaDto(
                    respuesta.getId(),
                    respuesta.getMensaje(),
                    new DatosRespuesta(
                            respuesta.getTopico().getId(),
                            respuesta.getTopico().getTitulo()
                    ),
                    new DatosRespuestaUsuario(
                            respuesta.getAutor().getId(),
                            respuesta.getAutor().getNombre()
                    ),
                    respuesta.getFechaCreacion()
            );
        }else {
            throw new IllegalArgumentException("Topico o Autor no encontrado");
        }
    }

    public Page<DatosListarRespuesta> listarRespuestas(Pageable paginacion) {
        return respuestaRepository.findByActivoTrue(paginacion)
                .map(respuesta -> new DatosListarRespuesta(
                        respuesta.getMensaje(),
                        new DatosRespuesta(
                                respuesta.getTopico().getId(),
                                respuesta.getTopico().getTitulo()
                        ),
                        new DatosRespuestaUsuario(
                                respuesta.getAutor().getId(),
                                respuesta.getAutor().getNombre()
                        ),
                        respuesta.getFechaCreacion()
                ));
    }

}
