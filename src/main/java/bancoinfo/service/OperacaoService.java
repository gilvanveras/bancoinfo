package bancoinfo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bancoinfo.model.Operacao;
import bancoinfo.repository.OperacaoRepository;

/**
*
* @author gilvanveras
*/
@Service
@Transactional
public class OperacaoService {
	
	private final OperacaoRepository operacaoRepository;

	public OperacaoService(OperacaoRepository operacaoRepository) {
		this.operacaoRepository = operacaoRepository;
	}
	
	public List<Operacao> listarTodas(){
		List<Operacao> operacoes = new ArrayList<>();
		for(Operacao operacao : operacaoRepository.findAll()){
			operacoes.add(operacao);
		}
		return operacoes;
	}
	
	public Operacao procurar(int id){
		return operacaoRepository.findOne(id);
	}
	
	public void salvar(Operacao operacao){
		operacaoRepository.save(operacao);
	}
	
	public void deletar(int id){
		operacaoRepository.delete(id);
	}
	
	public void deletarTodos() {
		operacaoRepository.deleteAll();
	}
}
