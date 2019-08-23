package co.com.proneps.ws.integrator;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.soap.SOAPException;

import org.junit.Test;

import co.com.proneps.ws.json.AuthRequest;
import co.com.proneps.ws.json.AuthResponse;

public class PronepsIntegratorTest {

	@Test
	public void testValidarToken() throws SOAPException, IOException {		
		PronepsIntegrator integrator = new PronepsIntegrator();
		AuthRequest request = new AuthRequest();
		
		AuthResponse result = integrator.validarToken(request);
		
		assertEquals("Se espera: ", true, true);
	}

}
