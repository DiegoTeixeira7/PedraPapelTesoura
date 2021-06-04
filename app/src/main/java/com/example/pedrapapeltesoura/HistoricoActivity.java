package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class HistoricoActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        ListView lista = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
          getApplicationContext(),
          android.R.layout.simple_list_item_1,
          android.R.id.text1,
          MainActivity.getListaDeResultados().toArray(new String[0])
        );

        lista.setAdapter(adapter);
    }
}