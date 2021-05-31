package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        getSupportActionBar().hide();

        Intent it = getIntent();
        TextView jogador = (TextView)findViewById(R.id.jogador);
        jogador.setText("Você jogou: " + it.getStringExtra("jogador"));

        TextView computador = (TextView)findViewById(R.id.computador);
        computador.setText("Computador jogou: " + it.getStringExtra("computador"));

        TextView resultado = (TextView)findViewById(R.id.resultado);
        resultado.setText("Resultado: " + it.getStringExtra("resultado"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Jogo reiniciado!", Toast.LENGTH_SHORT).show();
    }
}