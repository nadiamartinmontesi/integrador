# PARCIAL BACKEND 2 - NADIA MARTIN MONTESI


Levantamos las configuraciones que necesitamos con el docker-compose up
Dentro del docker-compose se encuentra el .json con las configuraciones del reino.

<img width="692" alt="Captura de Pantalla 2023-03-18 a la(s) 18 40 55" src="https://user-images.githubusercontent.com/86934894/226142931-8d785cbc-296c-4a35-8b8c-8f3691cc3fb4.png">

Tiene una anotación para que funcione en el sistema operativo de Apple. Si no funciona en Windows importar el .json dentro de Keycloak como indican las imágenes.

<img width="217" alt="Captura de Pantalla 2023-03-18 a la(s) 18 42 59" src="https://user-images.githubusercontent.com/86934894/226143005-cfdaa8fc-679f-4f1a-a16b-18dc5a4f5ba1.png">
<img width="1269" alt="Captura de Pantalla 2023-03-18 a la(s) 18 42 42" src="https://user-images.githubusercontent.com/86934894/226143009-f08915b8-0d21-4258-bd57-598faec66d57.png">


Luego de levantar los cinco microservicios podemos comprobar que esten todos en Eureka.

<img width="1257" alt="Captura de Pantalla 2023-03-18 a la(s) 16 40 19" src="https://user-images.githubusercontent.com/86934894/226143057-43456d77-9f7b-4d52-ae9e-bcbd79be92fd.png">


Dentro del reino en Keycloak podemos comprobar que estén creados los clients, los grupos y los tres usuarios definidos en el microservicio de users. (Las passwords definidas para cada usuario es el grupo al que corresponde).

<img width="1257" alt="Captura de Pantalla 2023-03-18 a la(s) 16 41 48" src="https://user-images.githubusercontent.com/86934894/226143127-5197032c-bbf8-4669-8c4d-b3cac3b7fa09.png">
<img width="1257" alt="Captura de Pantalla 2023-03-18 a la(s) 16 41 54" src="https://user-images.githubusercontent.com/86934894/226143131-0b9afe11-6839-410a-a7c2-340dddb5df9e.png">
<img width="1257" alt="Captura de Pantalla 2023-03-18 a la(s) 16 40 34" src="https://user-images.githubusercontent.com/86934894/226143136-693253b0-ef16-4097-a0de-b80a0796e231.png">


Desde cualquier navegador podemos observar las movies, autenticandonos con un usuario del grupo Client o Admin.

<img width="1212" alt="Captura de Pantalla 2023-03-18 a la(s) 17 07 59" src="https://user-images.githubusercontent.com/86934894/226143214-5caa476d-db1f-449c-802a-5b9971d1a416.png">
<img width="1212" alt="Captura de Pantalla 2023-03-18 a la(s) 17 08 06" src="https://user-images.githubusercontent.com/86934894/226143218-ead8506e-cb5a-4e3b-a363-3f31002afdc4.png">

Si nos autenticamos como Admin vamos a poder acceder a ver los usuarios que no sean Admin

<img width="1257" alt="Captura de Pantalla 2023-03-18 a la(s) 16 44 08" src="https://user-images.githubusercontent.com/86934894/226143256-95abe69d-065e-465c-966c-7b93780f241b.png">
<img width="1213" alt="Captura de Pantalla 2023-03-18 a la(s) 16 44 58" src="https://user-images.githubusercontent.com/86934894/226143263-3f543500-3bdb-4220-8d73-07a4815d3416.png">

Y también los datos de un usuario en cuestión

<img width="1213" alt="Captura de Pantalla 2023-03-18 a la(s) 16 52 04" src="https://user-images.githubusercontent.com/86934894/226143286-a9d5bd47-031b-416f-98f8-a6d20f47f1d9.png">

Estos endpoints funcionan llamando al gateway en el puerto 9092. Dentro de Postman no pude realizar la llamada al gateway ya que me traía el formulario en html.


Lo que si podemos ver en Postman son las facturas creadas, tenemos que acceder como un usuario provider y llamar al puerto 8087.

<img width="935" alt="Captura de Pantalla 2023-03-18 a la(s) 16 54 00" src="https://user-images.githubusercontent.com/86934894/226143361-dfc88f1b-138f-4052-be8c-29a23c3bdaf5.png">

También podemos acceder a las facturas que tiene un usuario en cuestión. Debemos auntenticarnos con el usuario Client

<img width="935" alt="Captura de Pantalla 2023-03-18 a la(s) 16 56 47" src="https://user-images.githubusercontent.com/86934894/226143405-9c9cfa65-43af-4d01-9eaf-26c6737da449.png">
