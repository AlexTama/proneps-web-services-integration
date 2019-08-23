package co.com.proneps.ws.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthRequest {
	
	@JsonProperty("tipoIdentificacion")
	private String tipoIdentificacion;
	
	@JsonProperty("numeroIdentificacion")
	private String numeroIdentificacion;
	
	@JsonProperty("contrasena")
	private String contrasena;
	
	@JsonProperty("pinSeguridad")
	private Integer pinSeguridad;
	
	public AuthRequest(){}
	
	public AuthRequest(String tipoIdentificacion, String numeroIdentificacion, String contrasena,
			Integer pinSeguridad) {
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.contrasena = contrasena;
		this.pinSeguridad = pinSeguridad;
	}
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Integer getPinSeguridad() {
		return pinSeguridad;
	}
	public void setPinSeguridad(Integer pinSeguridad) {
		this.pinSeguridad = pinSeguridad;
	}
	
}