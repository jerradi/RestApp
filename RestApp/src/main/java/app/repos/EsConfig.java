
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

@Configuration
@EnableElasticsearchRepositories(basePackages = "hello")
public class EsConfig {

	 
 
 
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
