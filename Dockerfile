FROM openjdk:21-jdk
ADD target/rinha-0.0.1-SNAPSHOT.jar /opt
ADD src/main/resources/* /opt/config

ENTRYPOINT ["java","-jar","/opt/rinha-0.0.1-SNAPSHOT.jar","-server","-Xms256m","-Dfile.encoding=UTF-8"]