FROM gradle:6.8-jdk11 as builder

WORKDIR /home/gradle

COPY . .

# CMD ["/bin/bash"]

RUN ["gradle", "build"]

# New step, to see the dependencies....
RUN ["gradle", "dependencies"]

FROM openjdk:11-jre-slim-buster

COPY --from=builder /home/gradle/build/libs/starter-springboot-gradle-devcontainer-java11-template-*.jar /app/starter-springboot-gradle-devcontainer-java11-template.jar

WORKDIR /app

CMD ["java", "-jar", "starter-springboot-gradle-devcontainer-java11-template.jar"]
