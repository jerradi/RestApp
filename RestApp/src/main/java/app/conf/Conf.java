package app.conf;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc 
class CustomRestMvcConfiguration implements WebMvcConfigurer {

	private static final Integer CACHE_PERIOD = 31556926;

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 
		  registry.addResourceHandler("/rcss/**")
          .addResourceLocations("/resources/" )
          .setCachePeriod(CACHE_PERIOD);
	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Component
	class ServerConf implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
		@Override
		public void customize(ConfigurableServletWebServerFactory container) {
		 
			container.setPort(8081);
			container.setDisplayName("ThisIsADisplayName");
		}
	};
}
