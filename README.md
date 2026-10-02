Biblioteca Multimedia


Integrantes
Álvaro Urien
Diego Patiño
Oier Bárcena
Telmo González
1. Descripción del proyecto
Biblioteca Multimedia es una aplicación desarrollada en Java para gestionar una biblioteca de recursos multimedia. El programa permite administrar usuarios, recursos y préstamos y devoluciones, además de guardar y recuperar la información mediante archivos CSV.
La aplicación cuenta con un menú interactivo desde el que se pueden realizar las diferentes operaciones disponibles
Funcionalidades principales
Gestión de usuarios:
Crear usuarios.
Listar usuarios.
Buscar usuarios.
Modificar usuarios.
Eliminar usuarios.
Control de identificadores duplicados.
Gestión de recursos:
Gestionar diferentes tipos de recursos multimedia.
Libros.
Películas.
Videojuegos.
Consultar la disponibilidad de los recursos.
Gestión de préstamos y devoluciones:
Realizar préstamos.
Realizar devoluciones.
Comprobar la disponibilidad de los recursos.
Cambiar el estado de los recursos según estén disponibles o prestados.
Realizar búsquedas y consultas.
Persistencia de datos:
Leer información almacenada en archivos CSV.
Guardar los cambios realizados durante la ejecución.
Recuperar la información al iniciar la aplicación.
Controlar posibles errores relacionados con los archivos.
2. Estructura general del proyecto
El proyecto está organizado en diferentes partes para separar las funcionalidades desarrolladas por cada integrante del equipo.
La estructura principal se divide en:
Usuarios: contiene las clases y funcionalidades relacionadas con la gestión de usuarios.
Recursos: contiene la jerarquía de recursos multimedia y las operaciones relacionadas con ellos.
Préstamos: contiene la lógica necesaria para realizar préstamos y devoluciones.
Persistencia: contiene las funcionalidades encargadas de leer y escribir la información en archivos CSV.
Main: contiene la clase principal desde la que se inicia la aplicación y se muestra el menú interactivo.
De esta forma, cada parte del proyecto tiene una responsabilidad concreta y el código queda organizado y separado según su funcionalidad.
3. Instrucciones para ejecutar el proyecto
Para ejecutar el proyecto es necesario disponer de Eclipse y tener el proyecto importado correctamente.
Importar el proyecto Biblioteca_Multimedia en Eclipse.
Abrir el proyecto desde el explorador de proyectos de Eclipse.
Acceder a la carpeta src.
Nos metemos en la carpeta Main.
Abrir el archivo Main.java.
Ejecutar el programa pulsando el botón verde de ejecución situado en la parte superior de Eclipse.
Una vez iniciado el programa, aparecerá un menú interactivo con las diferentes opciones disponibles:
1. Usuarios
2. Recursos
3. Préstamos y devoluciones
4. Salir
Desde el menú se puede acceder a las diferentes funcionalidades de la aplicación.
Al seleccionar la opción 4. Salir, se guardarán los cambios realizados en los correspondientes archivos CSV.


4. Reparto inicial del trabajo
El proyecto se dividió inicialmente en cuatro partes, asignando a cada integrante una funcionalidad principal.
Oier Bárcena  feature/usuarios
Tareas realizadas:
Crear la clase Usuario.
Implementar los métodos para crear usuarios.
Implementar el listado de usuarios.
Implementar la búsqueda de usuarios.
Implementar la modificación de usuarios.
Implementar la eliminación de usuarios.
Implementar el control de identificadores duplicados.
Álvaro Urien feature/recursos
Tareas realizadas:
Diseñar la jerarquía de clases mediante herencia y abstracción.
Crear las clases Recurso, Libro, Película y Videojuego.
Implementar los métodos CRUD para los recursos.
Implementar la consulta de disponibilidad de los recursos.
Telmo González feature/préstamos
Tareas realizadas:
Desarrollar la lógica de préstamos y devoluciones.
Comprobar la existencia y disponibilidad de los recursos.
Cambiar el estado de los recursos entre disponible y no disponible.
Implementar el sistema de búsquedas y las consultas necesarias.
Diego Patiño feature/persistencia
Tareas realizadas:
Programar la lectura de archivos de texto o CSV.
Programar la escritura de información en archivos CSV.
Guardar y recuperar la información al iniciar y cerrar la aplicación.
Gestionar los errores relacionados con los ficheros.

5. Problemas relevantes encontrados durante el desarrollo
Desde el comienzo del proyecto tuvimos que enfrentarnos a diferentes dificultades, especialmente relacionadas con la creación del proyecto, la configuración de GitHub y Eclipse y la integración del trabajo realizado por los diferentes integrantes del equipo.
Uno de los primeros problemas apareció a la hora de crear y conectar el proyecto con GitHub. Al principio no teníamos experiencia realizando este proceso, por lo que tuvimos que investigar y aprender cómo crear correctamente el repositorio y cómo enlazarlo con Eclipse. Debido a estos problemas, tuvimos que crear y borrar el repositorio de GitHub en dos ocasiones hasta conseguir que, a la tercera vez, quedase correctamente creado y conectado con Eclipse.
Además, al crear el proyecto inicialmente cometimos el error de no crearlo como un Java Project. Esto provocaba numerosos errores a la hora de compartir el proyecto, trabajar con él y realizar determinadas operaciones desde Eclipse. Intentamos solucionarlo convirtiendo el proyecto manualmente, pero esto terminó generando todavía más problemas y complicaciones. Finalmente, decidimos eliminar el proyecto y comenzar de nuevo, esta vez creando correctamente un Java Project desde el principio.
Una vez solucionados los problemas iniciales de configuración, durante el desarrollo también tuvimos que afrontar dificultades relacionadas con la integración de las diferentes funcionalidades desarrolladas por cada integrante del equipo. Al trabajar cada persona en una parte diferente del proyecto, fue necesario organizar y combinar correctamente los cambios para conseguir que todas las funcionalidades funcionasen conjuntamente.
También surgieron dificultades con la lectura y escritura de los archivos CSV. Fue necesario asegurarnos de que la información se recuperará correctamente al iniciar la aplicación y de que todos los cambios realizados durante la ejecución se guardaron correctamente al finalizarla.
Otro aspecto que requirió especial atención fue la validación de los datos introducidos por el usuario. Por ejemplo, tuvimos que controlar que no se pudiesen crear usuarios con identificadores duplicados y que no se pudiesen realizar préstamos de recursos que no estuviesen disponibles.
Finalmente, realizamos diferentes pruebas para comprobar el funcionamiento conjunto de la aplicación. Estas pruebas nos permitieron detectar y corregir errores relacionados con la gestión de usuarios, recursos, préstamos, devoluciones y persistencia de los datos en los archivos CSV.
En general, aunque al principio tuvimos bastantes dificultades, especialmente por nuestra falta de experiencia trabajando con GitHub y Eclipse, estos problemas nos permitieron aprender a trabajar con repositorios, ramas y proyectos compartidos, además de mejorar nuestra capacidad para integrar el trabajo realizado por todos los miembros del equipo.

6. Funcionamiento general de la aplicación
Al iniciar la aplicación se muestra un menú principal desde el que el usuario puede seleccionar la funcionalidad que desea utilizar.
La opción Usuarios permite gestionar toda la información relacionada con los usuarios de la biblioteca.
La opción Recursos permite gestionar los diferentes recursos multimedia disponibles, como libros, películas y videojuegos, además de consultar su disponibilidad, poder crear, editar o eliminar al gusto.
La opción Préstamos y devoluciones permite gestionar el préstamo de recursos a los usuarios y realizar posteriormente su devolución, actualizando el estado de disponibilidad correspondiente.
Finalmente, mediante la opción Salir, se finaliza la ejecución de la aplicación y se guardan los cambios realizados en los archivos CSV.

