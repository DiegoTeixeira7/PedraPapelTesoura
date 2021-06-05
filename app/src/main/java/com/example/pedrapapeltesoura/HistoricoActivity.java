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

        TextView vitorias = findViewById(R.id.vitorias);
        TextView derrotas = findViewById(R.id.derrotas);
        TextView empates = findViewById(R.id.empates);

        vitorias.setText(String.valueOf(MainActivity.vitorias));
        derrotas.setText(String.valueOf(MainActivity.derrotas));
        empates.setText(String.valueOf(MainActivity.empates));

        ListView lista = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
          getApplicationContext(),
          android.R.layout.simple_list_item_1,
          android.R.id.text1,
          MainActivity.getListaDeResultados().toArray(new String[0])
        );

        lista.setAdapter(adapter);
    }
}