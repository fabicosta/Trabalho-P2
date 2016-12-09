package com.example.lucianonascimento.estudosfb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CursoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
    }

    public void showProgresso(View v) {
        Intent progresso = new Intent(this, ProgressoActivity.class);
        startActivity(progresso);
    }

    public void showCadastro(View v) {
        Intent cadastro = new Intent(this, CadastroActivity.class);
        startActivity(cadastro);
    }

    public void acaoSair() {
        finish();
    }
}
