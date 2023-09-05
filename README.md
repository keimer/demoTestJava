# demoTestJava

Steps:
1.- Clonar respositotio en el directorio de trabajo.
2.- Crea tu rama de trabajo (**feature/<nombre-participante>**) desde la rama main.
3.- Realizar Push de la rama recién creada para validar acceso de subida al repositorio.
4.- Importar proyecto en STS (springtoolsuite) u otro IDE de preferencia.
5.- Crear controller para exponer el servicio de usuarios, el endpoint debe ser **http://localhost:8879/test-practico/v1/users/all**
6.- Filtrar unicamente los usuarios que su name contenga "Bryant" o "Brown".
7.- Debe ser posible ordenar por el campo **"createdAt"** o por el campo **"id"** según queryString usado.
8.- Se debe crear record (no DTO), interface y su implementacion con feign (todo en un único archivo, NO SEPARADO).
9.- Debe implementar ExceptionHandler (simular error llamando a una url falsa)
10.- Implementar logs de trazabilidad con AOP
11.- Implementar producer de un services bus azure para dejar el contenido filtrado previamente en el paso 6, como mensaje en la siguiente cola: 
    CONNECTIONSTRING: sb://sb-kz-onboarding-dev.servicebus.windows.net/;SharedAccessKeyName=XXXXXXXXXXX;SharedAccessKey=XXXXXXXXXXXX
    AZURE_SB_QUEUE_NAME: test-queue
12.- Implementar conexión a base de datos Cosmos Azure y recuperar los movimientos del primer usuario filtrado en paso 6.
13.- Adicionar los movimientos recuperados en paso 12 dentro del json incial recuperado en paso 6 para el rut correspondiente
14.- Debe realizar al menos una prueba unitaria.
15.- Probar por postman y subir tus cambios al repositorio remoto.
16.- Tiempo de ejecución 1 hora y media


ENDPOINT Externo: https://64f651fc2b07270f705e62c0.mockapi.io/v1/users
