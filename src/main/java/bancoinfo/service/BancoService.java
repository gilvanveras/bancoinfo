package bancoinfo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bancoinfo.model.Banco;
import bancoinfo.repository.BancoRepository;

/**
*
* @author gilvanveras
*/
@Service
@Transactional
public class BancoService {

	private final BancoRepository bancoRepository;

	public BancoService(BancoRepository bancoRepository) {
		this.bancoRepository = bancoRepository;
	}
	
	public List<Banco> listarTodos(){
		List<Banco> bancos = new ArrayList<>();
		for(Banco banco : bancoRepository.findAll()){
			bancos.add(banco);
		}
		return bancos;
	}
	
	public Banco procurar(int id){
		return bancoRepository.findOne(id);
	}
	
	public void salvar(Banco banco){
		bancoRepository.save(banco);
	}
	
	public void deletar(int id){
		bancoRepository.delete(id);
	}
	
	public void deletarTodos() {
		bancoRepository.deleteAll();
	}
}
