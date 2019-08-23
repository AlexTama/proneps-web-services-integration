package co.com.proneps.ws.rest.implement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import co.com.proneps.ws.config.PronepsRepositoryConfig;
import co.com.proneps.ws.json.AuthRequest;
import co.com.proneps.ws.json.AuthResponse;
import co.com.proneps.ws.rest.PronepsRepositoryClient;

@Service
public class PronepsRepositoryClientImplement implements PronepsRepositoryClient {
	private static final Logger LOG = LoggerFactory.getLogger(PronepsRepositoryClientImplement.class);
	
	@Value("${repository.url}")
	private String url;
	
	@Autowired
	private PronepsRepositoryConfig prConfig;
	
	@Bean
	private RestTemplate restTemplate() {
		return new RestTemplate();
	};

	@Override
	public ResponseEntity<AuthResponse> validateUserIdentification(AuthRequest body) {
		try {
			HttpEntity<AuthRequest> requestEntity = this.prConfig.getHeaders(body);
			String url = this.url + "validar/usuario";
			ResponseEntity<String> responseEntity = this.restTemplate()
					.exchange(url, HttpMethod.POST, requestEntity, String.class);
						
			return ResponseEntity.status(responseEntity.getStatusCode())
					.body(new AuthResponse(responseEntity.getStatusCode(),
							responseEntity.getStatusCodeValue(), "Valores correctos"));
		
		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new AuthResponse(HttpStatus.NOT_FOUND, e.getRawStatusCode(), e.getMessage()));
			
		} catch (HttpServerErrorException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new AuthResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getRawStatusCode(), e.getLocalizedMessage()));
		}
	}

}
