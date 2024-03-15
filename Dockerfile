FROM alpine:latest AS builder
RUN apk add --no-cache wget tar
RUN mkdir /jdk
WORKDIR /jdk
RUN wget https://cdn.azul.com/zulu/bin/zulu17.48.15-ca-jdk17.0.10-linux_musl_x64.tar.gz

RUN tar -xvf zulu17.48.15-ca-jdk17.0.10-linux_musl_x64.tar.gz
RUN ln -s /jdk/zulu17.48.15-ca-jdk17.0.10-linux_musl_x64/bin/javac /usr/bin/javac && javac --version
RUN ln -s /jdk/zulu17.48.15-ca-jdk17.0.10-linux_musl_x64/bin/java /usr/bin/java && java --version

#Build the application
RUN mkdir /application
WORKDIR /application
COPY ./ ./
RUN ./gradlew --version
RUN ./gradlew clean build

FROM alpine:latest
RUN apk add --no-cache wget tar curl
RUN mkdir /myapp
WORKDIR /myapp
RUN wget https://cdn.azul.com/zulu/bin/zulu17.48.15-ca-jdk17.0.10-linux_musl_x64.tar.gz
RUN tar -xvf zulu17.48.15-ca-jdk17.0.10-linux_musl_x64.tar.gz
COPY --from=builder /application/build/libs/app.jar .
CMD ["/myapp/zulu17.48.15-ca-jdk17.0.10-linux_musl_x64/bin/java","-jar","/myapp/app.jar"]