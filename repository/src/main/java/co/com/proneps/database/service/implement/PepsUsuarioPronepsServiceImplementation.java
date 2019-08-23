package co.com.proneps.database.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.proneps.database.entity.PepsUsuarioProneps;
import co.com.proneps.database.repository.PepsUsuarioPronepsRepository;
import co.com.proneps.database.service.PepsUsuarioPronepsService;

@Service
public class PepsUsuarioPronepsServiceImplementation implements PepsUsuarioPronepsService{
	
	public PepsUsuarioPronepsServiceImplementation(PepsUsuarioPronepsRepository ppRepository) {
		this.ppRepository = ppRepository;
	}

	@Autowired
	private PepsUsuarioPronepsRepository ppRepository;
	
	@Override
	public PepsUsuarioProneps findByIdentification(Integer paramTipoDoc, Integer numDoc, String usuario) { 
		return null;
	}

	@Override
	public Iterable<PepsUsuarioProneps> findAll() {
		return this.ppRepository.findAll();
	}

}
