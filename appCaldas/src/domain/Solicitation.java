package domain;

import java.util.Calendar;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.graphics.drawable.BitmapDrawable;

public class Solicitation {
	
	Bitmap foto;
	String localizacao;
	String descricao;
	int tipoRef;
	Calendar data;
	String[] tipo = {
			"Sinal de Tr�nsito",
			"Bucaro na Via",
			"Limpeza Urbana",
			"Ilumin��o P�blica",
			"Tipo de Solicita��o (4)",
			"Tipo de Solicita��o (5)",
			"Tipo de Solicita��o (6)",
			"Tipo de Solicita��o (7)",
			"Tipo de Solicita��o (8)"};
	int[] tempoReparo = {
			3,7,10,5,5};
	
	public Bitmap getFoto() {
		return foto;
	}
	public void setFoto(Bitmap foto) {
		this.foto = foto;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTypeName(int position) {
		return tipo[position];
	}
	public int getTempoReparo(int position) {
		return tempoReparo[position];
	}
	

}
