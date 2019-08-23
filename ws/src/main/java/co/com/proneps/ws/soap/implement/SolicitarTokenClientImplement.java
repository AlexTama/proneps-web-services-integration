package co.com.proneps.ws.soap.implement;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.com.proneps.ws.json.AuthRequest;
import co.com.proneps.ws.soap.SolicitarTokenClient;
import co.com.proneps.ws.soap.SolicitarTokenResponseService;
import co.com.proneps.ws.wsdl.SolicitarTokenResponse;
import co.com.proneps.ws.xml.SolicitarTokenXMLGenerator;

@Service
public class SolicitarTokenClientImplement implements SolicitarTokenClient{
	private static final Logger LOG = LoggerFactory.getLogger(SolicitarTokenClientImplement.class);
	
	@Value("${client.soap.solicitar_token_url}")
	private String url;	
	
	public SolicitarTokenClientImplement() {}
	
	@Autowired
	private SolicitarTokenResponseService stResponseService;

	@Override
	public Object solicitarTokenClient(AuthRequest request) {		
		try {			
			// Create soap connection to call web service
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
                        
            // Create request for soap connection           
            
            SOAPMessage soapResponse = soapConnection.call(new SolicitarTokenXMLGenerator().solicitarTokenXmlRequest(request), this.url);
            SolicitarTokenResponse response = this.stResponseService.tokenResponseFromService(soapResponse);
            
            // Validate token request
            // Create validate token response
            
            soapConnection.close();
            return response; // Return validate token response
                        
		} catch (Exception e) {
			LOG.error("Error al generar el token: " + e.getMessage());
			return null;
		}
	}
}
