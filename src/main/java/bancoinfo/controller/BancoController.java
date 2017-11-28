package bancoinfo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bancoinfo.model.Banco;
import bancoinfo.service.BancoService;

/**
 *
 * @author gilvanveras
 */
@Controller
@RequestMapping("/bancos")
public class BancoController {

	@Autowired
	private BancoService bancoService;

	@GetMapping("/")
	public String listarBancos(HttpServletRequest request) {
		request.setAttribute("bancos", bancoService.listarTodos());
		request.setAttribute("mode", "MODE_BANCOS");
		return "banco";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrarBanco(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "banco";
	}

	@PostMapping("/salvar")
	public String salvarBanco(@ModelAttribute Banco banco, BindingResult bindingResult, HttpServletRequest request) {
		banco.setData_criacao(new Date());
		bancoService.salvar(banco);
		request.setAttribute("bancos", bancoService.listarTodos());
		request.setAttribute("mode", "MODE_BANCOS");
		return "banco";
	}

	@GetMapping("/atualizar")
	public String atualizarBanco(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("banco", bancoService.procurar(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "banco";
	}

	@GetMapping("/deletar")
	public String deletarBanco(@RequestParam int id, HttpServletRequest request) {
		bancoService.deletar(id);
		request.setAttribute("bancos", bancoService.listarTodos());
		request.setAttribute("mode", "MODE_BANCOS");
		return "banco";
	}
}
