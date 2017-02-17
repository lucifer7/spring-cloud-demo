# spring-cloud-demo
## Categories

```
<module>eureka</module>             <!-- Eureka server -->
<module>eureka-peer</module>        <!-- Eureka server peer -->
<module>compute-supplier</module>   <!-- service provider -->
<module>compute-supplier0</module>  <!-- service provider replica -->
<module>ribbon-eureka</module>      <!-- client side load balanced, with Hystrix as circuit breaker -->
<module>feign-eureka</module>       <!-- Declarative REST client  -->
```


## Modules
### 1. Eureka server
Service discovery, part of Netflix OSS.
Serves as server side, while rest serve as Eureka client. 

#### Peer Awareness
Eureka-server and its replica eureka-server-peer.

Config both peers to register each other:
```
  client:
    fetch-registry: true         # set true to register peers
    register-with-eureka: false   # do not register itself as a client in standalone mode
    healthcheck:
      enabled: true
    service-url:
      #defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
      defaultZone: http://eureka-server:8761/eureka/
```
While euraka-clients are only register to one of the server, both peers can sync registration info. You can have multiple peers to a system, as long as they are connected to each other by at least one edge, they will synchronize the registrations amongst themselves.

Run the same server on two hosts, running it in different Spring profiles.

#### HA
Client may config multi servers or only one, peer wil sync automatically. If only one server configured, client loses registration once this server is down.
If the first shutdown, then register second.
> defaultZone: http://localhost:8763/eureka/,http://localhost:8762/eureka/

> Log: Request execution succeeded on retry #2

### 2. Compute supplier
Service provide, with its replica compute-supplier0.
 
### 3. Ribbon Eureka
A client side IPC(Inter Process Communication)[RPC?] library. Providing: load balancing, fault tolerance, multiple protocol(HTTP, TCP, UDP) support in an asynchronous and reactive model, caching and batching.
This client will act as consumer to call Compute supplier for service.

### 4. Feign Eureka
A java to http client binder inspired by Retrofit, JAXR-2.0.
Declarative(?) 
Making writing Web Service client easier.
This client acts as Feign consumer

Caution:
spring-boot-devtools will cause Feign @Autowired NullPointerException, which will can be solved by adding @ImportAutoConfiguration(FeignAutoConfiguration.class) to main app of Feign consumer.

### 5. Zuul Gateway
Support reverse proxy and filter