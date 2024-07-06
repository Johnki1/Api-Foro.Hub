CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje VARCHAR(700) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    estado VARCHAR(50) NOT NULL,
    autor_id BIGINT,
    curso_id BIGINT,
    activo BOOLEAN NOT NULL,
    CONSTRAINT fk_autor FOREIGN KEY (autor_id) REFERENCES usuarios(id),
    CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES cursos(id)
);
