/**

Project: AUTORESCUE
Copyright (c) nttdata 2024 

*/
package autorescue.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StringUtils;

public class YamlPropertiesApplicationContextInitializer
		implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Autowired
	private MessageSource messageSource;

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		String activeProfile = System.getProperty("entorn");

		try {
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			Resource[] resources = resolver.getResources("classpath*:config/props/*.yml");

			ConfigurableEnvironment environment = applicationContext.getEnvironment();
			MutablePropertySources propertySources = environment.getPropertySources();
			for (Resource resource : resources) {
				String filename = resource.getFilename();
				if (StringUtils.hasText(filename) && filename.contains(activeProfile)) {
					YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
					PropertySource<?> propertySource = loader.load(filename, resource).get(0);
					propertySources.addFirst(propertySource);
				}
			}
		} catch (IOException ex) {
			throw new IllegalStateException(
					messageSource.getMessage("error.configuration.load.yaml", null, LocaleContextHolder.getLocale()),
					ex);
		}
	}
}
