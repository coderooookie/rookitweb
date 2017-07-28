package pers.shubin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.ui.velocity.VelocityEngineFactory;
import org.apache.velocity.app.VelocityEngine;

@SpringBootApplication
@ConditionalOnClass({ VelocityEngine.class, VelocityEngineFactory.class })
public class RookiewebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RookiewebApplication.class, args);
	}
}
