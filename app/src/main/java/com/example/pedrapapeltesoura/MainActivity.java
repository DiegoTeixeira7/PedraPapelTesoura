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

    public static List<String> getLista() {
        return lista;
    }

    public void jokenpo(View view) {
        String tag = view.getTag().toString();
        String jogadaUsuario;

        if (tag.equals("pedra")) {
            jogadaUsuario = "pedra";
        } else if(tag.equals("papel")) {
            jogadaUsuario = "papel";
        } else {
            jogadaUsuario = "tesoura";
        }

        String jogadaApp = jogadaAPP();

        String jogo;

        if(jogadaUsuario.equals("pedra") && jogadaApp.equals("pedra")) {
            jogo = "Empate";
        } else if(jogadaUsuario.equals("papel") && jogadaApp.equals("papel")) {
            jogo = "Empate";
        } else if(jogadaUsuario.equals("tesoura") && jogadaApp.equals("tesoura")) {
            jogo = "Empate";
        } else if(jogadaUsuario.equals("pedra") && jogadaApp.equals("tesoura")) {
            jogo = "Vitória";
        } else if(jogadaUsuario.equals("tesoura") && jogadaApp.equals("papel")) {
            jogo = "Vitória";
        } else if(jogadaUsuario.equals("papel") && jogadaApp.equals("pedra")) {
            jogo = "Vitória";
        } else {
            jogo = "Derrota";
        }

        lista.add(jogo);

        Intent it = new Intent(this, Resultado.class);
        it.putExtra("jogadaApp", jogadaApp);
        it.putExtra("jogadaUsuario", jogadaUsuario);
        it.putExtra("jogo", jogo);
        startActivity(it);
    }

    public void historico(View view) {
        if(!lista.isEmpty()) {
            Intent it = new Intent(this, Historico.class);
            startActivity(it);
        } else {
            Toast.makeText(this, "Não há jogos registrados!", Toast.LENGTH_SHORT).show();
        }
    }

    private String jogadaAPP() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(3);

        if(numeroAleatorio == 0) {
            return "pedra";
        } else if(numeroAleatorio == 1) {
            return "papel";
        } else {
            return "tesoura";
        }
    }
}