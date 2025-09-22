# Librería API (Spring Boot + MySQL)

API sencilla para gestionar libros de una librería. Provee endpoints CRUD para `Libro`.

## Stack

- **Java** 21 (recomendado) / 17 (LTS)
- **Spring Boot** 3.5.6
- **Maven**
- **MySQL** 8.x

---

## Requisitos previos

1. **JDK** 21 u 17 instalado.
2. **MySQL** 8.x corriendo.
3. **Maven** (o `./mvnw`).

---

## Configuración

1. Copia la plantilla de configuración y renómbrala para uso local:

- cp src/main/resources/application-example.yml src/main/resources/application.yml

2. Edita las variables en `src/main/resources/application.yml` (usuario, contraseña y URL de la BD), tomando como referencia los archivos de ejemplo `application-example.yml` o `application-example.properties`.

3. Crea la base de datos (si aún no existe):

- CREATE DATABASE IF NOT EXISTS libreria;

## Endpoints

- GET /api/libros
- GET /api/libros/{id}
- POST /api/libros
- PUT /api/libros/{id}
- DELETE /api/libros/{id}

## Cómo ejecutar

1. Asegúrate de haber configurado `src/main/resources/application.yml` y de que MySQL esté corriendo.
2. Desde la raíz del proyecto, ejecuta:
   - ./mvnw spring-boot:run
   - o: mvn spring-boot:run
3. La aplicación quedará disponible en: http://localhost:8080
