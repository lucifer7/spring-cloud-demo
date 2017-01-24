# spring-cloud-demo
## Modules
### Eureka server
Service discovery, part of Netflix OSS.
Serves as server side, while rest serve as Eureka client. 

### Compute supplier
Service provide, with its replica compute-supplier0.
 
### Ribbon Eureka
A client side IPC(Inter Process Communication)[RPC?] library. Providing: load balancing, fault tolerance, multiple protocol(HTTP, TCP, UDP) support in an asynchronous and reactive model, caching and batching.
This client will act as consumer to call Compute supplier for service.

### Feign Eureka
A java to http client binder inspired by Retrofit, JAXR-2.0.
Declarative(?) 
Making writing Web Service client easier.
This client acts as Feign consumer

Caution:
spring-boot-devtools will cause Feign @Autowired NullPointerException, which will can be solved by adding @ImportAutoConfiguration(FeignAutoConfiguration.class) to main app of Feign consumer.
