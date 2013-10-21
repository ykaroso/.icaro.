package com.appcaldas;

import domain.Cadastro;
import exception.Validation;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
		Button cancelar = (Button) findViewById(R.id.bCallSolic5);

		if (cadastro != null) {

			nome.setText(cadastro.getNome());
			telefone.setText(cadastro.getTelefone());
			email.setText(cadastro.getEmail());

		} else {
			cadastro = new Cadastro();
		}

		salvar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Log.i("0", "Validar: "
						+ validarEmail(email.getText().toString())
						+ validarTelefone(telefone.getText().toString())+"Nome: "+nome.getText().toString());
				try {
					if (nome.getText().toString().replace(" ", "") == "" || nome.getText().toString()== "") {
						throw new Validation("Preencha o campo nome!");
					}
					if (validarTelefone(telefone.getText().toString())==false) {
						throw new Validation("Telefone informado não é válido!");
					}
					if (validarEmail(email.getText().toString())==false) {
						throw new Validation("Email informado não é válido!");
					}
					Log.i("0", "Validar: "
							+ validarEmail(email.getText().toString())
							+ validarTelefone(telefone.getText().toString())+"Nome: "+nome.getText().toString());

					cadastro.setNome(nome.getText().toString());
					cadastro.setDdd(ddd.getText().toString());
					cadastro.setTelefone(telefone.getText().toString());
					cadastro.setEmail(email.getText().toString());

					Log.i("1", "Nome: " + cadastro.getNome() + "\nTelefone: "
							+ cadastro.getDdd() + cadastro.getTelefone()
							+ "\nEmail: " + cadastro.getEmail());

					finish();

				} catch (Validation e) {
					Toast toast = Toast.makeText(CadastrarUsuario.this,
							e.getMessage(), Toast.LENGTH_SHORT);
					toast.show();
				}
			}
		});

		cancelar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});

	}

	boolean validarEmail(CharSequence email) {
		return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
	}

	boolean validarTelefone(CharSequence telefone) {
		return android.util.Patterns.PHONE.matcher(telefone).matches();
	}

}
