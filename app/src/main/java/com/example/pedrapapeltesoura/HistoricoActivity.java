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

        TextView txtVitorias = findViewById(R.id.txt_vitorias);
        TextView txtDerrotas = findViewById(R.id.txt_derrotas);
        TextView txtEmpates = findViewById(R.id.txt_empates);

        txtVitorias.setText(MainActivity.vitorias+"");
        txtDerrotas.setText(MainActivity.derrotas+"");
        txtEmpates.setText(MainActivity.empates+"");

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