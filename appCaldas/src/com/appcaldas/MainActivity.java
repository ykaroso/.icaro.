package com.appcaldas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (CadastrarUsuario.cadastro == null) {
			Intent it = new Intent(MainActivity.this, CadastrarUsuario.class);
			startActivity(it);
		}
		setContentView(R.layout.main_layout);
		
		Button bEditCad = (Button) findViewById(R.id.bEditCad);

		bEditCad.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent it = new Intent(MainActivity.this,
						CadastrarUsuario.class);
				startActivity(it);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

/*
ViewFlipper vf = (ViewFlipper)findViewById(R.id.vf);
For Button onClickListener:

button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                vf.setDisplayedChild(1);
            }
        });
*/
