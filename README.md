# demoTestJava

Steps:
* Clonar respositotio en el directorio de trabajo
* Crea tu rama de trabajo (feature/<nombre-participante>) desde la rama main
* Importar proyecto en STS (springtoolsuite) u otro IDE de preferencia.
* Crear controller para exponer el servicio de usuarios, el endpoint debe ser **http://localhost:8888/test-practico/v1/usuario/all**
* Filtrar unicamente los usuarios que su name contenga "Mitchell" o "Harris".
* Debe ser posible ordenar por el campo **"createdAt"** o por el campo **"id"**.
* Se debe crear DTO, interface y su implementacion con feign
* Probar por postman y subir tus cambios al repositorio remoto
+ Hacer PR a la rama Develop (opcional)

ENDPOINT Externo: https://63076d52c0d0f2b8012f51cb.mockapi.io/api/v1/usuarios
