/**

Project: AUTORESCUE
Copyright (c) nttdata 2024 

*/
package cat.gencat.autorescue;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import cat.gencat.autorescue.config.YamlPropertiesApplicationContextInitializer;

@SpringBootApplication(scanBasePackages = "cat.gencat.autorescue")
@EnableFeignClients
@EnableScheduling
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		if (System.getProperty("entorn") == null) {
			System.setProperty("entorn", "loc");
		}

		if (System.getProperty("application.defaultLanguage") == null) {
			System.setProperty("application.defaultLanguage", "ca_ES");
		}

		SpringApplicationBuilder builder = new SpringApplicationBuilder();
		addSourcesAndInitializers(builder);
		builder.run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return addSourcesAndInitializers(builder);
	}

	private static SpringApplicationBuilder addSourcesAndInitializers(SpringApplicationBuilder builder) {
		addSources(builder);
		addInitializers(builder);
		return builder;
	}

	private static SpringApplicationBuilder addSources(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	private static SpringApplicationBuilder addInitializers(SpringApplicationBuilder builder) {
		return builder.initializers(new YamlPropertiesApplicationContextInitializer());
	}

}
