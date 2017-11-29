package bancoinfo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bancoinfo.model.Cliente;
import bancoinfo.service.ClienteService;

/**
*Responsável por executar diretamente todas as ações requisitadas por cliente.jsp.
* @author gilvanveras
*/
@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/")
	public String listarClientes(HttpServletRequest request) {
		request.setAttribute("clientes", clienteService.listarTodos());
		request.setAttribute("mode", "CLIENTES");
		return "cliente";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrarCliente(HttpServletRequest request) {
		request.setAttribute("mode", "CRIAR_CLIENTE");
		return "cliente";
	}

	@PostMapping("/salvar")
	public String salvarCliente(@ModelAttribute Cliente cliente, BindingResult bindingResult, HttpServletRequest request) {
		clienteService.salvar(cliente);
		request.setAttribute("clientes", clienteService.listarTodos());
		request.setAttribute("mode", "CLIENTES");
		return "cliente";
	}

	@GetMapping("/atualizar")
	public String atualizarCliente(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("cliente", clienteService.procurar(id));
		request.setAttribute("mode", "ATUALIZAR_CLIENTE");
		return "cliente";
	}

	@GetMapping("/deletar")
	public String deletarCliente(@RequestParam int id, HttpServletRequest request) {
		clienteService.deletar(id);
		request.setAttribute("clientes", clienteService.listarTodos());
		request.setAttribute("mode", "CLIENTES");
		return "cliente";
	}
}
