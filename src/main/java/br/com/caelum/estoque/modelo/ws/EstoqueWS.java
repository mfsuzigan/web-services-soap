package br.com.caelum.estoque.modelo.ws;

import br.com.caelum.estoque.modelo.fault.AutorizacaoException;
import br.com.caelum.estoque.modelo.fault.InfoFault;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWS {

	private static final TokenDao TOKEN_DAO = new TokenDao();
	private ItemDao dao = new ItemDao();

	@WebMethod(operationName = "TodosOsItens")
	@ResponseWrapper(localName = "itens")
	@WebResult(name = "item")
	public List<Item> getItens(@WebParam(name = "filtros") Filtros filtros) {
		System.out.println("Chamando getItens");
		return dao.todosItens(filtros != null ? filtros.getLista() : null);
	}

	@WebMethod(operationName = "CadastrarItem")
	@WebResult(name = "item")
	public Item saveItem(@WebParam(name = "tokenUsuario", header = true) TokenUsuario tokenUsuario,
			@WebParam(name = "item") Item item) throws AutorizacaoException {
		System.out.println("Validando o token do usuario " + tokenUsuario);
		boolean tokenTemValidade = TOKEN_DAO.ehValido(tokenUsuario);

		if (!tokenTemValidade) {
			throw new AutorizacaoException(new InfoFault("Token invalido"));
		}

		if (item == null) {
			throw new IllegalArgumentException("Item obrigatorio");
		}

		new ItemValidador(item).validate();

		System.out.println("Cadastrando um item");
		return dao.cadastrar(item);
	}

}
