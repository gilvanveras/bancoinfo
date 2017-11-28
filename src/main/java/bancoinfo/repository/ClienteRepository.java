package bancoinfo.repository;

import org.springframework.data.repository.CrudRepository;

import bancoinfo.model.Cliente;

/**
*
* @author gilvanveras
*/
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}