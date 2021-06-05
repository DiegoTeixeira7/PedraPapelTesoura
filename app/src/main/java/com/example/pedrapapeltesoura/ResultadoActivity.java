package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class ResultadoActivity extends AppCompatActivity {
    private  SharedPreferences.Editor ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        getSupportActionBar().hide();

        ImageView imgSuaEscolha = findViewById(R.id.imgSuaEscolha);
        ImageView imgAppEscolha = findViewById(R.id.imgAppEscolha);

        Intent it = getIntent();
        int escolhaUsuario =  it.getIntExtra(MainActivity.OPCAO, 0);

        if(escolhaUsuario == MainActivity.PEDRA) {
            imgSuaEscolha.setImageResource(R.drawable.pedra);
        } else if(escolhaUsuario == MainActivity.PAPEL) {
            imgSuaEscolha.setImageResource(R.drawable.papel);
        } else {
            imgSuaEscolha.setImageResource(R.drawable.tesoura);
        }

        //  Gerando número aleatório de 0 a 2
        //  0: Pedra
        //  1: Papel
        //  2: Tesoura
        Random random = new Random();
        int escolhaApp = random.nextInt(3);

        if(escolhaApp == MainActivity.PEDRA) {
            imgAppEscolha.setImageResource(R.drawable.pedra);
        } else if(escolhaApp == MainActivity.PAPEL) {
            imgAppEscolha.setImageResource(R.drawable.papel);
        } else {
            imgAppEscolha.setImageResource(R.drawable.tesoura);
        }

        String jogador = escolhaUsuario == MainActivity.PEDRA ? "Pedra"
                : escolhaUsuario == MainActivity.PAPEL ? "Papel" : "Tesoura";

        String app = escolhaApp == MainActivity.PEDRA ? "Pedra"
                : escolhaApp == MainActivity.PAPEL ? "Papel" : "Tesoura";

        String resultado = duelo(jogador, app);
        MainActivity.getListaDeResultados().add(resultado);

        TextView txtResultado = findViewById(R.id.resultado);

        if(resultado.equals("Vitória")) {
            txtResultado.setText("Você ganhou!");
        } else if(resultado.equals("Derrota")) {
            txtResultado.setText("Você perdeu!");
        } else {
            txtResultado.setText("Empatou!");
        }

        ed = getSharedPreferences("pref", MODE_PRIVATE).edit();
    }

    private String duelo(String jogador, String computador) {
        String resultado;

        if(jogador.equals("Pedra") && computador.equals("Tesoura") ||
                jogador.equals("Tesoura") && computador.equals("Papel") ||
                jogador.equals("Papel") && computador.equals("Pedra")) {
            resultado = "Vitória";
            MainActivity.vitorias++;
        } else if(computador.equals("Pedra") && jogador.equals("Tesoura") ||
                computador.equals("Tesoura") && jogador.equals("Papel") ||
                computador.equals("Papel") && jogador.equals("Pedra")) {
            resultado = "Derrota";
            MainActivity.derrotas++;
        } else {
            resultado = "Empate";
            MainActivity.empates++;
        }

        return resultado;
    }

    @Override
    protected void onStop() {
        super.onStop();

        ed.putInt("vitorias", MainActivity.vitorias);
        ed.putInt("empates", MainActivity.empates);
        ed.putInt("derrotas", MainActivity.derrotas);
        ed.apply();

        Toast.makeText(this, "Jogo reiniciado!", Toast.LENGTH_SHORT).show();
    }
}