1	Generación archivo jar y arrancar el proyecto:

Para la ejecución de la aplicación desde fuera de un IDE solo tenemos que arrancar la línea de comando desde el directorio donde está el proyecto,
 poniendo CMD en la barra de direcciones o urls de la ventana que está abierta, ejecutamos el siguiente comando:

                •   mvn clean install

                • Ejemplo:
                     E:\Calculadora>mvn clean install

 Para ejecutar el jar una vez generado vamos a la carpeta target donde se encuentra y o bien lo ejecutamos desde ahí o podemos moverlo a otro directorio y ejecutarlo desde
 el directorio donde lo hemos depositado, y abriendo otra vez el CMD ejecutamos el siguiente comando:

                •	java -jar calculadora-0.0.1-SNAPSHOT.jar

                • Ejemplo:
                     E:\Calculadora\target>java -jar calculadora-0.0.1-SNAPSHOT.jar

  2	Acceso a las siguientes opciones del API-REST Calculadora:
  2.1	Operación Sumar:
               •	En Postman o en el software que utilicemos seleccionaremos el tipo de petición GET e introduriremos la siguiente URL:

                     •	http://localhost:8080/calculadora/sumar/<Valor1>/<Valor2>

                     • Ejemplo:
                        •	http://localhost:8080/calculadora/sumar/multiplicar/2/3
  2.2	Operación Multiplicar:
               •	En Postman o en el software que utilicemos seleccionaremos el tipo de petición GET e introduriremos la siguiente URL:

                     •	http://localhost:8080/calculadora/multiplicar/<Valor1>/<Valor2>

                     • Ejemplo:
                        •	hhttp://localhost:8080/calculadora/multiplicar/2.5/3.5

