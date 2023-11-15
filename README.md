# Musica Grupo-3

La aplicación tiene como objetivo gestionar las canciones favoritas de los clientes de Guugle y proporcionar acceso a una extensa colección de vídeos musicales de los usuarios

        ○	App: los usuarios pueden utilizar una aplicación móvil en sus dispositivos Android para acceder y gestionar
        su lista de canciones favoritas. Pueden autenticarse, buscar y agregar canciones a su lista de favoritos,
        así como reproducir las canciones a través de enlaces de MyTube
        
        ○	APP de escritorio: existe una versión de la aplicación para escritorio que ofrece funcionalidades similares
        a la aplicación móvil. Los usuarios pueden acceder a su colección de canciones favoritas desde
        ordenadores personales.
        
        ○	Servidor: El servidor es una API REST que almacena información sobre canciones, usuarios y sus listas
        de favoritos. Proporciona servicios para la gestión de canciones, autenticación de usuarios
        y gestión de listas de favoritos.


●	Una API REST (Representational State Transfer) es un tipo de interfaz de programación de aplicaciones que utiliza HTTP para facilitar la comunicación entre aplicaciones y servicios web. Se basa en principios de diseño sencillos, como recursos y verbos HTTP, para permitir la transferencia de datos de manera eficiente y sin estado.

# Repositorios Relacionados

●	[Repositorio del Proyecto de Escritorio](https://github.com/Ceptorshock/Reto1_Grupo3.git)

●	[Repositorio de la Aplicación Android](https://github.com/PRSpidy/retoAndroid.git)


# Descripción del proyecto.

El proyecto esta compuesto por una tabla de usuarios, una tabla de favoritos y una de canciones. En esta aplicacion un usuario podra mirar todas las canciones que hay en el sistema y añadir a la lista de favoritos las canciones.

 
![image](https://github.com/Ceptorshock/Reto1_Grupo3/assets/145370272/fd9693c2-1e69-4ea2-b47d-5157503f9edc)




-	El usuario podrá:
    -	Registrarse
    -	Loguearse
    -	Añadir una música
    -	Mirar la lista de música
    -	Acceder a sus músicas favoritas
    -	Eliminar músicas de la lista y de su lista de favoritos
    -	Filtrar sus músicas por autor o canción.
    -	Modificar su contraseña

# Built With (construido con)

Tecnologías que se han utilizado para crear toda la capa del servidor son:
-	Spring Boot (version 3.1.4)
-	Hibernate
-	MySQL
-	Eclipse
-	Android
-	Postman

# Getting Started
Para poder obtener una copia local en funcionamiento siga estos sencillos pasos.


# Prerrequisitos (Prerrequisitos para arrancar el proyecto)
Primero deberán instalarse los siguientes programas:
-	Eclipse
-	MySQL Workbench

Debemos tener instalado MySQL, hay que generar la BBDD y los inserts con el db.sql que está en la carpeta src/main/resources/sql/db.sql.


# Installation (Instalación)
A continuación se muestra un ejemplo de cómo se descarga el proyecto sobre la instalación y configuración de su aplicación.

1.	Clonar el repositorio 
a.	Para el repositorio de java:

    git clone https://github.com/Ceptorshock/Reto1_Grupo3.git



2.	Modificar en el application.properties las siguientes propiedades:

   El siguiente paso es ajustar la configuración del proyecto en el archivo application.properties. Este archivo suele encontrarse en la carpeta src/main/resources. Puedes abrirlo con un editor de texto y modificar las propiedades con la IP del servidor SQL, nombre de la BD, usuario y contraseña.
   
      Configuración de la base de datos
      spring.datasource.url=jdbc:mysql://localhost:3306/nombre_base_datos
      spring.datasource.username=usuario_base_datos
      spring.datasource.password=contraseña_base_datos



# Usage (uso)
Cómo arrancar el proyecto… Ir al archivo /src/main/java/  y darle a RUN AS -> Java Application

Desde Postman accederemos con la siguiente url:

	GET http://localhost:8080/api/songs

Mencionar la existencia de la colección de POSTMAN y la ruta hacia dicha colección, que deberá estar en /src/main/resources/postman/MyTube.postman_collection.json




# API Documentation (Documentación)
La documentación de la API se encuentra en la URL generada por Swagger, disponible cuando el servidor está en funcionamiento.


http://localhost:8080/swagger-ui/index.html

# Contact (Contacto)
-	Gorka Gabiña (gorka.gabiname@elorrieta-errekamari.com)
-	Aimar Pelea
-	Milena Cuelar

# License (Licencia)
Distributed under the MIT License.


