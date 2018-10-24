package softuni.gamestore.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import softuni.gamestore.demo.config.ModelMapperConfig;

@SpringBootApplication
public class GameStoreDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameStoreDemoApplication.class, args);
	}

	@Bean
	public ModelMapper getMapper() {
		ModelMapper modelMapper = new ModelMapper();
		ModelMapperConfig config = new ModelMapperConfig(modelMapper);
		return modelMapper;
	}
}
