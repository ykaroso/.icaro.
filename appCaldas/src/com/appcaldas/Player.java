package com.appcaldas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Player extends Activity implements OnClickListener {

	WebView webView;

	String bodyHtml;
	
	String rtmpUrl = "rtmp://www.streambnu.info:1935/goiania3";
	String fileName = "default.stream";
	
	Button refreshButton;
	String htmlPost = "</body></html>";
	String htmlPre = "<!DOCTYPE html>" 
		    + "<html lang=\"en\">"
			+ "<head><meta charset=\"utf-8\">" 
			+ "</head>"
			+ "<body style='margin:0; pading:0;"
			+ " background-color: #71D5CA;'>";

	String htmlCode = "<embed " 
		    + "type=\"application/x-shockwave-flash\""
			+ "id=\"player1\" " + "name=\"player1\" "
			+ "src=\"http://developer.longtailvideo.com"
			+ "/svn/trunk/fl5/player.swf\""
			+ "width=\"320\""
			+ "height=\"280\"" + " flashvars=@FILESRC@"
			+ "allowfullscreen=\"true\"" 
			+ "allowscripaccess=\"always\""
			+ "/>	";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camviewer_layout2);

		webView = (WebView) findViewById(R.id.webview);

		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setAllowFileAccess(true);
		webView.getSettings().setPluginState(PluginState.ON);
		webView.getSettings().setSupportZoom(true);
		webView.getSettings().setAppCacheEnabled(true);

		refreshFileName();
	
	}

	@Override
	public void onClick(View v) {
		refreshFileName();
	}

	private void refreshFileName() {
		String etRtmpUrl = rtmpUrl;
		String etFileName = fileName;
		
		rtmpUrl = etRtmpUrl;
		fileName = etFileName;
		if (fileName.endsWith(".flv")) {
			fileName = "flv:" + fileName;
		}

		bodyHtml = htmlCode;
		bodyHtml = bodyHtml.replaceAll("@FILESRC@", 
				"\"file=" + fileName
				+ "&streamer=" + rtmpUrl + "\"");
		webView.loadDataWithBaseURL("http://127.0.0.1",
				htmlPre + bodyHtml
				+ htmlPost, "text/html", "UTF-8", null);
	}

}