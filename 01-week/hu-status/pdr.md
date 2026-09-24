# Product Brief: Catalog & Showtimes Service

## Declared Tech Stack

- backend: Go
- database: PostgreSQL
- documentation: Swagger


## 00 - Contexto inicial

El sistema de cine requiere un componente central que administre y sirva la información referente a la cartelera disponible: películas, salas de exhibición y la programación de funciones. 

Este microservicio se enfoca en proveer una lectura altamente eficiente y de baja latencia para los clientes que consultan la app o web, así como permitir a los administradores del cine gestionar el catálogo y la parrilla de horarios.

El microservicio no maneja reservas de asientos ni cobros (responsabilidad de otros servicios), sino que actúa como la fuente de verdad del inventario expositivo del cine.

Preferencia tecnológica del producto para esta prueba: Go o Node.js para el backend, MongoDB o PostgreSQL para la base de datos (aprovechando esquemas de consulta rápida e indexación).

## 01 - Necesidades y problemas

- Permitir la administración (CRUD) de películas con información como título, sinopsis, duración, clasificación por edad, póster y género.
- Definir la infraestructura física básica: salas de cine (*theaters*) con sus capacidades y tipos de pantalla (2D, 3D, IMAX).
- Programar funciones (*showtimes*) vinculando una película a una sala específica en una fecha y rango horario determinado.
- Permitir a los clientes buscar y filtrar funciones por fecha, género de película y formato.
- Responder a un volumen alto de consultas de lectura sin degradar el rendimiento de la aplicación.
- Evitar solapamientos de horarios en la misma sala al momento de programar funciones.

Problema principal: Sin un catálogo centralizado y de respuesta rápida, los clientes experimentan lentitud para ver la cartelera y la administración corre el riesgo de sobreponer funciones en una misma sala.

## 02 - Procesos actuales

Actualmente, la programación se gestiona en hojas de cálculo y la cartelera se actualiza de forma manual o desincronizada, lo que genera errores de horario y lentitud al cargar la información en las plataformas digitales.

Proceso esperado:

1. El administrador registra una nueva película con su ficha técnica básica.
2. El administrador configura las salas disponibles en el complejo de cine.
3. El administrador crea una función (*showtime*) asignando una película, una sala, un precio base y un horario de inicio/fin.
4. El cliente navega por la app o web, consulta la cartelera filtrando por día o género, y selecciona una película.
5. El sistema devuelve el listado de películas junto con sus respectivos horarios disponibles de forma paginada y optimizada.

No se requiere procesar compras de boletos ni gestionar el mapa de asientos ocupados en este microservicio.

## 03 - Preguntas abiertas

- ¿Se requiere soporte para múltiples complejos de cine (multisucursal) o solo un complejo?
- ¿Cómo se calculan automáticamente los horarios de fin de la función según la duración de la película + tiempo de limpieza de la sala?
- ¿El catálogo requiere manejo de estados de película (Ej: "Próximamente", "En Cartelera", "Archivada")?
- ¿Se deben soportar precios dinámicos por función (Ej: tarifas de miércoles de descuento o funciones nocturnas) o se maneja en el servicio de reservas?
- ¿Se integrará un CDN para el almacenamiento de pósteres/imágenes o se guardan solo las URLs?
- ¿Se habilitará un caché en memoria (Redis) en esta fase para acelerar las lecturas de la cartelera del día?

## 04 - Glosario negocio

- Película (*Movie*): Objeto principal del catálogo con detalles técnicos, sinopsis, clasificación e imágenes.
- Sala (*Theater/Auditorium*): Espacio físico donde se proyecta la película, caracterizado por su capacidad de asientos y tecnología (2D, 3D, IMAX).
- Función / Horario (*Showtime*): Instancia específica de proyección que vincula una película, una sala, una fecha, una hora de inicio y un precio base.
- Cartelera: Conjunto de películas y funciones disponibles para la venta en un rango de fechas.
- Clasificación (*Rating*): Restricción de edad aplicable a la película (Ej: PG-13, R, APT).
- Paginación: Técnica de entrega de resultados en bloques para evitar sobrecargar la red y la base de datos al listar películas.