package driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="controllers,services,DO,repositories,security")
@EntityScan("DO")  
@EnableJpaRepositories("repositories")

public class MainClass {

	public static void main(String[] args) {
	
		SpringApplication.run(MainClass.class, args);
	}
	
}
