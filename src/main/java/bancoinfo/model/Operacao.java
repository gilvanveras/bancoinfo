package bancoinfo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import bancoinfo.model.enuns.TipoOperacao;

/**
 *
 * @author gilvanveras
 */
@Entity
@Table(name = "operacao")
public class Operacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4816695011109010590L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private float valor;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Enumerated(EnumType.STRING)
	private TipoOperacao tipo;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conta_id")
	private Conta conta;

	public Operacao(){}

	public Operacao(float valor, Date data, TipoOperacao tipo, Conta conta) {
		super();
		this.valor = valor;
		this.data = data;
		this.tipo = tipo;
		this.conta = conta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoOperacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoOperacao descricao) {
		this.tipo = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "Operacao [id=" + id + ", valor=" + valor + ", data=" + data + ", tipo=" + tipo + ", conta=" + conta
				+ "]";
	}
}
