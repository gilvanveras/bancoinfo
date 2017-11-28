package bancoinfo.repository;

import org.springframework.data.repository.CrudRepository;

import bancoinfo.model.Operacao;

public interface OperacaoRepository extends CrudRepository<Operacao, Integer>{

}
