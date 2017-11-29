package bancoinfo.repository;

import org.springframework.data.repository.CrudRepository;

import bancoinfo.model.Cliente;

/**
*Estende CrudRepository pra obter acesso aos métodos básicos: create, read, update e delete
* @author gilvanveras
*/
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}