package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        getSupportActionBar().hide();

        ImageView imgJogador = findViewById(R.id.imgJogador);
        ImageView imgApp = findViewById(R.id.imgApp);

        Bundle bundle = getIntent().getExtras();
        String jogador = bundle.getString("jogadaUsuario");
        String app = bundle.getString("jogadaApp");
        String resultado = bundle.getString("jogo");


        if(jogador.equals("pedra")) {
            imgJogador.setImageResource(R.drawable.pedra);
        } else if(jogador.equals("papel")) {
            imgJogador.setImageResource(R.drawable.papel);
        } else {
            imgJogador.setImageResource(R.drawable.tesoura);
        }

        if(app.equals("pedra")) {
            imgApp.setImageResource(R.drawable.pedra);
        } else if(app.equals("papel")) {
            imgApp.setImageResource(R.drawable.papel);
        } else {
            imgApp.setImageResource(R.drawable.tesoura);
        }

        TextView Resultado = findViewById(R.id.resultado);

        if(resultado.equals("Vitória")) {
            Resultado.setText("Você ganhou!");
        } else if(resultado.equals("Derrota")) {
            Resultado.setText("Você perdeu!");
        } else {
            Resultado.setText("Empatou!");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Jogo reiniciado!", Toast.LENGTH_SHORT).show();
    }
}