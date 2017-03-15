## Eureka discovery service

### Discovery Server
```
eureka:
  server:
    wait-time-in-ms-when-sync-empty: 0    # default, time to wait when server starts up unable to get instances from peer nodes
    enable-self-preservation: false       # shutdown protect mode for dev
    eviction-interval-timer-in-ms: 5000   # default 60s to evict invalid node, accelerate for dev
```
For more options, see META-INF/spring-configuration-metadata.json or EurekaServerConfigBean.

### Discovery Client
Part of the configuration:
```
eureka:
  instance:
    hostname: localhost       # hostname determined at configuration time, or will be guessed from OS primitives
    prefer-ip-address: true   # when guessing a hostname, using ip if preferred; set true to show ds replicas
    lease-expiration-duration-in-seconds: 90    # default 90s, if no response over 90s, remove this instance
    lease-renewal-interval-in-seconds: 30      # default 30s, interval of heartbeats
    instance-id: ${spring.application.name}:${spring.application.instance_id:${random.value}}    # unique Id(within the scope of appName) of this instance to be registered with eureka, random value supported
    metadata-map:     # define key/value pairs as metadata of this instance, and send to eureka server to be used by other instances
      instance-id: ${spring.application.name}:${spring.application.instance_id:${random.value}}
  client:
    register-with-eureka: false     # don't register this client to server
    fetchRegistry: true     # this client should fetch registry information from server
    service-url:
      defaultZone: http://localhost:8762/eureka/    # url of ds replica, use port of this instance if run singleton
    registry-fetch-interval-seconds: 5    # default 30s to fetch registry info, accelerate for dev
    eureka-server-connect-timeout-seconds: 8   # default 8s, time to wait before a read from server timeout
    instance-info-replication-interval-seconds: 5   # default 30s, time to replicate instance changes to be replicated to the server
    prefer-same-zone-eureka: true     # default true, whether this instance try to use server in the same zone
```

For more options, see META-INF/spring-configuration-metadata.json or EurekaInstanceConfigBean and EurekaClientConfigBean.

### Notice
1. When setup peer awareness peer0 and peer1, and the client register to peer0, when peer0 shutdown, peer1 will still hold registration for this client, but this feature depends on configuration(self-protection-mode?).
But it's more secure for client to register BOTH peer nodes, so is this a convention.