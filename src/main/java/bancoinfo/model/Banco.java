package bancoinfo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *Declaração de variáveis e mapeamento JPA.
 * @author gilvanveras
 */
@Entity(name="banco")
public class Banco implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -5159497571222806696L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_criacao;
	
	@OneToMany(mappedBy = "banco", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List <Agencia> agencias;

	public Banco(){}

	public Banco(String nome, Date data_criacao, List<Agencia> agencias) {
		super();
		this.nome = nome;
		this.data_criacao = data_criacao;
		this.agencias = agencias;
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

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}
	
	public List<Agencia> getAgencias() {
		return agencias;
	}

	public void setAgencias(List<Agencia> agencias) {
		this.agencias = agencias;
	}

	@Override
	public String toString() {
		return "Banco [id=" + id + ", nome=" + nome + ", data_criacao=" + data_criacao + ", agencias=" + agencias + "]";
	}
}
