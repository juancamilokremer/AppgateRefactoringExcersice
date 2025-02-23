## Tecnología utilizada: 
* Java 17
* Spring Boot 3.4.3
* Maven 3.6.3

## Comandos para compilar y ejcutar el proyecto desde linea de comandos con Maven:

* Compilar:					        mvn clean compile
* Inicio de la aplicación:	mvn spring-boot:run
* Ejecución de test:				mvn test

## Servicios expuestos:
* Metodo: Get
* Recurso: /api/sequences/distinct/{sequence}/{subsequence}
* Descripción: Permite encontrar todas la veces que subsequence se encuentre incluida en sequence
* Variable sequence: cadena en la cual se quiere encontrar las subsecuencia a buscar
* Variable subsequence: cadena en la cual se quiere encontrar subsecuencia en la cadena sequence
	
## Condiciones:
* sequences y subsequences deben ser valores diferentes a vacio.
* la cadena sequence debe ser mayor que subsequences.

Formas de probar el servicio:

## Swager:
La aplicación cuenta con Swager por medio de su interfaz puede ejecutarse los servicios expuestos, se puede ingresar a el una vez se encuentre ariba la aplicación con la URL http://localhost:8080/swagger-ui/index.htm	

## Postman:
Por medio de la aplicación postman también es posible ejecutar los servicios expuestos.
