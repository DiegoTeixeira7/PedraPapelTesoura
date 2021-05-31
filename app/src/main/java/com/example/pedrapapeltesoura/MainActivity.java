package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static List<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        lista = new ArrayList<>();
    }

    public void jogar(View view) {
        String tag = view.getTag().toString();
        String jogador = null;

        if (tag.equals("pedra")) {
            jogador = "Pedra";
        } else if(tag.equals("papel")) {
            jogador = "Papel";
        } else {
            jogador = "Tesoura";
        }

        //  Gerando número aleatório de 0 a 2
        //  0: Pedra
        //  1: Papel
        //  2: Tesoura
        Random random = new Random();
        int range = random.nextInt(3);

        List<String> jogadaComputador = new ArrayList<>();
        jogadaComputador.add("Pedra");
        jogadaComputador.add("Papel");
        jogadaComputador.add("Tesoura");

        String computador = jogadaComputador.get(range);

        String resultado = duelo(jogador, computador);
        lista.add(resultado);

        Intent it = new Intent(getBaseContext(), Resultado.class);
        it.putExtra("jogador", jogador);
        it.putExtra("computador", computador);
        it.putExtra("resultado", resultado);
        startActivity(it);
    }

    public void verHistorico(View view) {
        if(lista.isEmpty()) {
            Toast.makeText(this, "Não há jogos registrados!", Toast.LENGTH_SHORT).show();
        } else {
            Intent it = new Intent(getBaseContext(), Historico.class);
            startActivity(it);
        }
    }

    public static List<String> getLista() {
        return lista;
    }

    private String duelo(String jogador, String computador) {
        String resultado = "Empate";

        if(jogador.equals("Pedra") && computador.equals("Tesoura") ||
                jogador.equals("Tesoura") && computador.equals("Papel") ||
                jogador.equals("Papel") && computador.equals("Pedra")) {
            resultado = "Vitória";
        } else if(computador.equals("Pedra") && jogador.equals("Tesoura") ||
                computador.equals("Tesoura") && jogador.equals("Papel") ||
                computador.equals("Papel") && jogador.equals("Pedra")) {
            resultado = "Derrota";
        }

        return resultado;
    }
}