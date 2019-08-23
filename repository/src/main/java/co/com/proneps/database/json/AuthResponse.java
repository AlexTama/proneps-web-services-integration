package co.com.proneps.database.json;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse {

	@JsonProperty("status")
	private HttpStatus status;
	
	@JsonProperty("responseCode")
	private int responseCode;
	
	@JsonProperty("message")
	private String message;

	public AuthResponse(HttpStatus status, int responseCode, String message) {
		this.status = status;
		this.responseCode = responseCode;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	

}
