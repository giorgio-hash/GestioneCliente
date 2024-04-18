FROM openjdk:latest
COPY target/GestioneCliente-0.0.1-SNAPSHOT.jar GestioneCliente-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","GestioneCliente-0.0.1-SNAPSHOT.jar"]