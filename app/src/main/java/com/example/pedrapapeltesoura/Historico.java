package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Historico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        getSupportActionBar().hide();

        TextView historico = (TextView)findViewById(R.id.hitorico);

        StringBuilder resp = new StringBuilder();
        int index = 1;
        for(String str : MainActivity.getLista()){
            resp.append(index).append(": ").append(str).append("\n");
            index++;
        }

        historico.setText(resp.toString());
    }
}