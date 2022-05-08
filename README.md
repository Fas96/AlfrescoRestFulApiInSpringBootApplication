# AlfrescoRestFulApiInSpringBootApplication
Alfresco RestFul Api In Spring Boot Application

## Below are personal exploration of the alfresco rest api
Deeper understanding of the alfresco product would be much helpful
--

Updates on master-

2022-05-08
-- Api Implementations


----property file configuration starts here 

`xml

spring.profiles.active=dev
#Feign client
logging.level.root=INFO

spring.datasource.url=jdbc:mysql://localhost:3306/alfresco?useSSL=false&serverTimezone=Asia/Seoul&characterEncoding=UTF-8
spring.datasource.username=alfresco
spring.datasource.password=Wasec1996@

#jpa
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57InnoDBDialect





logging.level.org.springframework=ERROR
logging.level.es.keensoft=INFO
logging.pattern.console=%msg%n
logging.level.com=TRACE



# View resolver
spring.mvc.view.prefix=/WEB-INF/view/
spring.mvc.view.suffix=.jsp
server.port=8090

content.service.url=http://localhost:8080
content.service.security.basicAuth.username=admin
content.service.security.basicAuth.password=admin

# Change Spring Boot version to one of the following versions [2.4.x, 2.5.x] .
spring.cloud.compatibility-verifier.enabled=false


content.service.path=/alfresco/api/-default-/public/alfresco/versions/1
search.service.path=/alfresco/api/-default-/public/search/versions/1
search-sql.service.path=/alfresco/api/-default-/public/search/versions/1
governance.service.path=/alfresco/api/-default-/public/gs/versions/1
authentication.service.path=/alfresco/api/-default-/public/authentication/versions/1
discovery.service.path=/alfresco/api

feign.httpclient.enabled=true


`




--NB
Notice improper implementation of Feign Client might cause errors in POST methods.
