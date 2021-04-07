package com.vico.qi_apps1_aula22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    // 1a Etapa: declarar as variáveis e a construção do nosso Array
    private ListView lista;
    private String[] itens = {"HTML5", "CSS", "SASS", "JavaScript", "Node.JS", "AngularJS", "Ruby", "React", "jQuery"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2a etapa: mapeamento
        lista = findViewById(R.id.lista);

        //3a etapa: criar um adaptador para servir de ligação entre o array e o elemento ListView no XML. O adaptador vem do atributo ArrayAdapter
        // android.R.layout.simple_list_item_1: mapeamento define o tipo da lista, ou seja, uma lista simples - item 1;
        // android.R.layout.simple_list_item_1, android.R.id.text1, itens: mapeamento que define os tipos de valores da lista.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, itens);

        //4a etapa: adicionar o adapter para a lista criada no array
        lista.setAdapter(adapter);

        //5a etapa: print na tela em toast indicando qual o item que foi clicado
        // eventos: setOnItemClickListener e OnItemClick
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, itens[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}