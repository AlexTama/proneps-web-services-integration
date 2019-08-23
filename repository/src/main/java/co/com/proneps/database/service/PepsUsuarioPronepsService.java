package co.com.proneps.database.service;

import co.com.proneps.database.entity.PepsUsuarioProneps;

public interface PepsUsuarioPronepsService {
	PepsUsuarioProneps findByIdentification(Integer paramTipoDoc, Integer numDoc, String usuario);
	Iterable<PepsUsuarioProneps> findAll();
}
