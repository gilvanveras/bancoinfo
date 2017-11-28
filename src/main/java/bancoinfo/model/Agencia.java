package bancoinfo.model;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gilvanveras
 */
@Entity
@Table(name="agencia")
public class Agencia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4122168527428945350L;

	@Id
	@GeneratedValue
	private int id;
	
    private int numero;
    
    @Temporal(TemporalType.TIMESTAMP)
	private Date data_criacao;
    
    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List <Cliente> clientes;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "banco_id")
    private Banco banco;
    
    public Agencia(){}

	public Agencia(int numero, Date data_criacao, List<Cliente> clientes, Banco banco) {
		super();
		this.numero = numero;
		this.data_criacao = data_criacao;
		this.clientes = clientes;
		this.banco = banco;
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

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	@Override
	public String toString() {
		return "Agencia [id=" + id + ", numero=" + numero + ", data_criacao=" + data_criacao + ", clientes=" + clientes
				+ ", banco=" + banco + "]";
	}
}