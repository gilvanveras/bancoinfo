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

import bancoinfo.model.Agencia;
import bancoinfo.service.AgenciaService;

/**
*Responsável por executar diretamente todas as ações requisitadas por agencia.jsp. 
* @author gilvanveras
*/
@Controller
@RequestMapping("/agencias")
public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;
	
	@GetMapping("/")
	public String listarAgencias(HttpServletRequest request) {
		request.setAttribute("agencias", agenciaService.listarTodas());
		request.setAttribute("mode", "AGENCIAS");
		return "agencia";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrarAgencia(HttpServletRequest request) {
		request.setAttribute("mode", "CRIAR_AGENCIA");
		return "agencia";
	}

	@PostMapping("/salvar")
	public String salvarAgencia(@ModelAttribute Agencia agencia, BindingResult bindingResult, HttpServletRequest request) {
		agencia.setData_criacao(new Date());
		agenciaService.salvar(agencia);
		request.setAttribute("agencias", agenciaService.listarTodas());
		request.setAttribute("mode", "AGENCIAS");
		return "agencia";
	}

	@GetMapping("/atualizar")
	public String atualizarAgencia(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("agencia", agenciaService.procurar(id));
		request.setAttribute("mode", "ATUALIZAR_AGENCIA");
		return "agencia";
	}

	@GetMapping("/deletar")
	public String deletarAgencia(@RequestParam int id, HttpServletRequest request) {
		agenciaService.deletar(id);
		request.setAttribute("agencias", agenciaService.listarTodas());
		request.setAttribute("mode", "AGENCIAS");
		return "agencia";
	}
}