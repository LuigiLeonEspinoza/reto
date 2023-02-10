# Reto BackEnd

Plantilla de desarrollo con Spring Boot.




## Template features

### Estructura de Proyecto

El código base del proyecto se encuentra principalmente dentro de la carpeta `src`. Esta carpeta se divide en:

- `main` - contiene código base y configuración para `Spring Boot`
- `test` - contiene las pruebas unitarias realizadas

```
.
├── src
│   ├── main                                        
│   │   ├── java                               
│   │   │   └── com.novo.microservices              
│   │   │       ├── controller                      
│   │   │       │   └── ClientController            # clase controlador rest 
│   │   │       ├── model                
│   │   │       │   ├──dto            
│   │   │       │   │   └── ClientDto               # clase Dto de Client      
│   │   │       │   └── Client                      # clase object Client
│   │   │       ├── repositories                    
│   │   │       │   └── IClientRepository           # interface extends de JpaRepository
│   │   │       ├── services                          
│   │   │       │   ├──impl            
│   │   │       │   │   └── ClientServiceImpl       # clase implementacion de logica de negocio      
│   │   │       │   ├──util            
│   │   │       │   │   └── Encrypt                 # clase con metodos de encriptación static   
│   │   │       │   └── IClientService              # interface de la clase ClientServiceImpl
│   │   │       └── RetoApplication                 # clase de ejecucion del programa 
│   │   └── resurces                   
│   │       └── application.properties              # archivo donde se definen las propiedades y config.
│   │          
│   │                   
│   └── test                                        
│       └── java              
│           └── com.luigi.leon.reto   
│               └── RetoApplicationTests            # clase para hacer test
│   
├── .gitignore                                      # archivo que excluye direcciones al reposit.
├── Dockerfile                                      # archivo de configuracion docker
├── README.md                                       # archivo de documentacion
└── pom.xml                                         # archivo donde se instancian las dependencia y version del aplicativo.
```

### Definición de propiedades

**- application.properties**

***Configuración H2***

- spring.h2.console.enabled=true => Configuración para habilitar consola h2
- spring.datasource.url=jdbc:h2:mem:reto => Configuración de base de datos
- spring.datasource.username=sa => Configuración de usuario
- spring.datasource.password=admin123 => Configuración de contraseña



### Dependencias Externas

        <dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-ui</artifactId>
			<version>1.6.9</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

## Comandos de Ejecución

 **- Para generar .jar**

    mvn clean install

 **- Para generar imagen docker**

    docker build -t retoback/demo .

 **- Para ejecutar docker**

    docker run -p 8080:8080 retoback/demo:latest -d

## Rutas al ejecutar

**- Para Swagger**

   [Link Swagger](http://localhost:8080/swagger-ui/index.html)

**- Para repositorio**

  [Link GitHub]()


© 2023 Luigi Leon. All rights reserved
