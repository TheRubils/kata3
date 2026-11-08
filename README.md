# Kata3
## Objetivo
Se tiene por objetivo consolidar la transformación de datos externos _(CSV)_ en objetos de dominio y su posterior serialización a formato JSON válido, separando correctamente lectura, análisis, transformación y escritura sin acoplar los datos al origen.
## Compilacion y estructura de la entrega
Para empezar se deberá dirigir a la opcion de Clone Repository en su entorno de desarrollo IntelliJ IDEA y poner el enlace al repositorio correspondiente (https://github.com/TheRubils/kata3.git) sabiendo que se esta usando Oracle OpenJDK 25. El proyecto se divide en:
- **Adapters:** Agrupa los componentes encargados de leer la fuente _(CsvMonsterLoader)_, analizar los datos _(MonsterAnalyzer)_ y serializarlos a JSON mediante flujos y Gson _(GsonMonsterWriter)_
- **Domain:** Contiene la entidad de registro _(Monster)_.
- **Ports:** Define las interfaces de almacenamiento o carga.
## Video
- Enlance: https://github.com/TheRubils/kata2 
## Verificación
Comprobación mediante una entrada correcta comparando la salida con un JSON esperado, pruebas con registros incompletos o datasets vacíos, y validación de que el JSON generado puede parsearse de nuevo correctamente.
