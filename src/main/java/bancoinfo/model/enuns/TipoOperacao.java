package bancoinfo.model.enuns;

/**
*
* @author gilvanveras
*/
public enum TipoOperacao {
	SAQUE("SAQUE"),
	DEPOSITO("DEPOSITO"),
	TRANSFERENCIA("TRANSFERENCIA");
	
	private String descricao;

	private TipoOperacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
