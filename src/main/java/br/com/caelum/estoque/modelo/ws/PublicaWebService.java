package br.com.caelum.estoque.modelo.ws;

import br.com.caelum.estoque.modelo.item.Item;

public class PublicaWebService {

	public static void main(String[] args) {
		String estoqueWsUrl = "http://localhost:8080/estoquews";
		System.out.println("EstoqueWS rodando em " + estoqueWsUrl);
		Endpoint.publish(estoqueWsUrl, new EstoqueWS());
	}

	public static void testeMarshal() throws JAXBException {
		Item item = new Item.Builder().comCodigo("MEA").comNome("MEAN").comQuantidade(4).comTipo("Livro").build();

		JAXBContext context = JAXBContext.newInstance(Item.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(item, System.out); // ou
												// marshaller.marshal(item,
												// System.out);

	}

}
