package co.com.proneps.ws.controller;

import java.io.IOException;

import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.proneps.ws.integrator.PronepsIntegrator;
import co.com.proneps.ws.json.AuthRequest;
import co.com.proneps.ws.json.AuthResponse;
import co.com.proneps.ws.rest.PronepsRepositoryClient;

@RestController
@RequestMapping("/proneps/ws/")
public class ProNepsWsContoller {
		
	@Autowired
	private PronepsIntegrator integrator;
	
	@Autowired
	private PronepsRepositoryClient prClient;
	
	@RequestMapping(value = "login/", method = RequestMethod.POST)
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) throws SOAPException, IOException{		
		ResponseEntity<AuthResponse> responsePrClient = this.prClient.validateUserIdentification(request);				
		if(HttpStatus.OK.equals(responsePrClient.getStatusCode())) {
			
			AuthResponse response = this.integrator.validarToken(request);			
			if(!ObjectUtils.isEmpty(response)) 									
				return ResponseEntity.status(response.getStatus())
						.body(response);					
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new AuthResponse(HttpStatus.INTERNAL_SERVER_ERROR, 500,"Internal server error"));
		}
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new AuthResponse(HttpStatus.NOT_FOUND, 404, "Los valores no coinciden"));
	}
}
