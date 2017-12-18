package br.com.caelum.estoque.modelo.fault;

import javax.xml.ws.WebFault;

@WebFault(name = "AutorizacaoFault")
public class AutorizacaoException extends Exception {

	private final InfoFault infoFault;
	private static final String msgFalha = "Autorizacao falhou";
	private static final long serialVersionUID = 3007501088068341481L;

	public AutorizacaoException(InfoFault infoFault) {
		super(msgFalha);
		this.infoFault = infoFault;
	}

	public InfoFault getFaultInfo() {
		return infoFault;
	}
}
