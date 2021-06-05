package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;


public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        getSupportActionBar().hide();

        ImageView imgvSuaEscolha = findViewById(R.id.imgvSuaEscolha);
        ImageView imgvAppEscolha = findViewById(R.id.imgvAppEscolha);

        Bundle bundle = getIntent().getExtras();
        int opcaoUsuario = bundle.getInt(MainActivity.OPCAO);

        switch (opcaoUsuario) {
            case MainActivity.PAPEL:
                imgvSuaEscolha.setImageResource(R.drawable.papel);
                break;
            case MainActivity.TESOURA:
                imgvSuaEscolha.setImageResource(R.drawable.tesoura);
                break;
            case MainActivity.PEDRA:
                imgvSuaEscolha.setImageResource(R.drawable.pedra);
                break;
        }

        SecureRandom random = new SecureRandom();
        int opcaoApp = (random.nextInt() & Integer.MAX_VALUE) % 3;

        switch (opcaoApp) {
            case MainActivity.PAPEL:
                imgvAppEscolha.setImageResource(R.drawable.papel);
                break;
            case MainActivity.TESOURA:
                imgvAppEscolha.setImageResource(R.drawable.tesoura);
                break;
            case MainActivity.PEDRA:
                imgvAppEscolha.setImageResource(R.drawable.pedra);
                break;
        }

        TextView textView = findViewById(R.id.tvResultado);

        if(opcaoApp == opcaoUsuario) {
            textView.setText("Empate!");
            MainActivity.getListaDeResultados().add("Emapte");
        } else {
            if(opcaoUsuario == MainActivity.PAPEL) {
                if(opcaoApp == MainActivity.PEDRA) {
                    textView.setText("Você ganhou!");
                    MainActivity.getListaDeResultados().add("Vitória");
                } else {
                    textView.setText("Você perdeu!");
                    MainActivity.getListaDeResultados().add("Derrota");
                }
            } else if(opcaoUsuario == MainActivity.PEDRA) {
                if (opcaoApp == MainActivity.PAPEL) {
                    textView.setText("Você perdeu!");
                    MainActivity.getListaDeResultados().add("Derrota");
                } else {
                    textView.setText("Você ganhou!");
                    MainActivity.getListaDeResultados().add("Vitória");
                }
            } else if(opcaoUsuario == MainActivity.TESOURA) {
                if (opcaoApp == MainActivity.PEDRA) {
                    textView.setText("Você perdeu!");
                    MainActivity.getListaDeResultados().add("Derrota");
                } else {
                    textView.setText("Você ganhou!");
                    MainActivity.getListaDeResultados().add("Vitória");
                }
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Jogo reiniciado!", Toast.LENGTH_SHORT).show();
    }
}