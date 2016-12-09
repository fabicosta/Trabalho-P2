package com.example.lucianonascimento.estudosfb;

import android.database.SQLException;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lucianonascimento.estudosfb.database.RepositorioCadastro;
import com.example.lucianonascimento.estudosfb.entidades.Cadastro;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class CadastroActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private RepositorioCadastro repositorioCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void acaoCadastrar(View v) {
        try {
            repositorioCadastro = new RepositorioCadastro(this);

            EditText txtNome = (EditText)findViewById(R.id.txtNome);
            EditText txtMatricula = (EditText)findViewById(R.id.txtMatricula);
            EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
            EditText txtContaGit = (EditText)findViewById(R.id.txtContaGit);
            Spinner spiCurso = (Spinner)findViewById(R.id.spiCurso);

            Cadastro cadastro = new Cadastro();
            cadastro.setNome(txtNome.getText().toString());
            cadastro.setMatricula(txtMatricula.getText().toString());
            cadastro.setEmail(txtEmail.getText().toString());
            cadastro.setContaGit(txtContaGit.getText().toString());
            cadastro.setCurso(spiCurso.getSelectedItem().toString());

            repositorioCadastro.insert(cadastro);
            finish();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Cadastro") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
