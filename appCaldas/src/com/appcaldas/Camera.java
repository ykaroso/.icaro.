package com.appcaldas;

import domain.DadosCamera;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Camera extends Activity
{

 private static ProgressDialog progressDialog; 
 String videourl;  
 VideoView videoView ;


 protected void onCreate(Bundle savedInstanceState)
 {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.camviewer_layout);
  
  Intent it = getIntent();
	
  TextView titulo = (TextView) findViewById(R.id.tituloCamera);
	
  titulo.setText(it.getStringExtra("paramTitle"));
  videourl = it.getStringExtra("paramLink");

  videoView = (VideoView) findViewById(R.id.videoStream);

  progressDialog = ProgressDialog.show(Camera.this, "", "Carregando...", true);
  progressDialog.setCancelable(true);  

  Play();
 }

 private void Play()
 {
  try
       {      
              getWindow().setFormat(PixelFormat.TRANSLUCENT);
              MediaController mediaController = new MediaController(Camera.this);
              mediaController.setAnchorView(videoView);           

               Uri video = Uri.parse(videourl);             
               videoView.setVideoURI(video);
               videoView.requestFocus();              
               videoView.setOnPreparedListener(new OnPreparedListener()
               {
                   public void onPrepared(MediaPlayer mp)
                   {                  
                       progressDialog.dismiss();     
                       videoView.start();                     
                   }
               });           
            }
       catch(Exception e)
       {
                progressDialog.dismiss();
                System.err.println("Video Play Error :"+e.toString());
                finish();
       }   

 }
}