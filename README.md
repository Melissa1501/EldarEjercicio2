# Sistema de Gestión de Personas y Tarjetas

Esta aplicación gestiona personas y sus tarjetas, permitiendo operaciones como crear personas, registrar tarjetas y consultar tasas de tarjetas de crédito según la marca. La aplicación está construida con **Spring Boot** y utiliza **H2** como base de datos en memoria.

## Tecnologías utilizadas

- **Spring Boot 3.3.4**
- **H2 Database** (Base de datos en memoria)
- **Java 21**
- **Maven**

## Aplicación desplegada
 La aplicación también está desplegada y disponible en:
- **URL de producción**: [https://eldarejercicio2.onrender.com/api](https://eldarejercicio2.onrender.com/api)


## Endpoints


### Ping

#### Verificar el estado de la API
- **GET** `https://eldarejercicio2.onrender.com/api/ping`
- **Descripción**: Endpoint para verificar que la API esté activa.
- **Respuesta**: 200 OK con el mensaje `"Pong!"`.

### Personas

#### Crear una nueva persona
- **POST** `https://eldarejercicio2.onrender.com/api/personas`
- **Descripción**: Crea una nueva persona en el sistema.
- **Cuerpo de la solicitud**:
  ```json
  {
    "nombre": "Juan",
    "apellido": "Perez",
    "dni": "12345678",
    "fechaNacimiento": "1980-05-20",
    "email": "juan.perez@example.com"
  }
  ```
- **Respuesta**: 201 Created con la persona creada.

#### Obtener una persona por DNI
- **GET** `https://eldarejercicio2.onrender.com/api/personas/{dni}`
- **Descripción**: Obtiene la información de una persona según su DNI.
- **Respuesta**: 200 OK con la persona encontrada o 404 Not Found si no existe.

#### Listar todas las personas
- **GET** `https://eldarejercicio2.onrender.com/api/personas`
- **Descripción**: Devuelve una lista de todas las personas registradas en el sistema.
- **Respuesta**: 200 OK con la lista de personas.

## Ejemplo

### Crear una Persona

```bash
curl -X POST https://eldarejercicio2.onrender.com/api/personas \
  -H "Content-Type: application/json" \
  -d '{"nombre": "Juan", "apellido": "Perez", "dni": "12345678", "fechaNacimiento": "1980-05-20", "email": "juan.perez@example.com"}'
```


---

### Tarjetas

#### Crear una nueva tarjeta para una persona
- **POST** `https://eldarejercicio2.onrender.com/api/personas/{dni}/tarjetas`
- **Descripción**: Crea una nueva tarjeta para la persona con el DNI especificado.
- **Cuerpo de la solicitud**:
  ```json
  {
    "numero": "1234-5678-9012-3456",
    "fechaVencimiento": "2025-12-31",
    "cvv": "123",
    "marca": "VISA"
  }
  ```
- **Respuesta**: 201 Created con la tarjeta creada.

#### Listar todas las tarjetas de una persona
- **GET** `https://eldarejercicio2.onrender.com/api/personas/{dni}/tarjetas`
- **Descripción**: Devuelve una lista de todas las tarjetas asociadas a la persona con el DNI especificado.
- **Respuesta**: 200 OK con la lista de tarjetas.

#### Consultar la tasa de una tarjeta
- **GET** `https://eldarejercicio2.onrender.com/api/tarjetas/tasa?marca={marca}&fecha={fecha}`
- **Descripción**: Calcula la tasa de una tarjeta en base a su marca y la fecha especificada.
- **Parámetros**:
  - `marca`: Marca de la tarjeta (VISA, AMEX, NARA).
  - `fecha`: Fecha de consulta en formato `YYYY-MM-DD`.
- **Respuesta**: 200 OK con la tasa calculada o 404 Not Found si no se encuentra la tarjeta.

#### Listar todas las tarjetas
- **GET** `https://eldarejercicio2.onrender.com/api/tarjetas`
- **Descripción**: Devuelve una lista de todas las tarjetas registradas en el sistema.
- **Respuesta**: 200 OK con la lista de tarjetas.

## Ejemplo

### Crear una Tarjeta para una Persona

```bash
curl -X POST https://eldarejercicio2.onrender.com/api/personas/12345678/tarjetas \
  -H "Content-Type: application/json" \
  -d '{"numero": "1234-5678-9012-3456", "fechaVencimiento": "2025-12-31", "cvv": "123", "marca": "VISA"}'
```

---

## Notas

- La base de datos H2 es volátil y los datos se perderán cada vez que se reinicie la aplicación.
