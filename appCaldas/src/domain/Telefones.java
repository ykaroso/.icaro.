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
	
			"A��o Social",
			"Administra��o",
			"Agricultura e Abastecimento",
			"A��o Urbana",
			"Comunica��o e Eventos",
			"Controle Interno",
			"Cultura",
			"Educa��o",
			"Esportes e Lazer",
			"Finan�as",
			"Melhor Idade",
			"Ind�stria e Com�rcio",
			"Meio Ambiente e Recursos H�dricos",
			"Obras, Servi�os Urbanos e Habita��o",
			"Planejamento",
			"Sa�de",
			"Superintend�ncia Municipal de Tr�nsito S.M.T.",
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
