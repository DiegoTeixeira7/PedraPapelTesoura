package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Historico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        getSupportActionBar().hide();

        inicialize();
    }

    private void inicialize() {
        TextView resultadosAntigos = (TextView)findViewById(R.id.resultadosAntigos);

        StringBuilder str = new StringBuilder();

        List<String> lista = MainActivity.getLista();

        for(int i=0; i<lista.size();i++) {
            str.append(lista.get(i)).append("\n");
        }

        resultadosAntigos.setText(str.toString());
    }
}