package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int PEDRA = 0;
    public static final int PAPEL = 1;
    public static final int TESOURA = 2;
    public static final String OPCAO = "opcao";

    public static int vitorias ;
    public static int derrotas;
    public static int empates ;

    private static List<String> lista;

    private Intent intent;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        intent = new Intent(getBaseContext(), ResultadoActivity.class);
        lista = new ArrayList<>();

        preferences = getSharedPreferences("pref", MODE_PRIVATE);

        vitorias = preferences.getInt("vitorias", 0);
        empates = preferences.getInt("empates", 0);
        derrotas = preferences.getInt("derrotas", 0);
    }

    public static List<String> getListaDeResultados() {
        return lista;
    }

    public void jogar(View view) {
        String tag = view.getTag().toString();

        if (tag.equals("pedra")) {
            intent.putExtra(OPCAO, PEDRA);
        } else if(tag.equals("papel")) {
            intent.putExtra(OPCAO, PAPEL);
        } else {
            intent.putExtra(OPCAO, TESOURA);
        }

        startActivity(intent);
    }

    public void verHistorico(View view) {
        if(lista.isEmpty()) {
            Toast.makeText(this, "Não há jogos registrados!", Toast.LENGTH_SHORT).show();
        } else {
            Intent intentHistorico = new Intent(getBaseContext(), HistoricoActivity.class);
            startActivity(intentHistorico);
        }
    }
}