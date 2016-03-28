package io.adorable

import io.adorable.utils.MyResponseErrorHandler
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate

@Configuration
class DynamicRestTemplate {

	@Autowired
	private MappingJackson2HttpMessageConverter messageConverter;

    @Bean
    public RestTemplate restTemplate() {
    	HttpClientBuilder client = HttpClientBuilder.create();
    	// client.disableCookieManagement();
    	// client.disableContentCompression();
    	
    	HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(client.build())
    	
    	RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory)
    	// restTemplate.setErrorHandler(new MyResponseErrorHandler(messageConverter))
        return restTemplate;
    }

}
