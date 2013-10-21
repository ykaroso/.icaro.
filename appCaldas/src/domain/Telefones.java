package domain;

public class Telefones {

	private String phones[] = {"tel:92099009","tel:91351988","tel:92505689"};
	private String phonesName[] = {"Marcola","Renan","Ícaro"};
	
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
