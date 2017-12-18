package br.com.caelum.estoque.modelo.item;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaItens {

	@XmlElement(name = "item")
	private List<Item> itens;

	public ListaItens(List<Item> itens) {
		this.itens = itens;
	}

	ListaItens() {
	}

	public List<Item> getItens() {
		return itens;
	}

}
