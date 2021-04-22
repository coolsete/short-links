# Short link creator (Shortener)

Simple application for demonstrate how to work services to reduce long links.
"Shorter" is Spring Boot application with 2 REST API and H2 in-memory database.

#Build
 >gradlew build
 
#Build Docker container
 >docker-compose up --build

#Application port
8087

#Rest API
Create short link by regular url.
> /api/short
>
Restore original url by short link
> /api/original
