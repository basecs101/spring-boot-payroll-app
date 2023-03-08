# Spring-Boot-Payroll-Application

`CRUD` = Create --> (`POST`/`INSERT`), Read(`GET`/`SELECT`), Update(`PUT`/`UPDATE`), Delete(`DELETE`/`DELETE`)

---
### A sample spring boot rest application and demo rest methods

REST (Representational State Transfer) is an architectural style used in web development for building scalable, performant, and maintainable web services. RESTful API (Application Programming Interface) is an implementation of the REST architecture.

RESTful API is a type of web API that is designed to work with HTTP (Hypertext Transfer Protocol) requests such as GET, POST, PUT, DELETE, etc., to retrieve, create, update or delete resources on the web. RESTful APIs use HTTP methods to define the actions to be performed on resources, and use URLs (Uniform Resource Locators) to identify resources.

RESTful APIs typically return data in JSON (JavaScript Object Notation) or XML (Extensible Markup Language) format, which are both lightweight and easy to parse. They also use hypermedia links to navigate between resources and represent the state of the system.

RESTful APIs are widely used in modern web development for creating web services that are easy to consume, scalable, and platform-agnostic. They are used by many popular web applications and services, such as Twitter, Facebook, and Google Maps.

---
> Example of URL :- `http://localhost:8080/greeting?name=Vikram`
Details of the URL
* http -> protocol
* localhost -> domain name
* 8080 -> http port
* /greeting -> path or endpoint
* name -> request parameter key
* Vikram -> request parameter value

---
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
12. `@ResponseBody`: This annotation signals that this advice(`ControllerAdvice`) is rendered straight into the response body.
13. `@ControllerAdvice`: The body of the advice generates the content. In this case, it gives the message of the exception.
14. `@ExceptionHandler(EmployeeNotFoundException.class)`: configures the advice to only respond if an EmployeeNotFoundException is thrown.
15. `@ResponseStatus(HttpStatus.NOT_FOUND)`: This annotation sets the Http Status code for the exception.

> The main() method uses Spring Boot’s SpringApplication.run() method to launch an application. Did you notice that there was not a single line of XML? There is no web.xml file, either. This web application is 100% pure Java and you did not have to deal with configuring any plumbing or infrastructure.

---
### Lombok Annotations
#### Declare all these annotations at class level to replace boiler plat code
1. `@Getter` -> To replace all getters
2. `@Setter` -> To replace all setters
3. `@NoArgsConstructor`-> To replace no-argument constructor
4. `@AllArgsConstructor`-> To replace all-argument constructor
5. `@EqualsAndHashCode` -> To replace equals and hashcode methods
6. `@ToString` -> To replace toString method.
7. `@Slf4j` -> Used for logging

---
### JPA Annotations
1. `@Entity` -> Maps Java Object to relational db schema/table
2. `@Id` -> Creates id on the field
3. `@GeneratedValue` -> Automatic generation field and increment

---
### HTTP Status Codes:
---

#### 2xx
1. `200` OK - Standard response for successful HTTP requests. The actual response will depend on the request method used. In a GET request, the response will contain an entity corresponding to the requested resource. In a POST request, the response will contain an entity describing or containing the result of the action.
2. `201` - Created - The request has been fulfilled, resulting in the creation of a new resource.[5]
3. `202` - Accepted - The request has been accepted for processing, but the processing has not been completed. The request might or might not be eventually acted upon, and may be disallowed when processing occurs.

---
#### 3xx
1. `301` Moved Permanently - This and all future requests should be directed to the given URI.

---
#### 4xx
1. `400` Bad Request - The server cannot or will not process the request due to an apparent client error (e.g., malformed request syntax, size too large, invalid request message framing, or deceptive request routing).
2. `401` Unauthorized - Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided. The response must include a WWW-Authenticate header field containing a challenge applicable to the requested resource. See Basic access authentication and Digest access authentication. 401 semantically means "unauthorised", the user does not have valid authentication credentials for the target resource.
Some sites incorrectly issue HTTP 401 when an IP address is banned from the website (usually the website domain) and that specific address is refused permission to access a website.[citation needed]
3. `402` Payment Required - Reserved for future use. The original intention was that this code might be used as part of some form of digital cash or micropayment scheme, as proposed, for example, by GNU Taler,[13] but that has not yet happened, and this code is not widely used. Google Developers API uses this status if a particular developer has exceeded the daily limit on requests.[14] Sipgate uses this code if an account does not have sufficient funds to start a call.[15] Shopify uses this code when the store has not paid their fees and is temporarily disabled.[16] Stripe uses this code for failed payments where parameters were correct, for example blocked fraudulent payments.[17]
4. `403` Forbidden - The request contained valid data and was understood by the server, but the server is refusing action. This may be due to the user not having the necessary permissions for a resource or needing an account of some sort, or attempting a prohibited action (e.g. creating a duplicate record where only one is allowed). This code is also typically used if the request provided authentication by answering the WWW-Authenticate header field challenge, but the server did not accept that authentication. The request should not be repeated.
5. `404` Not Found - The requested resource could not be found but may be available in the future. Subsequent requests by the client are permissible.
6. `405` Method Not Allowed - A request method is not supported for the requested resource; for example, a GET request on a form that requires data to be presented via POST, or a PUT request on a read-only resource.

---
#### 5xx
1. `500` Internal Server Error - A generic error message, given when an unexpected condition was encountered and no more specific message is suitable.
2. `501` Not Implemented - The server either does not recognize the request method, or it lacks the ability to fulfil the request. Usually this implies future availability (e.g., a new feature of a web-service API).
3. `502` Bad Gateway - The server was acting as a gateway or proxy and received an invalid response from the upstream server.
4. `503` Service Unavailable - The server cannot handle the request (because it is overloaded or down for maintenance). Generally, this is a temporary state.[30]
5. `504` Gateway Timeout - The server was acting as a gateway or proxy and did not receive a timely response from the upstream server.


### Reference for this [tutorial](https://spring.io/guides/tutorials/rest/)
