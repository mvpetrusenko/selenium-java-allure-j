FROM jenkins/jenkins:2.375.3
USER root
RUN apt-get update && apt-get install -y lsb-release
RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
  https://download.docker.com/linux/debian/gpg
RUN echo "deb [arch=$(dpkg --print-architecture) \
  signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
  https://download.docker.com/linux/debian \
  $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list
RUN apt-get update && apt-get install -y docker-ce-cli
USER jenkins
RUN jenkins-plugin-cli --plugins "blueocean docker-workflow"








# FROM maven:3.8.1-openjdk-17-slim AS builder
# WORKDIR /app
# COPY pom.xml ./
# COPY src ./src
#
# RUN mvn clean install
#
# # Second stage: Minimal runtime environment
# FROM eclipse-temurin:17-jre-jammy
# WORKDIR /app
#
# # copy jar from the first stage
# COPY --from=builder /app/target/*.jar /app/app.jar
#
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "/app/app.jar"]