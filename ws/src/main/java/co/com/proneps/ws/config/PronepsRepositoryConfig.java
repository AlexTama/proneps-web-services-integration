package co.com.proneps.ws.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import co.com.proneps.ws.json.AuthRequest;

@Component
public class PronepsRepositoryConfig {
	
	/**
	 * 
	 * @param body
	 * @param accountName
	 * @return
	 */
	public HttpEntity<AuthRequest> getHeaders(AuthRequest body) {		
		List<MediaType> acceptTypes = new ArrayList<MediaType>();
		acceptTypes.add(MediaType.APPLICATION_JSON_UTF8);
//		 HttpEntity<String> httpEntity = new HttpEntity<>(body, this.getHeadersConfig());		
		 HttpEntity<AuthRequest> httpEntity = new HttpEntity<>(body, this.getHeadersConfig());		
		return httpEntity;
	}
	
	private HttpHeaders getHeadersConfig() {		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Content-Type", "application/json");		
		return headers;
	}
	
}
