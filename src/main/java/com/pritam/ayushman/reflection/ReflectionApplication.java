package com.pritam.ayushman.reflection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReflectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReflectionApplication.class, args);
	}

//	@Configuration
//	@ComponentScan
//	public class ApplicationConfiguration {
//
//	}

//	private static void withConfigurationsInConstructor() {
//		ConfigurableApplicationContext applicationContext =
//				new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
//      Class<?> aClazz = Class.forName("com.pritam.ayushman.reflection.XYZ");
//      final GreetService greetService = applicationContext.getBean(aClazz);
//		final GreetService greetService = applicationContext.getBean(GreetService.class);
//		greetService.greet();
//
//		applicationContext.close();
//	}

//	private static void withRegistration() {
//		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//		applicationContext.register(ApplicationConfiguration.class);
//		applicationContext.refresh();
//
//		final GreetService greetService = applicationContext.getBean(GreetService.class);
//		greetService.greet();
//
//		applicationContext.close();
//	}

}
