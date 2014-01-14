package domain;

public class DadosCamera {
	private String links[] = {
			"",
			"rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov",
			"rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov",
			"rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov",
			"rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov",
			"rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov",
			"rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov",
			"rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov"};
	
	private String titles[] = {"Camera 0","Camera 1","Camera 2","Camera 3","Camera 4","Camera 5","Camera 6","Camera 7"};
	
	public String getLinkStream(int id){
		return links[id];
	}
	
	public String getTitle(int id){
		return titles[id];
	}


}

