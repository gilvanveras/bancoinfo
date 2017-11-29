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
@Table(name="cliente")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4762860042638022283L;

	@Id
	@GeneratedValue
	private int id;
	
    private String nome;
    private String cpf;
    private boolean administrador; 
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List <Conta> contas;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agencia_id")
    private Agencia agencia; 
    
    public Cliente(){}

	public Cliente(String nome, String cpf, List<Conta> contas, boolean administrador, Agencia agencia) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.contas = contas;
		this.administrador = administrador;
		this.agencia = agencia;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", administrador=" + administrador
				+ ", contas=" + contas + ", agencia=" + agencia + "]";
	}
}
