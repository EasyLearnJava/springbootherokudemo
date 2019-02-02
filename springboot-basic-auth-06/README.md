Add the spring security pom entry mentioned below.

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-security</artifactId>
	</dependency>
	
This adds security to the application and from now on any request that comes to the application needs Basic auth : 
which requires us to enter the user name and password.

Default username : user
For password, we can check the application server logs during server start up. 
This will look some thing like b2ca4db1-8921-3499-9q3e-qwerrd894n3u7

So now when a request is sent from a rest client, a window pops up requesting username and password. Once the valid data is entered we will
get access to the application :)

Notice that the Request header has a new parameter called "Cookie" which has a JsessionId associated to it.

TRY this at HOME :) -- copy the jsessionid and go to a different rest client and send the same request, this time just add the
cookie and jsessionid value as the header parameter. This will be a successfull request. No need to enter user name and password.
So dont share your jsession id

?? When we connect to unsecure wifi can someone see my requests and their headers?

  	