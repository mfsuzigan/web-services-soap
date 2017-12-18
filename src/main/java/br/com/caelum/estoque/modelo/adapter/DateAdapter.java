package br.com.caelum.estoque.modelo.adapter;

public class DateAdapter extends XmlAdapter<String, Date> {

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public String marshal(Date date) throws Exception {
		return date != null ? simpleDateFormat.format(date) : null;
	}

	@Override
	public Date unmarshal(String dateString) throws Exception {
		return dateString != null ? simpleDateFormat.parse(dateString) : null;
	}

}
