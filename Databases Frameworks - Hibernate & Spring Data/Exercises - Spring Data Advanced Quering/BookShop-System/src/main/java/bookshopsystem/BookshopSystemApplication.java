package bookshopsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//When need to work on local machine, and don't want to switch always the root and pass on the DB
//rename application.properties to app.properties (there stay server properties) and create
//new one local.properties (my local machine properties). Need add here @PropertySource
//with this params:: (spring is enough smart and will override app.prop with local.prop)
@PropertySource(value = {"classpath:app.properties", "classpath:local.properties"})
public class BookshopSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshopSystemApplication.class, args);
	}
}
