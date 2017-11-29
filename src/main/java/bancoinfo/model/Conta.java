package bancoinfo.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *Declaração de variáveis e mapeamento JPA.
 * @author gilvanveras
 */
@Entity
@Table(name="conta")
public class Conta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3968490271780637534L;

	@Id
	@GeneratedValue
	private int id;
	
    private int numero;
    private float saldo;
    
    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List <Operacao> operacoes;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    public Conta(){}

	public Conta(int numero, float saldo, List<Operacao> operacoes, Cliente cliente) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.operacoes = operacoes;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public List<Operacao> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(List<Operacao> operacoes) {
		this.operacoes = operacoes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", operacoes=" + operacoes + ", cliente="
				+ cliente + "]";
	}
}