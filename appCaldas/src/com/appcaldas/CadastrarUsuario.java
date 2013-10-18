package com.appcaldas;

import domain.Cadastro;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastrarUsuario extends Activity {

	public static Cadastro cadastro;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.cadastro_layout);

		final EditText nome = (EditText) findViewById(R.id.lNome);
		final EditText ddd = (EditText) findViewById(R.id.lDDD);
		final EditText telefone = (EditText) findViewById(R.id.lTelefone);
		final EditText email = (EditText) findViewById(R.id.lEmail);
		Button salvar = (Button) findViewById(R.id.bCadastrar);
		Button cancelar = (Button) findViewById(R.id.bCancel);

		if (cadastro != null) {

			nome.setText(cadastro.getNome());
			telefone.setText(cadastro.getTelefone());
			email.setText(cadastro.getEmail());

		} else {
			cadastro = new Cadastro();
		}

		salvar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				cadastro.setNome(nome.getText().toString());
				cadastro.setDdd(ddd.getText().toString());
				cadastro.setTelefone(telefone.getText().toString());
				cadastro.setEmail(email.getText().toString());

				Log.i("1", "Nome: " + cadastro.getNome() + "\nTelefone: "
						+ cadastro.getDdd() + cadastro.getTelefone()
						+ "\nEmail: " + cadastro.getEmail());

				finish();
			}
		});

		cancelar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});

	}

}
