package br.com.caelum.estoque.modelo.fault;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault implements Serializable {

	private static final long serialVersionUID = -7852676532066822072L;
	private Date data;
	private String mensagem;

	public InfoFault() {
		super();
		this.data = new Date();
	}

	public InfoFault(String mensagem) {
		this();
		this.mensagem = mensagem;
	}

	public Date getData() {
		return data;
	}

	public String getMensagem() {
		return mensagem;
	}

}
