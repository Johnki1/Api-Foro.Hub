CREATE TABLE respuestas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    solucion BOOLEAN,
    topico_id BIGINT,
    autor_id BIGINT,
    CONSTRAINT fk_topico_respuestas FOREIGN KEY (topico_id) REFERENCES topicos(id),
    CONSTRAINT fk_autor_respuestas FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);
