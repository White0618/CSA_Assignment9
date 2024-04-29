# 基础镜像
FROM openjdk:17-jdk
# 拷贝jar包
COPY CSA_Assignment9-0.0.1-SNAPSHOT.jar /app.jar
# 入口
ENTRYPOINT ["java","-jar","/app.jar"]