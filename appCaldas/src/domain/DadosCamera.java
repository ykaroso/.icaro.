package domain;

public class DadosCamera {
	private String links[] = {"","","","","","","",""};
	private String titles[] = {"Cam0","Cam1","Cam2","Cam3","Cam4","Cam5","Cam6","Cam7"};
	
	public String getLinkStream(int id){
		return links[id];
	}
	
	public String getTitle(int id){
		return titles[id];
	}


}

