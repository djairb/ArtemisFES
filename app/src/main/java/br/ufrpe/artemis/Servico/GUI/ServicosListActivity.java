package br.ufrpe.artemis.Servico.GUI;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.artemis.R;
import br.ufrpe.artemis.Servico.Dominio.Servico;
import br.ufrpe.artemis.Servico.Negocio.ServicoNegocio;

public class ServicosListActivity extends AppCompatActivity {
    private ArrayList<Servico> arrayListServico;
    private ArrayList<String> arrayListServicoNome;
    private ListView listViewGeral;
    private int subCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicos_list);

        Bundle extras = getIntent().getExtras();
        subCat = Integer.parseInt(extras.getString("id"));
        setLists();

        listViewGeral = findViewById(R.id.reformaListaId);

        ArrayAdapter<String> teAdaptador = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, arrayListServicoNome
        ){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text color of TextView (ListView Item)
                tv.setTextColor(Color.parseColor("#ED0621"));

                // Generate ListView Item using TextView
                return view;
            }
        };

        listViewGeral.setAdapter(teAdaptador);

        listViewGeral.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //star....
                }
            });





    }
    private void setLists(){
        ServicoNegocio negocio = new ServicoNegocio();
        arrayListServico = negocio.listarSevicosSub(subCat, this);
        arrayListServicoNome = negocio.listarServicoStr(arrayListServico);
    }
}