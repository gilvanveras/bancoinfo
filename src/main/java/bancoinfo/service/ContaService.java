package bancoinfo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bancoinfo.model.Conta;
import bancoinfo.model.Operacao;
import bancoinfo.model.enuns.TipoOperacao;
import bancoinfo.repository.ContaRepository;

/**
*
* @author gilvanveras
*/
@Service
@Transactional
public class ContaService {

	private final ContaRepository contaRepository;

	public ContaService(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}
	
	public List<Conta> listarTodas(){
		List<Conta> contas = new ArrayList<>();
		for(Conta conta : contaRepository.findAll()){
			contas.add(conta);
		}
		return contas;
	}
	
	public Conta procurar(int id){
		return contaRepository.findOne(id);
	}

	public Conta procurarPorNumero(int numero) {
		for(Conta conta : contaRepository.findAll()){
			if(conta.getNumero() == numero)
				return conta;
		}
		return null;
	}
	
	public void salvar(Conta conta){
		contaRepository.save(conta);
	}
	
	public void deletar(int id){
		contaRepository.delete(id);
	}
	
	public void deletarTodas() {
		contaRepository.deleteAll();
	}
	
	public void armazenarOperacao(Conta conta, TipoOperacao tipoOperacao, float valor) {
		List <Operacao> operacoes = conta.getOperacoes();
		
		Operacao operacao = new Operacao();
		operacao.setConta(conta);
		operacao.setData(new Date());
		operacao.setTipo(tipoOperacao);
		operacao.setValor(valor);
		operacoes.add(operacao);
		
		conta.setOperacoes(operacoes);
	}
	
	public String sacar(int id, float valor) {
		Conta conta = contaRepository.findOne(id);
		float saldoAtual = conta.getSaldo();
		if(saldoAtual - valor < 0.00) {
			return ("Saldo insuficiente para realizar operação!");
		}
		else {
			conta.setSaldo(saldoAtual - valor);
			this.armazenarOperacao(conta, TipoOperacao.SAQUE, valor);
			return ("Saque realizado com sucesso!");
		}
	}
	
	public String depositar(int id, float valor) {
		Conta conta = contaRepository.findOne(id);
		float saldoAtual = conta.getSaldo();		
		conta.setSaldo(saldoAtual + valor);
		this.armazenarOperacao(conta, TipoOperacao.DEPOSITO, valor);
		return ("Depósito realizado com sucesso!");
	}
	
	public String transferir(int id, int numeroDestino, float valor) {
		Conta contaOrigem = contaRepository.findOne(id);
		Conta contaDestino = this.procurarPorNumero(numeroDestino);
		float saldoAtualOrigem = contaOrigem.getSaldo();
		float saldoAtualDestino = contaDestino.getSaldo();
		if(saldoAtualOrigem - valor < 0.00) {
			return ("Saldo insuficiente para realizar operação!");
		} 			
		else {
			contaOrigem.setSaldo(saldoAtualOrigem - valor);
			contaDestino.setSaldo(saldoAtualDestino + valor);
			this.armazenarOperacao(contaOrigem, TipoOperacao.TRANSFERENCIA, valor);
			this.armazenarOperacao(contaDestino, TipoOperacao.DEPOSITO, valor);
			return ("Transferência realizado com sucesso!");
		}
	}
}
