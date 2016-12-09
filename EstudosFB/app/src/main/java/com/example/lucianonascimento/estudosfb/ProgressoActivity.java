package com.example.lucianonascimento.estudosfb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lucianonascimento.estudosfb.database.RepositorioCadastro;
import com.example.lucianonascimento.estudosfb.entidades.Cadastro;

public class ProgressoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progresso);

        RepositorioCadastro repositorioCadastro = new RepositorioCadastro(this);
        ListView lista = (ListView)findViewById(R.id.lista);
        ArrayAdapter<Cadastro> adapter = new ArrayAdapter<Cadastro>(this, android.R.layout.simple_list_item_1, repositorioCadastro.selectAll());
        lista.setAdapter(adapter);
    }

    public void acaoVoltar(View v) {
        finish();
    }
}
