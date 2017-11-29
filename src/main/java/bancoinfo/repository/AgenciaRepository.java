package bancoinfo.repository;

import org.springframework.data.repository.CrudRepository;

import bancoinfo.model.Agencia;

/**
*Estende CrudRepository pra obter acesso aos métodos básicos: create, read, update e delete
* @author gilvanveras
*/
public interface AgenciaRepository extends CrudRepository<Agencia, Integer>{

}
