package bancoinfo.repository;

import org.springframework.data.repository.CrudRepository;

import bancoinfo.model.Conta;

/**
*
* @author gilvanveras
*/
public interface ContaRepository extends CrudRepository<Conta, Integer>{
	
}
