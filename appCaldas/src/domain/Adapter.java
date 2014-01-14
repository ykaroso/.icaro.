package domain;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
 
public class Adapter extends BaseExpandableListAdapter {
 
Context context;
 
// Definindo o conteúdo de nossa lista e sublista
 
String[] listaPai = { 
		"N° 15845 - Solicitação realizada em 15/10/2013", 
		"N° 15845 - Solicitação realizada em 17/11/2013", 
		"N° 15845 - Solicitação realizada em 04/12/2013", 
		"N° 15845 - Solicitação realizada em 06/01/2013", 
		"N° 15845 - Solicitação realizada em 08/01/2014", 
		"N° 15845 - Solicitação realizada em 09/01/2014", 
		"N° 15845 - Solicitação realizada em 10/01/2014", 
		"N° 15845 - Solicitação realizada em 11/01/2014", 
		"N° 15845 - Solicitação realizada em 12/01/2014" };
String[][] listafilho = 
{ 

		
{ "Subcategoria", "Subcategoria" },

{ "Subcategoria" },
{ "Subcategoria" }, 
{ "Subcategoria" }, 
{ "Subcategoria" }, 
{ "Subcategoria" }, 
{ "Subcategoria" }, 
{ "Subcategoria" }, 
{ "Subcategoria" }};
 
public Adapter(Context context) {
this.context = context;
}
 
@Override
public Object getChild(int groupPosition, int childPosition) {
// TODO Auto-generated method stub
return listafilho[groupPosition][childPosition];
}
 
@Override
public long getChildId(int groupPosition, int childPosition) {
// TODO Auto-generated method stub
return childPosition;
}
 
@Override
public View getChildView(int groupPosition, int childPosition,
boolean isLastChild, View convertView, ViewGroup parent) {
 
// Criamos um TextView que conterá as informações da listafilho que
// criamos
TextView textViewSubLista = new TextView(context);
textViewSubLista.setText(listafilho[groupPosition][childPosition]);
textViewSubLista.setTextColor(Color.WHITE);



// Definimos um alinhamento
textViewSubLista.setPadding(10, 5, 0, 5);
 
return textViewSubLista;
}
 
@Override
public int getChildrenCount(int groupPosition) {
// TODO Auto-generated method stub
return listafilho[groupPosition].length;
}
 
@Override
public Object getGroup(int groupPosition) {
// TODO Auto-generated method stub
return listaPai[groupPosition];
}
 
@Override
public int getGroupCount() {
// TODO Auto-generated method stub
return listaPai.length;
}
 
@Override
public long getGroupId(int groupPosition) {
// TODO Auto-generated method stub
return groupPosition;
}
 
@Override
public View getGroupView(int groupPosition, boolean isExpanded,
View convertView, ViewGroup parent) {
 
// Criamos um TextView que conterá as informações da listaPai que
// criamos
TextView textViewCategorias = new TextView(context);
textViewCategorias.setText(listaPai[groupPosition]);
textViewCategorias.setTextColor(Color.WHITE);

textViewCategorias.setBackgroundColor(Color.GRAY);

// Definimos um alinhamento
textViewCategorias.setPadding(30, 5, 0, 5);
// Definimos o tamanho do texto
textViewCategorias.setTextSize(20);
// Definimos que o texto estará em negrito
textViewCategorias.setTypeface(null, Typeface.BOLD);
 
return textViewCategorias;
}
 
@Override
public boolean hasStableIds() {
// TODO Auto-generated method stub
return false;
}
 
@Override
public boolean isChildSelectable(int groupPosition, int childPosition) {
// Defina o return como sendo true se vc desejar que sua sublista seja selecionável
return false;
}
 
}