package co.com.proneps.ws.rest;

import org.springframework.http.ResponseEntity;

import co.com.proneps.ws.json.AuthRequest;
import co.com.proneps.ws.json.AuthResponse;

public interface PronepsRepositoryClient {
	ResponseEntity<AuthResponse> validateUserIdentification(AuthRequest body);
}
