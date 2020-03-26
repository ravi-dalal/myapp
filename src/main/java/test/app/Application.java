package test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/* Extend SpringBootServletInitializer to run on an existing tomcat instance and override configure method */
@SpringBootApplication
public class Application 
	extends SpringBootServletInitializer 
{

	@Override protected SpringApplicationBuilder
	configure(SpringApplicationBuilder application) { 
		return  application.sources(Application.class); 
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
}
