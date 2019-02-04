Actuator:
Add the entry in pom.xml
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
	
-- /actuator will be enabled and will only expose 2 end points under this, /health and /info
-- to enable more/all end points use the config management.endpoints.web.exposure.include=<comma separated end points>	

Interceptor
-- Create a Component which extends HandlerInterceptorAdapter or Implements HandlerInterceptor
-- Override the desired method
-- Configure the Spring Boot Web MVC component to use our new RequestLoggerInterceptor by implementing WebMvcConfigurer
-- Override the addInterceptors method.
-- In the above class we can override many methods from WebMvcConfigurer like addResourceHandlers to add resource locations and also 

Logging

Swagger
