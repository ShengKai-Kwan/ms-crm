FROM openjdk:8-jre-alpine
COPY ./ms-customer-order-svc/target/ms-customer-order-svc.jar /usr/app/
WORKDIR /usr/app/
ENTRYPOINT ["java", "-jar", "-Xmx1024m", "/usr/app/ms-customer-order-svc.jar"]
EXPOSE 8088