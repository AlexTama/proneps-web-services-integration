package co.com.proneps.ws.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.junit.Test;

import co.com.proneps.ws.json.AuthRequest;

public class SolicitarTokenXMLGeneratorTest {

	
	@Test
	public void testSolicitarTokenXmlRequest() throws SOAPException, IOException {		
		AuthRequest request = new AuthRequest();				
		String expect = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://serviciotokenseguridad.nuevaepsws.nuevaeps.com.co/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><SOAP-ENV:Header><wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><wsse:UsernameToken><wsse:TipoUsuario>Externo</wsse:TipoUsuario><wsse:Username>3-22222222</wsse:Username><wsse:Password>22222222</wsse:Password></wsse:UsernameToken></wsse:Security></SOAP-ENV:Header><SOAP-ENV:Body><ser:SolicitarToken/></SOAP-ENV:Body></SOAP-ENV:Envelope>";
				
		SOAPMessage result = new SolicitarTokenXMLGenerator().solicitarTokenXmlRequest(request);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		result.writeTo(out);
		String resultXml = new String(out.toByteArray());
		
		assertEquals("Se espera: ", expect, resultXml);
	}

	@Test
	public void testValidarTokenXmlRequest() {
		fail("Not yet implemented");
	}

}
