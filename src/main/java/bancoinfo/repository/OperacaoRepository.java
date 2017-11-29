package bancoinfo.repository;

import org.springframework.data.repository.CrudRepository;

import bancoinfo.model.Operacao;

/**
*Estende CrudRepository pra obter acesso aos métodos básicos: create, read, update e delete
* @author gilvanveras
*/
public interface OperacaoRepository extends CrudRepository<Operacao, Integer>{

}
