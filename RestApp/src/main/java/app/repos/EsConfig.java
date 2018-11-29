
package app.repos;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
@EnableElasticsearchRepositories(basePackages = "app.repos")
public class EsConfig {

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {

		return new RepositoryRestConfigurerAdapter() {

			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config.setBasePath("/api");
			}
		};
	}

 
 
	@Bean
	public Client client() throws Exception {

	 

		Settings settings = Settings.builder() 
		    .put("cluster.name", "jamal") 
		    .build();

 
		return  new PreBuiltTransportClient(settings)

				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9400)) ;
	 
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws Exception {
		return new ElasticsearchTemplate(client());
	}

	// Embedded Elasticsearch Server
	/*
	 * @Bean public ElasticsearchOperations elasticsearchTemplate() { return new
	 * ElasticsearchTemplate(nodeBuilder().local(true).node().client()); }
	 */

}
