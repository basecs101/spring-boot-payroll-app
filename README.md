# spring-boot-payroll-app

CRUD = create --> (`POST`/`INSERT`), Read(`GET`/`SELECT`), Update(`PUT`, `UPDATE`), Delete(`DELETE`, `DELETE`)

### A sample spring boot rest application and demo rest methods

REST (Representational State Transfer) is an architectural style used in web development for building scalable, performant, and maintainable web services. RESTful API (Application Programming Interface) is an implementation of the REST architecture.

RESTful API is a type of web API that is designed to work with HTTP (Hypertext Transfer Protocol) requests such as GET, POST, PUT, DELETE, etc., to retrieve, create, update or delete resources on the web. RESTful APIs use HTTP methods to define the actions to be performed on resources, and use URLs (Uniform Resource Locators) to identify resources.

RESTful APIs typically return data in JSON (JavaScript Object Notation) or XML (Extensible Markup Language) format, which are both lightweight and easy to parse. They also use hypermedia links to navigate between resources and represent the state of the system.

RESTful APIs are widely used in modern web development for creating web services that are easy to consume, scalable, and platform-agnostic. They are used by many popular web applications and services, such as Twitter, Facebook, and Google Maps.


> Example of URL :- `http://localhost:8080/greeting?name=Vikram`

* http -> protocol
* localhost -> domain name
* 8080 -> http port
* /greeting -> path or endpoint
* name -> request parameter key
* Vikram -> request parameter value

### Spring Boot Annotations:
1. `SpringBootApplication` : `@SpringBootApplication` is a convenience annotation that adds all the following:
   1. `@SpringBootConfiguration`: Tags the class as a source of bean definitions for the Application Context/ Spring IOC Container.
   2. `@EnableAutoConfiguration`: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.
   3. `@ComponentScan`: Tells Spring to look for other `@Component`, `@Configuration`, `@Controller` and `@Service` in the com/basecs101 package, letting it find the classes to create beans.
2. `@SpringBootTest` : Marks the class as Spring boot test class
3. `@RestController` : The Spring boot `@RestController` annotation, which marks the class
   as a controller where every method returns a domain object instead of a view.
   It is shorthand for including both `@Controller` and `@ResponseBody`.
4. `@GetMapping` : The @GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.
5. `@PostMapping` : Create resource
6. `@PutMapping` : Update resource
7. `@PatchMapping` : Partial update of resource
8. `@DeleteMapping` : Delete existing resource
9. `@RequestParam` : @RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method. If the name parameter is absent in the request, the defaultValue of World is used.
10. `@PathVariable`:
11. `@RequestBody` :
12. `@ResponseBody`:

> The main() method uses Spring Boot’s SpringApplication.run() method to launch an application. Did you notice that there was not a single line of XML? There is no web.xml file, either. This web application is 100% pure Java and you did not have to deal with configuring any plumbing or infrastructure.

### Lombok Annotations
#### Declare all these annotations at class level to replace boiler plat code
1. `@Getter` -> To replace all getters
2. `@Setter` -> To replace all setters
3. `@NoArgsConstructor`-> To replace no-argument constructor
4. `@AllArgsConstructor`-> To replace all-argument constructor
5. `@EqualsAndHashCode` -> To replace equals and hashcode methods
6. `@ToString` -> To replace toString method.
7. `@Slf4j` -> Used for logging

### JPA Annotations
1. `@Entity` -> Maps Java Object to relational db schema/table
2. `@Id` -> Creates id on the field
3. `@GeneratedValue` -> Automatic generation field and increment

### Reference for this [tutorial](https://spring.io/guides/tutorials/rest/)