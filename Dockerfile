FROM java:8
ADD target/cloudservice-0.0.1-SNAPSHOT.jar .
EXPOSE 8200
ENTRYPOINT ["java", "-jar", "cloudservice-0.0.1-SNAPSHOT.jar"]
