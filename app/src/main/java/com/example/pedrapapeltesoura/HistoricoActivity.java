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

        TextView Vitorias = findViewById(R.id.vitorias);
        TextView Derrotas = findViewById(R.id.derrotas);
        TextView Empates = findViewById(R.id.empates);

        Vitorias.setText(String.valueOf(MainActivity.vitorias));
        Derrotas.setText(String.valueOf(MainActivity.derrotas));
        Empates.setText(String.valueOf(MainActivity.empates));

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