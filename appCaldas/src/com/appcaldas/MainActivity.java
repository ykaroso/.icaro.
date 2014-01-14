package com.appcaldas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Adapter;
import domain.Solicitation;
import domain.DadosCamera;
import domain.Telefones;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnClickListener{

	private Solicitation solicitation = new Solicitation();
	private DadosCamera dadosCamera = new DadosCamera();
	private Telefones telefone = new Telefones();
	
	//Endereçamento dos containers
	private final static int CONTAINER_MAIN = 0;
	private final static int CONTAINER_PROTOCOLOS = 1;
	private final static int CONTAINER_CAMERAS = 2;
	private final static int CONTAINER_TELEFONE = 3;
	
	//Botões da tela inicial - main_container
	
	private final static int b0 = R.id.bCallSolic0;
	private final static int b1 = R.id.bCallSolic1;
	private final static int b2 = R.id.bCallSolic2;
	private final static int b3 = R.id.bCallSolic3;
	
	
	//Botões da tela das cameras - cams_container
	
	private final static int bCam0 = R.id.bCam0;
	private final static int bCam1 = R.id.bCam1;
	private final static int bCam2 = R.id.bCam2;
	private final static int bCam3 = R.id.bCam3;
	private final static int bCam4 = R.id.bCam4;
	private final static int bCam5 = R.id.bCam5;
	private final static int bCam6 = R.id.bCam6;
	private final static int bCam7 = R.id.bCam7;
	

	
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
		
		// -----------------BOTÕES GLOBAIS---------------------//
		//-----------------------------------------------------//
		// --------------- Botões do rodapé ------------------ //

		bSolic = (Button) findViewById(R.id.bSolic);
		bProt= (Button) findViewById(R.id.bProt);
		bCam = (Button) findViewById(R.id.bCam);
		bTel = (Button) findViewById(R.id.bTel);
		
		carregaBotoesEspeciicos(container.getDisplayedChild());

		bSolic.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				container.setDisplayedChild(CONTAINER_MAIN);
				carregaBotoesEspeciicos(container.getDisplayedChild());
				unblockAllButtons();
				bSolic.setClickable(false);
			}
		});
		
		bProt.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				container.setDisplayedChild(CONTAINER_PROTOCOLOS);
				carregaBotoesEspeciicos(container.getDisplayedChild());
				unblockAllButtons();
				bProt.setClickable(false);
			}
		});
		
		bCam.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				container.setDisplayedChild(CONTAINER_CAMERAS);
				carregaBotoesEspeciicos(container.getDisplayedChild());
				unblockAllButtons();
				bCam.setClickable(false);
			}
		});
		
		bTel.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				container.setDisplayedChild(CONTAINER_TELEFONE);
				carregaBotoesEspeciicos(container.getDisplayedChild());
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
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
				startActivity(browserIntent);
			}
		});
		
		// ----------------- FIM BOTÕES GLOBAIS-------------------//
		
	}
	
	//BOTOES ESPECIFICOS, CARREGADOS DE ACORDO COM A CHAMADA
	private void carregaBotoesEspeciicos(int telaAtual){
		switch(telaAtual){
			case CONTAINER_MAIN:
				Button buttonsSolicita[] = {
						(Button)findViewById(b0),
						(Button)findViewById(b1),
						(Button)findViewById(b2),
						(Button)findViewById(b3),};
				
				for(int i  = 0; i < buttonsSolicita.length; i++)
					buttonsSolicita[i].setOnClickListener(this);
			break;
			case CONTAINER_PROTOCOLOS:
				ExpandableListView listView = (ExpandableListView) findViewById(R.id.expandableListView1);
				listView.setAdapter(new Adapter(this));
				
			break;
			case CONTAINER_CAMERAS:
				ImageButton buttonsCam[] = {(ImageButton)findViewById(bCam0),(ImageButton)findViewById(bCam1),
						(ImageButton)findViewById(bCam2),(ImageButton)findViewById(bCam3),(ImageButton)findViewById(bCam4),
						(ImageButton)findViewById(bCam5),(ImageButton)findViewById(bCam6),(ImageButton)findViewById(bCam7)};
				for(int i  = 0; i < buttonsCam.length; i++)
					buttonsCam[i].setOnClickListener(this);
			break;
			case CONTAINER_TELEFONE:
			    ListView lv;
			    List<String> lista = new ArrayList<String>();
			    lv = (ListView)findViewById(R.id.lvTelefones);
			    
			    for(int i = 0 ; i < telefone.lenght() ; i++){
			    	lista.add(telefone.getPhonesName(i));
			    }
			    
			    lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lista));
			    lv.setOnItemClickListener(new OnItemClickListener(){
					public void onItemClick(AdapterView<?> arg0,View arg1, int numeroSelecionado, long arg3) {
						Intent it = new Intent(Intent.ACTION_CALL);
						it.setData(Uri.parse(telefone.getNumber(numeroSelecionado)));
						startActivity(it);								
					}
			     });
			break;			
		}
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
	
	@Override
	public void onClick(View v) {
		Intent it = null;
		switch (v.getId()){ 
	    	//Bloco das funções dos botôes da main_container
			case b0:
	    		it = new Intent(this, RegisterSolicitation.class);
	    		it.putExtra("paramTitle",solicitation.getTypeName(0));break;
	    	case b1:
	    		it = new Intent(this, RegisterSolicitation.class);
	    		it.putExtra("paramTitle",solicitation.getTypeName(1));break;
	    	case b2:
	    		it = new Intent(this, RegisterSolicitation.class);
	    		it.putExtra("paramTitle",solicitation.getTypeName(2));break;
	    	case b3:
	    		it = new Intent(this, RegisterSolicitation.class);
	    		it.putExtra("paramTitle",solicitation.getTypeName(3));break;
	    	//FIM main_container
	    	
	    	
	        //Bloco das funções dos botôes da cams_container
	    	case bCam0:
	    		it = new Intent(this, Player.class);
	    		//it.putExtra("paramTitle",dadosCamera.getTitle(0));
	    		//it.putExtra("paramLink",dadosCamera.getLinkStream(0));
	    		break;
	    	case bCam1:
	    		it = new Intent(this, Camera.class);
	    		it.putExtra("paramTitle",dadosCamera.getTitle(1));
	    		it.putExtra("paramLink",dadosCamera.getLinkStream(1));
	    		break;
	    	case bCam2:
	    		it = new Intent(this, Camera.class);
	    		it.putExtra("paramTitle",dadosCamera.getTitle(2));
	    		it.putExtra("paramLink",dadosCamera.getLinkStream(2));
	    		break;
	    	case bCam3:
	    		it = new Intent(this, Camera.class);
	    		it.putExtra("paramTitle",dadosCamera.getTitle(3));
	    		it.putExtra("paramLink",dadosCamera.getLinkStream(3));
	    		break;	
	    	case bCam4:
	    		it = new Intent(this, Camera.class);
	    		it.putExtra("paramTitle",dadosCamera.getTitle(4));
	    		it.putExtra("paramLink",dadosCamera.getLinkStream(4));
	    		break;	
	    	case bCam5:
	    		it = new Intent(this, Camera.class);
	    		it.putExtra("paramTitle",dadosCamera.getTitle(5));
	    		it.putExtra("paramLink",dadosCamera.getLinkStream(5));
	    		break;	
	    	case bCam6:
	    		it = new Intent(this, Camera.class);
	    		it.putExtra("paramTitle",dadosCamera.getTitle(6));
	    		it.putExtra("paramLink",dadosCamera.getLinkStream(6));
	    		break;	
	    	case bCam7:
	    		it = new Intent(this, Camera.class);
	    		it.putExtra("paramTitle",dadosCamera.getTitle(7));
	    		it.putExtra("paramLink",dadosCamera.getLinkStream(7));
	    		break;
	    	//FIM cams_container	
	    		
	
	    }
		startActivity(it);
	}
}

