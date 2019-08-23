package co.com.proneps.ws.soap.implement;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;

import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;

import co.com.proneps.ws.soap.SolicitarTokenResponseService;
import co.com.proneps.ws.wsdl.SolicitarTokenResponse;

@Component
public class SolicitarTokenResponseServiceImplement implements SolicitarTokenResponseService{

	public SolicitarTokenResponseServiceImplement() {}
	
	@Override
	public SolicitarTokenResponse tokenResponseFromService(SOAPMessage soapMessage) {
		try {
			SOAPMessage response = soapMessage;
			SOAPBody body = response.getSOAPBody();			
			NodeList xmlItems = body.getElementsByTagName("return");
			SolicitarTokenResponse tokenResponse = new SolicitarTokenResponse();
			
			for (int i = 0; i < xmlItems.getLength(); i++) {
	            NodeList xmlSubItems = xmlItems.item(i).getChildNodes();	            
	            for (int j = 0; j < xmlSubItems.getLength(); j++) {	            	
	            	tokenResponse.setReturn(xmlSubItems.item(j).getTextContent());	            
	            }
			}			
			
			return tokenResponse;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}
