package uce.edu.ec.main;

/**
 * @author Byron Flores
 * @Theme Api Nasa
 */

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import uce.edu.ec.container.Controller;


@SpringBootApplication
@ComponentScan(basePackages = {"uce.edu.ec.container", "uce.edu.ec.service", "uce.edu.ec.model", "uce.edu.ec.view"})
public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(Main.class).headless(false).run(args);
		Controller controller = context.getBean(Controller.class);
	}
}