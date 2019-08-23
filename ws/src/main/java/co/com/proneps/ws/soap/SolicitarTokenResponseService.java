package co.com.proneps.ws.soap;

import javax.xml.soap.SOAPMessage;

import co.com.proneps.ws.wsdl.SolicitarTokenResponse;

public interface SolicitarTokenResponseService {
	SolicitarTokenResponse tokenResponseFromService(SOAPMessage soapMessage);
}
