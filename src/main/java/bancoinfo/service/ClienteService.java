package bancoinfo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bancoinfo.model.Cliente;
import bancoinfo.repository.ClienteRepository;

/**
*
* @author gilvanveras
*/
@Service
@Transactional
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public List<Cliente> listarTodos(){
		List<Cliente> clientes = new ArrayList<>();
		for(Cliente cliente : clienteRepository.findAll()){
			clientes.add(cliente);
		}
		return clientes;
	}
	
	public Cliente procurar(int id){
		return clienteRepository.findOne(id);
	}
	
	public void salvar(Cliente cliente){
		clienteRepository.save(cliente);
	}
	
	public void deletar(int id){
		clienteRepository.delete(id);
	}
	
	public void deletarTodos() {
		clienteRepository.deleteAll();
	}
}

