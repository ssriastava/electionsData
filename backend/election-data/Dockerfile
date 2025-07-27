FROM openjdk:17
EXPOSE 8080
ADD target/electionData.jar electionData.jar
ENTRYPOINT ["java", "-jar", "electionData.jar"]