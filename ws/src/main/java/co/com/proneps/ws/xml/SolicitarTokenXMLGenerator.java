package co.com.proneps.ws.xml;

import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.proneps.ws.json.AuthRequest;

public class SolicitarTokenXMLGenerator {
	
	private static final Logger LOG = LoggerFactory.getLogger(SolicitarTokenXMLGenerator.class);
	
	public SOAPMessage solicitarTokenXmlRequest(AuthRequest request) throws SOAPException, IOException {
		MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        
        // Create the envelope declaration
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("ser", "http://serviciotokenseguridad.nuevaepsws.nuevaeps.com.co/");
        envelope.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
        
        // Create the soap header section
        SOAPHeader header = envelope.getHeader();
        
        SOAPElement security = 
        		header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"); 
        
        SOAPElement usernameToken =
        		security.addChildElement("UsernameToken", "wsse");
        
        SOAPElement tipoUsuario =
        		usernameToken.addChildElement("TipoUsuario", "wsse");
        tipoUsuario.addTextNode("Externo");
        
        SOAPElement username =
        		usernameToken.addChildElement("Username", "wsse");
        username.addTextNode("3-22222222");
        
        SOAPElement password =
        		usernameToken.addChildElement("Password", "wsse");
        password.addTextNode("22222222");        
        
        // Create soap body
        SOAPBody soapBody = envelope.getBody();        
        SOAPElement solicitarToken = soapBody.addChildElement("SolicitarToken", "ser");       
        
        soapMessage.saveChanges();
        
        LOG.info("XML Request");
        soapMessage.writeTo(System.out);
        
        return soapMessage;        
	}
	
	public void validarTokenXmlRequest() {
		// TODO --> Code implementation
	}

}
