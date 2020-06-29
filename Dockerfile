FROM openjdk:8-jre-alpine
RUN mkdir -p /usr/src/apps/checkout
COPY target/checkout-0.0.1-SNAPSHOT.jar /usr/src/apps/checkout
WORKDIR /usr/src/apps/checkout
CMD ["nohup", "java", "-jar", "checkout-0.0.1-SNAPSHOT.jar", "&"]