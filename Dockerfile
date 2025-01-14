# 使用する基本イメージとして OpenJDK を指定
FROM gradle:8.8-jdk21 AS build

# 作業ディレクトリを作成
WORKDIR /app

# プロジェクト全体をコピーする
COPY . . 

# Gradle を使用してアプリをビルド
RUN gradle clean build -x test

FROM eclipse-temurin:21-alpine
COPY --from=build /app/build/libs/firstapp-0.0.1-SNAPSHOT.jar firstapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "firstapp.jar", "--spring.profiles.active=prod", "--debug"]