package co.com.proneps.ws.soap;

import co.com.proneps.ws.json.AuthRequest;
import co.com.proneps.ws.wsdl.SolicitarTokenResponse;

public interface SolicitarTokenClient {
	Object solicitarTokenClient(AuthRequest request);
}
