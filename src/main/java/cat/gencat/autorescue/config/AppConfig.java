/**

Project: AUTORESCUE
Copyright (c) nttdata 2024 

*/
package cat.gencat.autorescue.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableCaching
@EnableFeignClients
@EnableRetry
public class AppConfig implements WebMvcConfigurer {
	
	@Autowired
	private RequestLoggingInterceptor requestLoggingInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestLoggingInterceptor);
	}

}
