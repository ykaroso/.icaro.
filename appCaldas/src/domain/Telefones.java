package domain;

public class Telefones {

	private String phones[] = {
	
			"tel:06434543578",
			"tel:06434543536",
			"tel:06434543505",
			"tel:06434543501",
			"tel:06434546814",
			"tel:06434543548",
			"tel:06434543526",
			"tel:06434543531",
			"tel:06434543538",
			"tel:06434543536",
			"tel:06434543578",
			"tel:06434543536",
			"tel:06434543534",
			"tel:06434543507",
			"tel:06434543518",
			"tel:06434543555",
			"tel:06434543519",
			"tel:06434543505",
			"tel:06434543524"};

	private String phonesName[] = {
	
			"Ação Social",
			"Administração",
			"Agricultura e Abastecimento",
			"Ação Urbana",
			"Comunicação e Eventos",
			"Controle Interno",
			"Cultura",
			"Educação",
			"Esportes e Lazer",
			"Finanças",
			"Melhor Idade",
			"Indústria e Comércio",
			"Meio Ambiente e Recursos Hídricos",
			"Obras, Serviços Urbanos e Habitação",
			"Planejamento",
			"Saúde",
			"Superintendência Municipal de Trânsito S.M.T.",
			"Transportes",
			"Turismo"};
	
	
	
	public String getNumber(int id){
		return phones[id];
	}
	public String getPhonesName(int id){
		return phonesName[id];
	}
	public int lenght(){
		return phones.length;
	}
	
}
