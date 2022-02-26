
# INTRODUCE

- Hi, This repo contains some examples with using Spring Cloud. You can clone and using command below to build all modules.

```cmd

    mvn clean install -DskipTests
    
```



# EXAMPLE WITH ZUUL GATEWAY

- In this example you should start following modules.
    - Eureka-Server
    - Zuul-Edge-Service
    - Bff-Application-Service
    - Blog-Application-Adapter

- You can [view more in this post](https://minhducnguyen189.github.io/java/2021/07/05/java-springboot-eureka-zuul.html)

# EXAMPLE WITH OPENFEIGN

- In this example you should start following modules.
    - Bff-Openfeign-Library
    - Bff-Application-Service

- Note: `Bff-Openfeign-Library` is using the jar package of `openfeign-library` as a library.

- You can [view more in this post](https://minhducnguyen189.github.io/java/2021/07/15/java-springboot-feign-client.html)

# EXAMPLE WITH OPENFEIGN AND OPENAPI

- In this example you should start following modules.
    - Eureka-Server
    - Openfeign-Openapi-Client
    - Openfeign-Openapi-Server

- You can [view more in this pose](https://minhducnguyen189.github.io/java/2022/02/13/java-springboot-openapi-openfeign.html)



