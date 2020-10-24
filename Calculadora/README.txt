1  Generación archivo jar:

    Para la generación de la aplicación desde fuera de un IDE solo tenemos que arrancar la línea de comando desde el directorio donde está el proyecto,
     poniendo CMD en la barra de direcciones o urls de la ventana que está abierta, ejecutamos el siguiente comando:

                •   mvn clean install

                    • Ejemplo:
                         E:\Calculadora>mvn clean install

                •   mvn clean package spring-boot:repackage (caso de que queramos cambiar el tipo de paquete(jar o war) debe estar configurado en el pom
                                                                en el plugin de spring boot, si no lo está, entonces generará un archivo de la extensión
                                                                  indicada por defecto en el pom)

                    • Ejemplo:
                         E:\Calculadora>mvn clean package spring-boot:repackage

2  Ejecución o arrancar el proyecto:

    Se puede realizar de dos maneras diferentes:
     1.-  Llamando a mvn spring-boot:run: lo cual se puede realizar en el entorno de desarrollo, abriendo una ventana  del directorio del proyecto y ejecutamos:

                •   mvn spring-boot:run

                • Ejemplo:
                          E:\Calculadora>mvn spring-boot:run



    2 Para ejecutar el jar una vez generado la aplicación. Vamos a la carpeta target donde se encuentra y o bien lo ejecutamos desde ahí o podemos moverlo a otro directorio y ejecutarlo desde
       el directorio donde lo hemos depositado, y abriendo otra vez el CMD ejecutamos el siguiente comando:

                •	java -jar calculadora-0.0.1-SNAPSHOT.jar

                • Ejemplo:
                     E:\Calculadora\target>java -jar calculadora-0.0.1-SNAPSHOT.jar


3	Acceso a las siguientes opciones del API-REST Calculadora:

    3.1 Acceso Endpoits individuales de cada operación:

        3.1.1	Operación Sumar:

               •	En Postman o en el software que utilicemos seleccionaremos el tipo de petición GET e introduriremos la siguiente URL:

                     •	http://localhost:8080/calculadora/sumar/<Valor1>/<Valor2>

                     • Ejemplo:
                        •	http://localhost:8080/calculadora/sumar/2/3


        3.1.2	Operación Multiplicar:

               •	En Postman o en el software que utilicemos seleccionaremos el tipo de petición GET e introduriremos la siguiente URL:

                     •	http://localhost:8080/calculadora/multiplicar/<Valor1>/<Valor2>

                     • Ejemplo:
                        •	hhttp://localhost:8080/calculadora/multiplicar/2.5/3.5


        3.1.3	Operación Restar:

                     •	En Postman o en el software que utilicemos seleccionaremos el tipo de petición GET e introduriremos la siguiente URL:

                           •	http://localhost:8080/calculadora/restar/<Valor1>/<Valor2>

                           • Ejemplo:
                              •	hhttp://localhost:8080/calculadora/restar/2.5/3.5


        3.1.4	Operación Dividir:

                     •	En Postman o en el software que utilicemos seleccionaremos el tipo de petición GET e introduriremos la siguiente URL:

                           •	http://localhost:8080/calculadora/dividir/<Valor1>/<Valor2>

                           • Ejemplo:
                              •	hhttp://localhost:8080/calculadora/dividir/2.5/3.5

    3.2 Acceso Endpoit calcular pasandole los numeros y la operación a realizar:

         •	En Postman o en el software que utilicemos seleccionaremos el tipo de petición Post introduriremos la siguiente URL:

                     •	http://localhost:8080/calculadora/calcular
                        Selecccionaremos Body y form-data para el envío de valores como si fueran un formulario:
                                       operador1: valor1
                                       operador2: valor2
                                       operacion: +,-,*, /

                     • Ejemplo Sumar:
                        •	http://localhost:8080/calculadora/calcular
                        •	operador1: 25
                        •	operador2: 25
                        •	operacion: +


    3.3	Acceso Endpoit calcular pasandole los numeros y la operación a realizar como si fuera una entidad:

               •	En Postman o en el software que utilicemos seleccionaremos el tipo de petición GET e introduriremos la siguiente URL:

                     •	http://localhost:8080/calculadora/calcularEntity
                        Selecccionaremos Body y raw para el envío de valores de la entidad:
                             {
                                 "operador1": valor1,
                                 "operador2": valor2,
                                 "operacion": +,-,*, /
                             }

                     • Ejemplo:
                        •	http://localhost:8080/calculadora/calcularEntity
                                {
                                "operador1": 30,
                                "operador2": 25,
                                "operacion":  "+"
                                }