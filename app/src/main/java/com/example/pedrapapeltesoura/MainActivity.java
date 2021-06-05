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

    public static int vitorias = 0;
    public static int derrotas = 0;
    public static int empates = 0;

    public static final String OPCAO = "opcao";
    
    private static List<String> lista;
    
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        intent = new Intent(getBaseContext(), ResultadoActivity.class);
        lista = new ArrayList<>();

        carregarDados();
    }

    public static List<String> getListaDeResultados() {
        return lista;
    }
    
    public void jogarPedra(View view) {
        intent.putExtra(OPCAO, PEDRA);
        startActivity(intent);
    }

    public void jogarPapel(View view) {
        intent.putExtra(OPCAO, PAPEL);
        startActivity(intent);
    }

    public void jogarTesoura(View view) {
        intent.putExtra(OPCAO, TESOURA);
        startActivity(intent);
    }

    public void gereHistorico(View view) {
        if(lista.isEmpty()) {
            Toast.makeText(this, "Não há jogos registrados!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intentHistorico = new Intent(getBaseContext(), HistoricoActivity.class);
        startActivity(intentHistorico);

    }

    private void carregarDados()  {
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        vitorias = pref.getInt("vitorias", 0);
        derrotas = pref.getInt("derrotas", 0);
        empates = pref.getInt("empates", 0);
    }
}