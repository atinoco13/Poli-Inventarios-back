Poli-Inventarios-back

Backend en Spring Boot para la consulta de inventarios del proyecto del Politécnico Grancolombiano.  
Expone un API REST para consultar información de productos e inventario general a partir de datos almacenados en archivos **JSON**.

Tecnologías
- Java 17 (o la versión que uses)
- Spring Boot
- Maven
- Eclipse / Spring Tools Suite
- Git & GitHub

Ejecución del proyecto

  mvn spring-boot:run

Clonar el repositorio

git clone https://github.com/atinoco13/Poli-Inventarios-back.git
cd Poli-Inventarios-back

Endpoints

1- Listar todos el invetario

curl --location 'http://localhost:8080/api/inventario' \
--header 'Accept: application/json'

2- Lista inventario por producto Ejemplo: 1, 2
curl --location 'http://localhost:8080/api/inventario/{idProducto}'
