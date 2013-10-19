package com.appcaldas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

	private final static int CONTAINER_MAIN = 0;
	private final static int CONTAINER_PROTOCOLOS = 1;
	private final static int CONTAINER_CAMERAS = 2;
	private final static int CONTAINER_TELEFONE = 3;
	
	Button bSolic;
	Button bProt;
	Button bCam;
	Button bTel;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		if (CadastrarUsuario.cadastro == null) {
			Intent it = new Intent(MainActivity.this, CadastrarUsuario.class);
			startActivity(it);
		}
		
		final ViewFlipper container = (ViewFlipper) findViewById(R.id.container);	
		
		// --------------- Botões do rodapé ------------------ //

		bSolic = (Button) findViewById(R.id.bSolic);
		bProt= (Button) findViewById(R.id.bProt);
		bCam = (Button) findViewById(R.id.bCam);
		bTel = (Button) findViewById(R.id.bTel);

		bSolic.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				container.setDisplayedChild(CONTAINER_MAIN);
				unblockAllButtons();
				bSolic.setClickable(false);
			}
		});
		
		bProt.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				container.setDisplayedChild(CONTAINER_PROTOCOLOS);
				unblockAllButtons();
				bProt.setClickable(false);
			}
		});
		
		bCam.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				container.setDisplayedChild(CONTAINER_CAMERAS);
				unblockAllButtons();
				bCam.setClickable(false);
			}
		});
		
		bTel.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				container.setDisplayedChild(CONTAINER_TELEFONE);
				unblockAllButtons();
				bTel.setClickable(false);
			}
		});
		
		

		// ----------------- Botões do Topo ------------------ //

		Button bEditCad = (Button) findViewById(R.id.bEditCad);
		Button bSite = (Button) findViewById(R.id.bGoToSite);
	
		bEditCad.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent it = new Intent(MainActivity.this,CadastrarUsuario.class);
				startActivity(it);
			}
		});
		
		bSite.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				//Abrir navegador aqui com o link que iremos receber.
			}
		});
		
		
		
		// --------------- Botões do Centrais ---------------- //
		
		Button bSolicita = (Button) findViewById(R.id.bCallSolicForTest);
		
		bSolicita.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				setContentView(R.layout.solicitations_layout); //Teste para visualizar a tela
				
				//Intent it = new Intent(MainActivity.this,"CRIAR CLASSE <Solicitacao>".class);
				//startActivity(it);
			}
		});
		

		
	}
	
	private void unblockAllButtons(){
		bSolic.setClickable(true);
		bProt.setClickable(true);
		bCam.setClickable(true);
		bTel.setClickable(true);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

