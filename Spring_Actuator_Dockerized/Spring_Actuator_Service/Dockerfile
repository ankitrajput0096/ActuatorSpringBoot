 
# Base Image ubuntu
FROM ubuntu:18.04

# Installing dependencies
RUN apt-get update
RUN apt-get install -y openjdk-8-jdk maven 

# coping the required application files
COPY . /spring_boot_actuator
WORKDIR /spring_boot_actuator/springactuator

# building the spring boot app
RUN mvn clean install

WORKDIR /spring_boot_actuator/springactuator/target


# running the spring boot app
CMD ["java", "-jar", "springactuator-0.0.1-SNAPSHOT.jar"]
