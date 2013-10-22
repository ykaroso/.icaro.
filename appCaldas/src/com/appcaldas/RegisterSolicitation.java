package com.appcaldas;

import domain.Solicitation;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterSolicitation extends Activity{
	
	public static Solicitation solicitacao;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.solicitations_layout);
		
		solicitacao = new Solicitation();
		
		Intent it = getIntent();
		
		TextView tipoDeSolicitacao = (TextView) findViewById(R.id.lTipoSolic);
		tipoDeSolicitacao.setText(it.getStringExtra("paramTitle"));
		
		final ImageButton camera = (ImageButton) findViewById(R.id.bCamera);
		final EditText localizacao = (EditText) findViewById(R.id.tLocalizacao);
		final EditText descricao = (EditText) findViewById(R.id.tDescricao);
		Button localizar = (Button) findViewById(R.id.bLocalizar);
		Button enviar = (Button) findViewById(R.id.bEnviar);
		
		camera.setImageBitmap(null);
		
		camera.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
				startActivityForResult(i,0);
			}
		});
		
		enviar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				solicitacao.setLocalizacao(localizacao.getText().toString());
				solicitacao.setDescricao(descricao.getText().toString());
				solicitacao.setFoto(((BitmapDrawable)camera.getDrawable()).getBitmap());
				
				Log.i("1", "Localização: " + solicitacao.getLocalizacao() + "\nDescrição: "
						+ solicitacao.getDescricao());
				
				/*
				try {
					Mail email = new Mail("", "");
					email.setBody("Teste");
					email.send();
				} catch (Exception e) {
					e.printStackTrace();
				}
				*/

				finish();
			}
		});
		
		localizar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				
			}
		});
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		if(data != null) {
			Bundle bundle = data.getExtras();
			if(bundle != null){
				//Recupera o bitmap retornado pela camera
				Bitmap bitmap = (Bitmap) bundle.get("data");
				//Atualiza a imagem na tela
				ImageButton bCamera = (ImageButton) findViewById(R.id.bCamera);
				bCamera.setBackgroundResource(0);
				bCamera.setImageBitmap(bitmap);
			}
		}
	}

}
