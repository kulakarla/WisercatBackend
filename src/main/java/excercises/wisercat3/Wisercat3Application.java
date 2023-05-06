package excercises.wisercat3;

import excercises.wisercat3.security.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })

public class Wisercat3Application {

	public static void main(String[] args) {
		SpringApplication.run(Wisercat3Application.class, args);
	}

}
