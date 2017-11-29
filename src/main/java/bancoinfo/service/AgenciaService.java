package bancoinfo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bancoinfo.model.Agencia;
import bancoinfo.repository.AgenciaRepository;

/**
*Métodos usados por AgenciaController para persistir os dados.
* @author gilvanveras
*/
@Service
@Transactional
public class AgenciaService {

	private final AgenciaRepository agenciaRepository;

	public AgenciaService(AgenciaRepository agenciaRepository) {
		this.agenciaRepository = agenciaRepository;
	}
	
	public List<Agencia> listarTodas(){
		List<Agencia> agencias = new ArrayList<>();
		for(Agencia agencia : agenciaRepository.findAll()){
			agencias.add(agencia);
		}
		return agencias;
	}
	
	public Agencia procurar(int id){
		return agenciaRepository.findOne(id);
	}
	
	public void salvar(Agencia agencia){
		agenciaRepository.save(agencia);
	}
	
	public void deletar(int id){
		agenciaRepository.delete(id);
	}
}
