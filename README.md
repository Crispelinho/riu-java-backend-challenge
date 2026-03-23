
# Hotel Availability Search

Proyecto Java Spring Boot para gestión y consulta de búsquedas de disponibilidad hotelera, con persistencia en Oracle y mensajería Kafka. Incluye endpoints REST, validaciones, tests y documentación Swagger.

---

## Estructura de carpetas principal

```
hotel-availability-search/
├── AGENT.md
├── build/
├── build.gradle
├── docker-compose.yml
├── Dockerfile
├── gradle/
├── gradlew
├── gradlew.bat
├── HELP.md
├── oracle-create-table-searches.sql
├── README.md
├── settings.gradle
└── src/
	├── main/
	│   ├── java/
	│   │   └── com/
	│   │       └── riu/
	│   │           └── challenge/
	│   │               └── hotel_availability_search/
	│   │                   ├── application/
	│   │                   │   ├── commands/
	│   │                   │   ├── ports/
	│   │                   │   └── usecases/
	│   │                   ├── domain/
	│   │                   │   ├── exceptions/
	│   │                   │   ├── model/
	│   │                   │   └── ports/
	│   │                   ├── infrastructure/
	│   │                   │   ├── adapter/
	│   │                   │   │   ├── db/
	│   │                   │   │   ├── kafka/
	│   │                   │   │   └── service/
	│   │                   │   ├── config/
	│   │                   │   └── entrypoint/
	│   │                   │       └── restcontroller/
	│   │                   └── Application.java
	│   └── resources/
	│       ├── application-local.yaml
	│       ├── application.yaml
	│       ├── log4j2.properties
	│       ├── static/
	│       └── templates/
	└── test/
		├── java/
		│   └── com/
		│       └── riu/
		│           └── challenge/
		│               └── hotel_availability_search/
		│                   ├── application/
		│                   │   └── usecases/
		│                   ├── domain/
		│                   │   └── model/
		│                   ├── infrastructure/
		│                   │   ├── adapter/
		│                   │   └── entrypoint/
		│                   │       └── restcontroller/
		│                   │           └── dto/
		│                   └── ApplicationTests.java
		└── resources/
```

---

## Requisitos

- Docker y Docker Compose instalados

---

## ¿Cómo ejecutar el proyecto?

### 1. Construir el JAR

```sh
./gradlew clean build
```

### 2. Levantar la app y Oracle con Docker Compose

```sh
docker-compose up --build
```

Esto levantará dos servicios:
- **oracle-db**: Oracle XE 21c, usuario `system`, password `apppassword`, puerto 1521
- **hotel-availability-app**: Spring Boot, puerto 8080

### 3. Parar los servicios

```sh
docker-compose down
```

---

## Variables de conexión principales

- `SPRING_DATASOURCE_URL=jdbc:oracle:thin:@oracle-db:1521/XE`
- `SPRING_DATASOURCE_USERNAME=system`
- `SPRING_DATASOURCE_PASSWORD=apppassword`

---

## Documentación Swagger/OpenAPI

Tras levantar la aplicación, puedes acceder a la documentación interactiva de la API en:

- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Esto te permitirá explorar y probar los endpoints REST expuestos por el servicio.

---

## Variables de entorno avanzadas

Puedes personalizar el driver JDBC y la consola H2 usando variables de entorno:

- `SPRING_DATASOURCE_DRIVER`: driver JDBC a usar (por defecto: `oracle.jdbc.OracleDriver`)
- `SPRING_H2_CONSOLE_ENABLED`: habilita/deshabilita la consola H2 (`false` en producción, `true` en test)

Ejemplo en Docker Compose (ya configurado):

```
SPRING_DATASOURCE_DRIVER=oracle.jdbc.OracleDriver
SPRING_H2_CONSOLE_ENABLED=false
```

Si ves errores de H2 en producción, asegúrate de que estas variables estén correctamente definidas y que no haya variables heredadas de tu entorno local.

---

## Notas

- El contenedor de la app espera a que Oracle esté saludable antes de iniciar.
- Puedes cambiar credenciales en `docker-compose.yml` si lo necesitas.
- El JAR debe estar en `build/libs/` tras compilar.

---

## Requisitos
- Docker y Docker Compose instalados

## Instrucciones rápidas

### 1. Construir el JAR

```sh
./gradlew clean build
```

### 2. Levantar la app y Oracle con Docker Compose

```sh
docker-compose up --build
```

Esto levantará dos servicios:
- **oracle-db**: Oracle XE 21c, usuario `system`, password `apppassword`, puerto 1521
- **hotel-availability-app**: Spring Boot, puerto 8080

### 3. Variables de conexión (ya configuradas)
- `SPRING_DATASOURCE_URL=jdbc:oracle:thin:@oracle-db:1521/XE`
- `SPRING_DATASOURCE_USERNAME=system`
- `SPRING_DATASOURCE_PASSWORD=apppassword`

### 4. Parar los servicios

```sh
docker-compose down
```

---

## Notas
- El contenedor de la app espera a que Oracle esté saludable antes de iniciar.
- Puedes cambiar credenciales en `docker-compose.yml` si lo necesitas.
- El JAR debe estar en `build/libs/` tras compilar.

---


## Documentación Swagger/OpenAPI

Tras levantar la aplicación, puedes acceder a la documentación interactiva de la API en:

- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Esto te permitirá explorar y probar los endpoints REST expuestos por el servicio.

---

## Variables de entorno avanzadas

Puedes personalizar el driver JDBC y la consola H2 usando variables de entorno:

- `SPRING_DATASOURCE_DRIVER`: driver JDBC a usar (por defecto: `oracle.jdbc.OracleDriver`)
- `SPRING_H2_CONSOLE_ENABLED`: habilita/deshabilita la consola H2 (`false` en producción, `true` en test)

Ejemplo en Docker Compose (ya configurado):

```
SPRING_DATASOURCE_DRIVER=oracle.jdbc.OracleDriver
SPRING_H2_CONSOLE_ENABLED=false
```

Si ves errores de H2 en producción, asegúrate de que estas variables estén correctamente definidas y que no haya variables heredadas de tu entorno local.

---

¿Dudas? Revisa los logs con:

```sh
docker-compose logs -f
```
