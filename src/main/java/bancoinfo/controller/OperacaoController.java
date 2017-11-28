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

import bancoinfo.model.Operacao;
import bancoinfo.service.OperacaoService;

/**
*
* @author gilvanveras
*/
@Controller
@RequestMapping("/operacoes")
public class OperacaoController {

	@Autowired
	private OperacaoService operacaoService;

	@GetMapping("/")
	public String listarOperacoes(HttpServletRequest request) {
		request.setAttribute("operacoes", operacaoService.listarTodas());
		request.setAttribute("mode", "OPERACOES");
		return "operacao";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrarOperacao(HttpServletRequest request) {
		request.setAttribute("mode", "CRIAR_OPERACAO");
		return "operacao";
	}

	@PostMapping("/salvar")
	public String salvarBanco(@ModelAttribute Operacao operacao, BindingResult bindingResult, HttpServletRequest request) {
		operacao.setData(new Date());
		operacaoService.salvar(operacao);
		request.setAttribute("operacoes", operacaoService.listarTodas());
		request.setAttribute("mode", "OPERACOES");
		return "operacao";
	}

	@GetMapping("/atualizar")
	public String atualizarOperacao(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("operacao", operacaoService.procurar(id));
		request.setAttribute("mode", "ATUALIZAR_OPERACAO");
		return "operacao";
	}

	@GetMapping("/deletar")
	public String deletarOperacao(@RequestParam int id, HttpServletRequest request) {
		operacaoService.deletar(id);
		request.setAttribute("operacoes", operacaoService.listarTodas());
		request.setAttribute("mode", "OPERACOES");
		return "operacao";
	}
}
