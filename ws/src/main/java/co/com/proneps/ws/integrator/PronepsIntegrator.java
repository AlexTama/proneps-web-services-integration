package co.com.proneps.ws.integrator;

import java.io.IOException;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import co.com.proneps.ws.json.AuthRequest;
import co.com.proneps.ws.json.AuthResponse;
import co.com.proneps.ws.soap.SolicitarTokenClient;
import co.com.proneps.ws.wsdl.SolicitarTokenResponse;
import co.com.proneps.ws.xml.SolicitarTokenXMLGenerator;

@Component
public class PronepsIntegrator {
	private static final Logger LOG = LoggerFactory.getLogger(PronepsIntegrator.class);
	
	@Autowired
	private SolicitarTokenClient stClient;
	
	public AuthResponse validarToken(AuthRequest request) throws SOAPException, IOException {
		try {			
			SolicitarTokenResponse response = (SolicitarTokenResponse) stClient.solicitarTokenClient(request);
			
			if(!ObjectUtils.isEmpty(response.getReturn()))
				return new AuthResponse(HttpStatus.OK, 200, "Token Auth:" + response.getReturn());			
			return new AuthResponse(HttpStatus.UNAUTHORIZED, 403, "No Auth:");
			
		} catch (Exception e) {
			LOG.info(e.getMessage());
			return new AuthResponse(HttpStatus.INTERNAL_SERVER_ERROR, 500, "Internal server error: " + e.getMessage());
		}
	}
}
