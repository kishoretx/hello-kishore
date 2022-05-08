FROM openjdk:8
EXPOSE 8080
ADD target/hello-kishore.jar hello-kishore.jar
ENTRYPOINT ["java", "-jar", "/hello-kishore.jar"]
