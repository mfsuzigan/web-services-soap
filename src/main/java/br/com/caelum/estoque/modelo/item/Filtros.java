package br.com.caelum.estoque.modelo.item;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Filtros {

	@XmlElement(name = "filtro")
	private List<Filtro> listaFiltros;

	public Filtros(List<Filtro> filtros) {
		this.listaFiltros = filtros;
	}

	Filtros() {
	}

	public List<Filtro> getLista() {
		return listaFiltros;
	}

}
