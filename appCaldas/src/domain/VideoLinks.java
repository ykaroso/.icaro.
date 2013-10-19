package domain;

public class VideoLinks {
	private String links[] = {"","","",""};
	private int currentStream = 0;
	
	public void setCurrentIdStream(int id){
		currentStream = id;
	}
	
	public String getCurrentStream(){
		return links[currentStream];
	}

}

