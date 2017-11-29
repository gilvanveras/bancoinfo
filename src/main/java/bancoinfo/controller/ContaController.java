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

import bancoinfo.model.Conta;
import bancoinfo.service.ContaService;

/**
*Responsável por executar diretamente todas as ações requisitadas por conta.jsp.
* @author gilvanveras
*/
@Controller
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@GetMapping("/")
	public String listarContas(HttpServletRequest request) {
		request.setAttribute("contas", contaService.listarTodas());
		request.setAttribute("mode", "CONTAS");
		return "conta";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrarConta(HttpServletRequest request) {
		request.setAttribute("mode", "CRIAR_CONTA");
		return "conta";
	}

	@PostMapping("/salvar")
	public String salvarConta(@ModelAttribute Conta conta, BindingResult bindingResult, HttpServletRequest request) {
		contaService.salvar(conta);
		request.setAttribute("contas", contaService.listarTodas());
		request.setAttribute("mode", "CONTAS");
		return "conta";
	}

	@GetMapping("/atualizar")
	public String atualizarConta(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("conta", contaService.procurar(id));
		request.setAttribute("mode", "ATUALIZAR_CONTA");
		return "conta";
	}

	@GetMapping("/deletar")
	public String deletarBanco(@RequestParam int id, HttpServletRequest request) {
		contaService.deletar(id);
		request.setAttribute("contas", contaService.listarTodas());
		request.setAttribute("mode", "CONTAS");
		return "conta";
	}
	
	@GetMapping("/paginaSacar")
	public String paginaSacar(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("conta", contaService.procurar(id));
		request.setAttribute("contas", contaService.listarTodas());
		request.setAttribute("mode", "SACAR");
		return "conta";
	}
	
	@PostMapping("/sacar")
	public String sacar(@ModelAttribute Conta conta, BindingResult bindingResult, @RequestParam int id, @RequestParam("valor") float valor, HttpServletRequest request) {
		contaService.sacar(id, valor);
		request.setAttribute("contas", contaService.listarTodas());
		request.setAttribute("mode", "CONTAS");
		return "conta";
	}
	
	@GetMapping("/paginaDepositar")
	public String paginaDepositar(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("conta", contaService.procurar(id));
		request.setAttribute("contas", contaService.listarTodas());
		request.setAttribute("mode", "DEPOSITAR");
		return "conta";
	}
	
	@PostMapping("/depositar")
	public String depositar(@ModelAttribute Conta conta, BindingResult bindingResult, @RequestParam int id, @RequestParam("valor") float valor, HttpServletRequest request) {
		contaService.depositar(id, valor);
		request.setAttribute("contas", contaService.listarTodas());
		request.setAttribute("mode", "CONTAS");
		return "conta";
	}
	
	@GetMapping("/paginaTransferir")
	public String paginaTransferir(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("conta", contaService.procurar(id));
		request.setAttribute("contas", contaService.listarTodas());
		request.setAttribute("mode", "TRANSFERIR");
		return "conta";
	}
	
	@PostMapping("/transferir")
	public String transferir(@ModelAttribute Conta conta, BindingResult bindingResult, @RequestParam int id, @RequestParam("numeroDestino") int numeroDestino, @RequestParam("valor") float valor, HttpServletRequest request) {
		contaService.transferir(id, numeroDestino, valor);
		request.setAttribute("contas", contaService.listarTodas());
		request.setAttribute("mode", "CONTAS");
		return "conta";
	}
}
