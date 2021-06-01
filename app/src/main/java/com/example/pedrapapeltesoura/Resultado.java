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

        inicialize();
    }

    private void inicialize() {
        Intent it = getIntent();

        TextView jogadaUsuario = (TextView)findViewById(R.id.jogadaUsuario);
        String usuario = "Você: " + it.getStringExtra("jogadaUsuario");
        jogadaUsuario.setText(usuario);

        TextView jogadaApp = (TextView)findViewById(R.id.jogadaApp);
        String app = "App: " + it.getStringExtra("jogadaApp");
        jogadaApp.setText(app);

        TextView jogo = (TextView)findViewById(R.id.jogo);
        String resp = "Resultado: " + it.getStringExtra("jogo");
        jogo.setText(resp);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Jogo reiniciado!", Toast.LENGTH_SHORT).show();
    }
}