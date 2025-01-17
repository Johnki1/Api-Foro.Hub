---
# API Foro-Hub ##Una Herramienta Necesaria!!

Bienvenido a la documentación de la API Foro.Hub. Esta API proporciona funcionalidades para la gestión de tópicos, usuarios y respuestas en el sistema Foro.Hub. A continuación, encontrarás detalles sobre cómo interactuar con cada uno de los endpoints disponibles.

## Tabla de Contenidos

1. [Introducción](#introducción)
2. [Tecnologías Utilizadas](#tecnologías-utilizadas)
3. [Endpoints](#endpoints)
   - [Usuarios](#usuarios)
   - [Tópicos](#tópicos)
   - [Respuestas](#respuestas)
4. [Seguridad](#seguridad)
5. [Documentación API](#documentación-api)
6. [Capturas de Pantalla](#capturas-de-pantalla)

---

## Introducción

La API Foro.Hub está diseñada para gestionar tópicos de discusión, usuarios y respuestas dentro de un sistema de foro. Utiliza JWT para la autenticación y autorización de usuarios. A continuación se detallan las principales funcionalidades y cómo interactuar con cada una de ellas.

## Tecnologías Utilizadas

- Spring Boot
- Spring Data JPA
- Spring Security con JWT
- Flyway para migración de base de datos
- Validación de datos con Spring Validation
- Lombok para reducción de código boilerplate
- MySQL como base de datos relacional

## Endpoints

### Usuarios

#### Crear Usuario

- **Descripción:** Crea un nuevo usuario en el sistema.
- **Método HTTP:** `POST`
- **URL:** `/usuario`
- **Cuerpo de la Petición:** Datos del nuevo usuario (nombre, correo electrónico, contraseña y perfil).
- **Respuesta Exitosa:** Retorna los detalles del usuario creado.
- **Códigos de Respuesta:** `201` si se crea correctamente, `409` si ya existe un usuario con el mismo nombre.

#### Listar Usuarios

- **Descripción:** Obtiene una lista paginada de todos los usuarios.
- **Método HTTP:** `GET`
- **URL:** `/usuario`
- **Parámetros:** Opcionalmente, se puede especificar la página y el tamaño de la página para la paginación.
- **Respuesta Exitosa:** Retorna una lista paginada de usuarios.
- **Códigos de Respuesta:** `200` si la operación es exitosa.

### Tópicos

#### Crear Tópico

- **Descripción:** Registra un nuevo tópico en el sistema.
- **Método HTTP:** `POST`
- **URL:** `/topicos`
- **Cuerpo de la Petición:** Datos del nuevo tópico (título, mensaje y autor).
- **Respuesta Exitosa:** Retorna los detalles del tópico registrado.
- **Códigos de Respuesta:** `201` si se registra correctamente, `409` si ya existe un tópico con el mismo título y mensaje.

#### Listar Tópicos

- **Descripción:** Obtiene una lista paginada de todos los tópicos disponibles.
- **Método HTTP:** `GET`
- **URL:** `/topicos`
- **Parámetros:** Opcionalmente, se puede especificar la página y el tamaño de la página para la paginación.
- **Respuesta Exitosa:** Retorna una lista paginada de tópicos.
- **Códigos de Respuesta:** `200` si la operación es exitosa.

#### Obtener Tópico por ID

- **Descripción:** Obtiene un tópico específico por su identificador.
- **Método HTTP:** `GET`
- **URL:** `/topicos/{id}`
- **Parámetros:** ID del tópico que se desea obtener.
- **Respuesta Exitosa:** Retorna los detalles del tópico solicitado.
- **Códigos de Respuesta:** `200` si se encuentra el tópico, `404` si no existe.

#### Actualizar Tópico

- **Descripción:** Actualiza un tópico existente en el sistema.
- **Método HTTP:** `PUT`
- **URL:** `/topicos/{id}`
- **Parámetros:** ID del tópico que se desea actualizar.
- **Cuerpo de la Petición:** Datos actualizados del tópico (título y mensaje).
- **Respuesta Exitosa:** Retorna los detalles del tópico actualizado.
- **Códigos de Respuesta:** `200` si se actualiza correctamente, `404` si no se encuentra el tópico.

#### Eliminar Tópico

- **Descripción:** Elimina permanentemente un tópico del sistema.
- **Método HTTP:** `DELETE`
- **URL:** `/topicos/{id}`
- **Parámetros:** ID del tópico que se desea eliminar.
- **Respuesta Exitosa:** Retorna sin contenido si se elimina correctamente.
- **Códigos de Respuesta:** `204` si se elimina correctamente, `404` si no se encuentra el tópico.

#### Desactivar Tópico

- **Descripción:** Desactiva un tópico sin eliminarlo del sistema.
- **Método HTTP:** `DELETE`
- **URL:** `/topicos/del/{id}`
- **Parámetros:** ID del tópico que se desea desactivar.
- **Respuesta Exitosa:** Retorna sin contenido si se desactiva correctamente.
- **Códigos de Respuesta:** `204` si se desactiva correctamente, `404` si no se encuentra el tópico.

#### Activar Tópico

- **Descripción:** Activa un tópico previamente desactivado.
- **Método HTTP:** `PUT`
- **URL:** `/topicos/act/{id}`
- **Parámetros:** ID del tópico que se desea activar.
- **Respuesta Exitosa:** Retorna sin contenido si se activa correctamente.
- **Códigos de Respuesta:** `204` si se activa correctamente, `404` si no se encuentra el tópico.

### Respuestas

#### Crear Respuesta

- **Descripción:** Crea una nueva respuesta para un tópico específico.
- **Método HTTP:** `POST`
- **URL:** `/respuesta/{id}`
- **Parámetros:** ID del tópico al cual se está respondiendo.
- **Cuerpo de la Petición:** Datos de la nueva respuesta (mensaje y autor).
- **Respuesta Exitosa:** Retorna los detalles de la respuesta creada.
- **Códigos de Respuesta:** `201` si se crea correctamente.

#### Listar Respuestas

- **Descripción:** Obtiene una lista paginada de todas las respuestas registradas.
- **Método HTTP:** `GET`
- **URL:** `/respuesta`
- **Parámetros:** Opcionalmente, se puede especificar la página y el tamaño de la página para la paginación.
- **Respuesta Exitosa:** Retorna una lista paginada de respuestas.
- **Códigos de Respuesta:** `200` si la operación es exitosa.

## Seguridad

La API utiliza JSON Web Tokens (JWT) para la autenticación y autorización de los usuarios. Para acceder a los endpoints protegidos, es necesario incluir el token JWT generado en el encabezado de la solicitud HTTP bajo el esquema `Bearer`.

## Documentación API

La documentación de la API está generada con Swagger. Puedes acceder a la documentación interactiva visitando la URL `/swagger-ui.html` una vez que la aplicación esté en ejecución.

## Capturas De Pantalla

A continuación se muestran capturas de pantalla de los endpoints configurados en Insomnia para facilitar la interacción con la API.

![ff73dc9f-d7ce-46d0-b045-94d04272364d](https://github.com/Johnki1/Api-Foro.Hub/assets/157264782/61c6e3b8-d5d5-42f9-a011-3985fa2fdcd7)

![368aacab-3203-418f-a4bd-edca12b0baf6](https://github.com/Johnki1/Api-Foro.Hub/assets/157264782/61ce0d7b-1cb0-4467-bb62-a53686291e84)

![d09c2d15-6b4b-45da-84b0-d075fcc9cd31](https://github.com/Johnki1/Api-Foro.Hub/assets/157264782/06cc5549-fb9f-4ba3-bb05-d478cde803a2)

![image](https://github.com/Johnki1/Api-Foro.Hub/assets/157264782/475fbc04-500a-4d9b-97a7-0a0929d59fd2)

![image](https://github.com/Johnki1/Api-Foro.Hub/assets/157264782/a1e32274-d177-428f-84a9-8319910073fb)

![image](https://github.com/Johnki1/Api-Foro.Hub/assets/157264782/47a3fab5-3b38-43c2-be95-99cd43b07696)




---
