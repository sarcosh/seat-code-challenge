# SEAT:CODE Code Challenge

## PASO 1. Prerequisitos



## PASO 2. Compilación del proyecto

```bash
MacBook-Pro-de-Sergio-2:SEAT_Code_Challenge sarcos$ pwd
/Users/sarcos/Desktop/MICROSERVICES/workspace/SEAT_Code_Challenge

MacBook-Pro-de-Sergio-2:SEAT_Code_Challenge sarcos$ mvn clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------------< com.seat:code.challenge >-----------------------
[INFO] Building SEAT_Code_Challenge 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ code.challenge ---
[INFO] Deleting /Users/sarcos/Desktop/MICROSERVICES/workspace/SEAT_Code_Challenge/target
[INFO] Deleting /Users/sarcos/Desktop/MICROSERVICES/workspace/dockerfile/alpine
[INFO] 
[INFO] --- maven-resources-plugin:3.1.0:resources (default-resources) @ code.challenge ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ code.challenge ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 18 source files to /Users/sarcos/Desktop/MICROSERVICES/workspace/dockerfile/alpin
...
```
## PASO 3. Creación de la imagen Docker


```bash
MacBook-Pro-de-Sergio-2:dockerfile sarcos$ pwd
/Users/sarcos/Desktop/MICROSERVICES/workspace/SEAT_Code_Challenge/dockerfile

MacBook-Pro-de-Sergio-2:dockerfile sarcos$ ./assembleImage.sh 
Sending build context to Docker daemon  24.37MB
Step 1/6 : FROM openjdk:8-jre-alpine
8-jre-alpine: Pulling from library/openjdk
e7c96db7181b: Pull complete 
f910a506b6cb: Pull complete 
b6abafe80f63: Pull complete 
Digest: sha256:f362b165b870ef129cbe730f29065ff37399c0aa8bcab3e44b51c302938c9193
Status: Downloaded newer image for openjdk:8-jre-alpine
 ---> f7a292bbb70c
Step 2/6 : LABEL maintainer=Sergio\ Arcos	  version=1.0
 ---> Running in 74b98adf79de
Removing intermediate container 74b98adf79de
 ---> 2309db461299
Step 3/6 : COPY launcher.sh ./launcher.sh
 ---> 2f6224a2b729
Step 4/6 : COPY app.jar ./app.jar
 ---> fc6a17431920
Step 5/6 : RUN chmod +x ./launcher.sh
 ---> Running in ad257db43ff0
Removing intermediate container ad257db43ff0
 ---> f09a2424e0f8
Step 6/6 : ENTRYPOINT ["/bin/sh","-c", "/launcher.sh"]
 ---> Running in cddae20481ba
Removing intermediate container cddae20481ba
 ---> 3c4efea3e88f
Successfully built 3c4efea3e88f
Successfully tagged sarcosh666/seat-code-challenge:latest
```




```bash
MacBook-Pro-de-Sergio-2:dockerfile sarcos$ docker images
REPOSITORY                       TAG                 IMAGE ID            CREATED              SIZE
sarcosh666/seat-code-challenge   latest              3c4efea3e88f        About a minute ago   109MB
openjdk                          8-jre-alpine        f7a292bbb70c        5 weeks ago          84.9MB
```

```bash
MacBook-Pro-de-Sergio-2:dockerfile sarcos$ docker push sarcosh666/seat-code-challenge
The push refers to repository [docker.io/sarcosh666/seat-code-challenge]
125a8624a0f7: Pushed 
9f537b7f4e6e: Pushed 
4bf4ec568325: Pushed 
edd61588d126: Mounted from library/openjdk 
9b9b7f3d56a0: Mounted from library/openjdk 
f1b5933fe4b5: Mounted from library/openjdk 
latest: digest: sha256:741b07f136238da29466df5466d08183bbd3488b17c844fab047616e454834e0 size: 1573
```

## PASO 4. Inicialización del Contenedor Docker

```bash
MacBook-Pro-de-Sergio-2:~ sarcos$ docker run -d --rm -p 8090:8090 sarcosh666/seat-code-challenge
60a55e4ae30f5d1ca01938469d93f34cf4f156b73d90f342952a74bef321d2c6

MacBook-Pro-de-Sergio-2:~ sarcos$ docker logs 60a

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.5.RELEASE)

2019-06-16 11:36:41.886  INFO 6 --- [           main] c.s.c.c.SeatCodeChallengeApplication     : Starting SeatCodeChallengeApplication v0.0.1-SNAPSHOT on 60a55e4ae30f with PID 6 (/app.jar started by root in /)
2019-06-16 11:36:41.902  INFO 6 --- [           main] c.s.c.c.SeatCodeChallengeApplication     : No active profile set, falling back to default profiles: default
2019-06-16 11:36:44.272  INFO 6 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8090 (http)
2019-06-16 11:36:44.334  INFO 6 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2019-06-16 11:36:44.335  INFO 6 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.19]
2019-06-16 11:36:44.475  INFO 6 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2019-06-16 11:36:44.476  INFO 6 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2430 ms
2019-06-16 11:36:45.249  INFO 6 --- [           main] pertySourcedRequestMappingHandlerMapping : Mapped URL path [/v2/api-docs] onto method [public org.springframework.http.ResponseEntity<springfox.documentation.spring.web.json.Json> springfox.documentation.swagger2.web.Swagger2Controller.getDocumentation(java.lang.String,javax.servlet.http.HttpServletRequest)]
2019-06-16 11:36:45.393  INFO 6 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-06-16 11:36:45.577  INFO 6 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
2019-06-16 11:36:45.600  INFO 6 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 1 custom documentation plugin(s)
2019-06-16 11:36:45.644  INFO 6 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2019-06-16 11:36:45.856  INFO 6 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8090 (http) with context path ''
2019-06-16 11:36:45.861  INFO 6 --- [           main] c.s.c.c.SeatCodeChallengeApplication     : Started SeatCodeChallengeApplication in 4.928 seconds (JVM running for 5.524)

```



## PASO 4. Ejecución de comandos

```bash
curl -X POST \
  http://127.0.0.1:8090/api/v1/mars \
  -H 'Accept: */*' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Type: application/json' \
  -H 'accept-encoding: gzip, deflate' \
  -H 'cache-control: no-cache' \
  -H 'content-length: 85' \
  -d '{		
 "commands":["5 5","1 2 N","L M L M L M L M M","3 3 E","M M R M M R M R R M"]
}'
```


```bash
MacBook-Pro-de-Sergio-2:SEAT_Code_Challenge sarcos$ curl -X POST \
>   http://127.0.0.1:8090/api/v1/mars \
>   -H 'Accept: */*' \
>   -H 'Cache-Control: no-cache' \
>   -H 'Connection: keep-alive' \
>   -H 'Content-Type: application/json' \
>   -H 'accept-encoding: gzip, deflate' \
>   -H 'cache-control: no-cache' \
>   -H 'content-length: 85' \
>   -d '{
>  "commands":["5 5","1 2 N","L M L M L M L M M","3 3 E","M M R M M R M R R M"]
> }'

{"resultCode":0,"resultMessage":"","resultRover1":"x: 1 - y: 3 - orientation: N","resultRover2":"x: 5 - y: 1 - orientation: E"}
```