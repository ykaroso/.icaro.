package domain;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.graphics.drawable.BitmapDrawable;

public class Solicitation {
	
	Bitmap foto;
	String localizacao;
	String descricao;
	//Criar <Tipo> coordenada;
	
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

}
