package com.example.pedrapapeltesoura;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HistoricoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        getSupportActionBar().hide();

        TextView Vitorias = findViewById(R.id.txt_vitorias);
        TextView Derrotas = findViewById(R.id.txt_derrotas);
        TextView Empates = findViewById(R.id.txt_empates);

        Integer v = MainActivity.vitorias;
        Integer d = MainActivity.derrotas;
        Integer e = MainActivity.empates;

        Vitorias.setText(v.toString());
        Derrotas.setText(d.toString());
        Empates.setText(e.toString());

        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
          this,
          android.R.layout.simple_list_item_1,
          android.R.id.text1,
          MainActivity.getListaDeResultados().toArray(new String[0])
        );

        listView.setAdapter(adapter);
    }
}