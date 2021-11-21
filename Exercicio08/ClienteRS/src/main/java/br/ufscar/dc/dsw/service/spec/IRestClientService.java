package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Teste;

public interface IRestClientService {
	
	Long create(Teste t);	
	
	List<Teste> get();
	Teste get(Long id);
	
	boolean update(Teste t);
	
	boolean delete(Long id);
}
