package co.com.proneps.ws.soap.implement;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.xml.soap.SOAPException;

import org.junit.Test;
import org.springframework.context.annotation.Bean;

import co.com.proneps.ws.json.AuthRequest;
import co.com.proneps.ws.wsdl.SolicitarTokenResponse;
import co.com.proneps.ws.xml.SolicitarTokenXMLGenerator;

public class SolicitarTokenClientImplementTest {

	@Bean
	private SolicitarTokenClientImplement stClient() {
		return new SolicitarTokenClientImplement();
	};
	
	@Bean
	private SolicitarTokenXMLGenerator xmlGenerator() {
		return new SolicitarTokenXMLGenerator();
	}
	
	@Test
	public void testGetAuthToken() throws SOAPException, IOException {
		AuthRequest request = new AuthRequest();
		SolicitarTokenResponse response = (SolicitarTokenResponse) this.stClient().solicitarTokenClient(request);
		
		assertNotNull("Expect response", response);		
		
	}

}
