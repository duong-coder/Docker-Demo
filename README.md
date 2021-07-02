# Docker-Demo

Thử nghiệm Docker: mysql, springboot, angular

## Tham khảo

[Mysql + Spring](https://www.javainuse.com/devOps/docker/docker-mysql)

## Sau khi chạy hãy đợi Mysql chạy thành công server backend sẽ khởi động lại

## PORT

- Mysql cho server backend là 3306
    Eg: `8080:8080`
    => 8080 lần 1 là cổng docker dùng cho app được gọi từ trình duyệt
    => 8080 lần 2 là cổng app được EXPOSE sau khi Dockerfile

## NETWORK

Mysql phải chung Network với java app.

## STEP 1 - Configuration

Spring app:
    - config application.properties:
        ```spring.datasource.url=${SPRING_DATASOURCE_URL}
        spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
        spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
        spring.jpa.generate-ddl=true
        spring.datasource.initialization-mode=always
        spring.datasource.continue-on-error=true```
    - Entity:
        Nếu Id là String thì thêm `@Column(length = ?)`
Angular app:
    - Hiện tại chưa dùng `EVN variable`
    - Thay URL backend trực tiếp vào `http.get(url);`
    - Tham khảo: [Using OS EVN](https://codinglatte.com/posts/angular/using-os-environment-variables-in-angular-with-docker/)

## STEP 2 - Dockerfile

Spring app Dockerfile:
    - Sử dụng openjdk đúng phiên bản: hiện tại dùng openjdk:11
    - `EXPOSE`: cổng chạy app
Angular app Dockerfile:
    - ...

## STEP 3 - docker-compose

- `docker-compose up`: chạy tự động app -> image -> container
- `docker-compose build`: build lại image nhưng ko chạy
