package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static int vitorias ;
    public static int derrotas;
    public static int empates ;

    private static List<String> lista;

    private String jogadaUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        lista = new ArrayList<>();

        SharedPreferences preferences = getSharedPreferences("pref", MODE_PRIVATE);

        vitorias = preferences.getInt("vitorias", 0);
        empates = preferences.getInt("empates", 0);
        derrotas = preferences.getInt("derrotas", 0);
    }

    public static List<String> getListaDeResultados() {
        return lista;
    }

    public void btnPedra(View view) {
        jogadaUsuario = "pedra";
        jokenpo();
    }

    public void btnPapel(View view) {
        jogadaUsuario = "papel";
        jokenpo();
    }

    public void btnTesoura(View view) {
        jogadaUsuario = "tesoura";
        jokenpo();
    }

    public void historico(View view) {
        if(!lista.isEmpty()) {
            Intent it = new Intent(this, HistoricoActivity.class);
            startActivity(it);
        } else {
            Toast.makeText(this, "Não há jogos registrados!", Toast.LENGTH_SHORT).show();
        }
    }

    private void jokenpo() {
        String jogadaApp = jogadaAPP();

        String jogo;

        if(jogadaUsuario.equals("pedra") && jogadaApp.equals("pedra")) {
            jogo = "Empate";
            empates++;
        } else if(jogadaUsuario.equals("papel") && jogadaApp.equals("papel")) {
            jogo = "Empate";
            empates++;
        } else if(jogadaUsuario.equals("tesoura") && jogadaApp.equals("tesoura")) {
            jogo = "Empate";
            empates++;
        } else if(jogadaUsuario.equals("pedra") && jogadaApp.equals("tesoura")) {
            jogo = "Vitória";
            vitorias++;
        } else if(jogadaUsuario.equals("tesoura") && jogadaApp.equals("papel")) {
            jogo = "Vitória";
            vitorias++;
        } else if(jogadaUsuario.equals("papel") && jogadaApp.equals("pedra")) {
            jogo = "Vitória";
            vitorias++;
        } else {
            jogo = "Derrota";
            derrotas++;
        }

        lista.add(jogo);

        Intent it = new Intent(this, ResultadoActivity.class);
        it.putExtra("jogadaApp", jogadaApp);
        it.putExtra("jogadaUsuario", jogadaUsuario);
        it.putExtra("jogo", jogo);
        startActivity(it);
    }

    private String jogadaAPP() {
        SecureRandom random = new SecureRandom();
        int opcaoApp = (random.nextInt() & Integer.MAX_VALUE) % 3;

        if(opcaoApp == 0) {
            return "pedra";
        } else if(opcaoApp == 1) {
            return "papel";
        } else {
            return "tesoura";
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editorDePreferencias = getSharedPreferences("pref", MODE_PRIVATE).edit();
        editorDePreferencias.putInt("vitorias", MainActivity.vitorias);
        editorDePreferencias.putInt("empates", MainActivity.empates);
        editorDePreferencias.putInt("derrotas", MainActivity.derrotas);
        editorDePreferencias.apply();
    }
}