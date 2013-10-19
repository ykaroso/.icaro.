package com.appcaldas;

import domain.VideoLinks;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayVideo extends Activity
{

 private static ProgressDialog progressDialog;
 private VideoLinks Stream = new VideoLinks();
 String videourl;  
 VideoView videoView ;


 protected void onCreate(Bundle savedInstanceState)
 {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.camviewer_layout);

  videoView = (VideoView) findViewById(R.id.videoStream);

  progressDialog = ProgressDialog.show(PlayVideo.this, "", "Carregando...", true);
  progressDialog.setCancelable(true);  

  Play();
 }

 private void Play()
 {
  try
       {      
              getWindow().setFormat(PixelFormat.TRANSLUCENT);
              MediaController mediaController = new MediaController(PlayVideo.this);
              mediaController.setAnchorView(videoView);           

               Uri video = Uri.parse(Stream.getCurrentStream());             
               videoView.setMediaController(mediaController);
               videoView.setVideoURI(video);
               videoView.requestFocus();              
               videoView.setOnPreparedListener(new OnPreparedListener()
               {
                   public void onPrepared(MediaPlayer mp)
                   {                  
                       progressDialog.dismiss();     
                       try{
                    	   videoView.start(); 
                       }catch(Exception e){
                    	   progressDialog.dismiss();
                       }
                       
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