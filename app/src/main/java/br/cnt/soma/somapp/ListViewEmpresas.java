package br.cnt.soma.somapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewEmpresas extends AppCompatActivity {

    private String[] listaEmpresas;
    private ListView lstView;
    private EditText edtText;
    private ArrayList<String> pesquisa = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_empresas);

        lstView = (ListView) findViewById(R.id.lView);
        edtText = (EditText) findViewById(R.id.txt_pesquisaEmpresa);

        listaEmpresas = new String[] {
                "Alimenticia Minas Grill Gourmet BH Shopping",
                "Alimenticia Minas Grill Gourmet Patio",
                "Art Man",
                "Assessoria Contabil Soma Ltda",
                "Bafile Empreendimentos Imobiliarios",
                "CGL Comercio de Alimentos",
                "Comercial Alimenticia Boi Del Rey",
                "Cristiana Alagia Representacoes",
                "Crossfit BH",
                "Crossfit BH Academia Bandeirantes",
                "Crossfit BH Academia Prado",
                "Crossfit BH Academia Zona Sul",
                "Deposito de Materias Boa Esperanca",
                "Fabiana de Freitas Kummel",
                "Fusao Representacoes",
                "Hosch do Brasil",
                "Kerr Comercial de Servicos",
                "LJDE Sociedade Alimenticia",
                "Master Cillas Cervejaria Industria e Comercio",
                "Matahari Comercio",
                "Meira Movimento do Corpo",
                "MGE Representacoes",
                "Mineraco Lavras dos Verdes",
                "Multipress Servi‡os de Comunicacao",
                "Neo Design Arquitetura e Paisagismo",
                "Paulino Vieira Comercio",
                "Pisca Veiculos",
                "Prosper Fomento Comercial",
                "RED Graniti",
                "Romec Equipamentos para Mineracao",
                "Santarem Administracao de Terminais Rodoviarios",
                "Sociedade Meira e Mendes",
                "Top Bar",
                "Velloce Comercio de Materiais Esportivos",
                "Viacao Transmoreira"

        };

        lstView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaEmpresas));

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position==3){
                    Intent intent = new Intent(view.getContext(), DadosSoma.class);
                    startActivityForResult(intent, 3);
                }
                else if(position==19){
                    Intent intent = new Intent(view.getContext(), DadosMatahari.class);
                    startActivityForResult(intent, 19);
                }

            }
        });

        pesquisar();

        edtText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int arg1, int arg2, int arg3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int arg1, int arg2, int arg3) {

                pesquisar();
                lstView.setAdapter(new ArrayAdapter<String>(ListViewEmpresas.this, android.R.layout.simple_list_item_1, pesquisa ));


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void pesquisar() {
        int textlenght = edtText.getText().length();
        pesquisa.clear();

        for (int i = 0; i < listaEmpresas.length; i++){
            if (edtText.getText().toString().equalsIgnoreCase((String)listaEmpresas[i].subSequence(0, textlenght))){
                pesquisa.add(listaEmpresas[i]);
            }

        }
    }
}
