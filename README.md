# spring-native-experiments

repository to test and explore the development of spring boot apps using the native support for spring boot 3

The repository contains two project which has a single root endpoint, both endpoint does the same; return a simple message as string.
The goal of maintaining these two project is to compare the differences between a JVM based Spring boot app and a Spring boot native image,
both applications will be containerized.
## Projects 

- spring-docker-app-jvm
- spring-docker-native-image
- 
### spring-docker-app-jvm

This application is containerized directly using Dockerfile, it exploits the resultant .jar file so we can take laverage of the image layer capabilities
to create a ligther image caching most of theirs dependencies, to run the app follows thes steps

1. run: mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar) - need to be run in the root folder of the project
2. build image: docker build -t demo-spring-boot-docker .  - you might want to add you docker hub username
3. create the container: docker run --rm -p 8080:8080 demo-spring-boot-docker

#### Testing
```curl -X GET localhost:8080``` -- it should return the following message: **Hello Docker World**
### spring-docker-native-image

This application uses Spring boot 3 which supports native image and bings the reachability metadata support for a number of spring project which makes
the build of native images and the process of AOT easier to developer who won't need to add the AOT annotations manually for most of the libraries 
and projects used in spring boot application
This project also uses packeto buildpack to build and containerized the native image into a docker image, it handle the building and create a lightwight
image, which mean less configuration overhead for the developers


1. mvn -Pnative spring-boot:build-image  ( will create the docker image)
2. docker run --rm -p 8080:8080 docker.io/library/demo:0.0.1-SNAPSHOT create and run the container


#### Testing
```curl -X GET localhost:8080``` -- it should return the following message: **Hello World! I'm native in this world**

The main advantages of the native images is the portability of the images, the size of the resultant images and how it makes the boostraping and startup
of an application supper fast, over passing the startup times in spring boot JVM application

![Diagrama en blanco](https://user-images.githubusercontent.com/13155586/214677101-53383fbd-410f-4542-bb2e-010568c53b59.png)



