package co.com.proneps.database.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PEPS_USUARIO_PRONEPS")
public class PepsUsuarioProneps {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USUARIO_PRONEPS")
	private Long idUsuarioProneps;
	
	@Column(name = "PARAM_TIPO_DOC")
	private Integer paramTipoDoc;
	
	@Column(name = "NUM_DOC")
	private Integer numDoc;
	
	@Column(name = "PRIMER_NOMBRE")
	private String primerNombre;
	
	@Column(name = "SEGUNDO_NOMBRE")
	private String segundoNombre;
	
	@Column(name = "PRIMER_APELLIDO")
	private String primerApellido;
	
	@Column(name = "SEGUNDO_APELLIDO")
	private String segundoApellido;
	
	@Column(name = "CORREO")
	private String correo;
	
	@Column(name = "PIN_SEGURIDAD")
	private Integer pinSeguridad;
	
	@Column(name = "USUARIO")
	private String usuario;
	
	@Column(name = "ID_TIPO_USUARIO")
	private Integer idTipoUsuario;
	
	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;
	
	@Column(name = "USUARIO_CREA_MOD")
	private String usuarioCreaMod;
	
	@Column(name = "FECHA_MODIFICACION")
	private Date fechaModificacion;
	
	@Column(name = "ID_TIPO_PERFIL")
	private Integer idTipoPerfil;

	public Long getIdUsuarioProneps() {
		return idUsuarioProneps;
	}

	public void setIdUsuarioProneps(Long idUsuarioProneps) {
		this.idUsuarioProneps = idUsuarioProneps;
	}

	public Integer getParamTipoDoc() {
		return paramTipoDoc;
	}

	public void setParamTipoDoc(Integer paramTipoDoc) {
		this.paramTipoDoc = paramTipoDoc;
	}

	public Integer getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(Integer numDoc) {
		this.numDoc = numDoc;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getPinSeguridad() {
		return pinSeguridad;
	}

	public void setPinSeguridad(Integer pinSeguridad) {
		this.pinSeguridad = pinSeguridad;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioCreaMod() {
		return usuarioCreaMod;
	}

	public void setUsuarioCreaMod(String usuarioCreaMod) {
		this.usuarioCreaMod = usuarioCreaMod;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Integer getIdTipoPerfil() {
		return idTipoPerfil;
	}

	public void setIdTipoPerfil(Integer idTipoPerfil) {
		this.idTipoPerfil = idTipoPerfil;
	}
	
	

}
