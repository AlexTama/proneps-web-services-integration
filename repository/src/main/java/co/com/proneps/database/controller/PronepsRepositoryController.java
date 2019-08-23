package co.com.proneps.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.proneps.database.entity.PepsUsuarioProneps;
import co.com.proneps.database.json.AuthRequest;
import co.com.proneps.database.json.AuthResponse;
import co.com.proneps.database.service.PepsUsuarioPronepsService;

@RestController
@RequestMapping("/proneps/repository/")
public class PronepsRepositoryController {

//	@Autowired
//	private UsuarioService usuarioService;
	
	@Autowired
	private PepsUsuarioPronepsService ppService;
	
	@RequestMapping(value = "usuario/{numeroIdentificacion}", method = RequestMethod.GET)
	public ResponseEntity<Iterable<PepsUsuarioProneps>> prueba(@PathVariable("numeroIdentificacion") String numeroIdentificacion) {
//		Usuarios response = usuarioService.obtenerUsuarioDocumento(numeroIdentificacion);
		Iterable<PepsUsuarioProneps> response = ppService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@RequestMapping(value = "validar/usuario", method = RequestMethod.POST)
	public ResponseEntity<AuthResponse> validarIdentificacionUsuario(@RequestBody AuthRequest request){		
//		boolean result = usuarioService.validarIdentificacionUsuario(request.getNumeroIdentificacion(), request.getTipoIdentificacion());
//		if (result) {
//			return ResponseEntity.status(HttpStatus.OK)
//					.body(new AuthResponse(HttpStatus.OK, 200, "Valores correctos"));
//		}
				
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new AuthResponse(HttpStatus.NOT_FOUND, 404, "Los valores no coinciden"));
	}
	
}
