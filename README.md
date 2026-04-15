# 🛡️ API de Usuarios con Spring Boot y JWT

Este proyecto fue desarrollado con **Spring Boot** implementando **JWT (JSON Web Token)** para la autenticación y protección de los EndPoints.

Permite realizar operaciones CRUD sobre usuarios, asegurando el acceso mediante autenticación con token.

---

# 🔐 Autenticación

## POST /login

Endpoint para iniciar sesión y generar un **token JWT**.

### Body (x-www-form-urlencoded)


username = admin
password = 1234


### Respuesta esperada

Retorna un **token JWT** que deberá usarse en los siguientes endpoints.


eyJhbGciOiJIUzI1NiJ9...


---

# 📌 Uso del Token

Para acceder a los endpoints protegidos, se debe incluir el token en los **headers**:


Authorization: Bearer TU_TOKEN


---

# 👤 EndPoints de Usuarios

## 📋 Obtener todos los usuarios

### GET /usuario/listar

Obtiene todos los usuarios registrados en la base de datos.

### Headers


Authorization: Bearer TU_TOKEN


---

## 🔍 Buscar usuario por ID

### GET /usuario/buscar/{id}

Busca un usuario específico mediante su ID.

### Headers


Authorization: Bearer TU_TOKEN


---

## ➕ Guardar nuevo usuario

### POST /usuario/guardar

Guarda un nuevo usuario en la base de datos.

### Headers


Authorization: Bearer TU_TOKEN


### Body (JSON)

json
{
  "nombre": "Mauricio Cohetero",
  "email": "mauriciocohetero@gmail.com",
  "password": "1234",
  "telefono": "2221234567",
  "fechaRegistro": "2026-04-14T17:04:16.880756"
}
✏️ Editar usuario
PUT /usuario/editar/{id}

Actualiza la información de un usuario existente.

Headers
Authorization: Bearer TU_TOKEN
Body (JSON)
{
  "nombre": "Mauricio Cohetero",
  "email": "mauriciocohetero@gmail.com",
  "password": "1234",
  "telefono": "2221234567",
  "fechaRegistro": "2026-04-14T17:04:16.880756"
}



❌ Eliminar usuario
DELETE /usuario/eliminar/{id}

Elimina un usuario mediante su ID.

Headers
Authorization: Bearer TU_TOKEN
🛠️ Tecnologías utilizadas
Java 17
Spring Boot
Spring Security
JWT (JSON Web Token)
JPA / Hibernate
PostgreSQL (o tu base de datos)
Gradle
▶️ Cómo ejecutar el proyecto
Clonar el repositorio:

git clone [URL\_DEL\_REPOSITORIO](https://github.com/Cohetero/UsuariosSpringBoot)

Ejecutar el proyecto desde tu IDE o terminal.
Probar los endpoints usando Postman.
Obtener token desde:

POST /login

Usar el token en los demás endpoints.
📬 Pruebas con Postman

Se incluye una colección de Postman para facilitar las pruebas de los endpoints.


postman/UsuariosEntrevista1.postman_collection.json
