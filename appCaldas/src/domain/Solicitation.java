package domain;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.graphics.drawable.BitmapDrawable;

public class Solicitation {
	
	Bitmap foto;
	String localizacao;
	String descricao;
	int tipoRef;
	String[] tipo = {
			"Sinal de Trânsito",
			"Bucaro na Via",
			"Limpeza Urbana",
			"Iluminção Pública",
			"Tipo de Solicitação (4)",
			"Tipo de Solicitação (5)",
			"Tipo de Solicitação (6)",
			"Tipo de Solicitação (7)",
			"Tipo de Solicitação (8)"};
	
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


}
