package com.example.lucianonascimento.estudosfb.database;

import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.example.lucianonascimento.estudosfb.entidades.Cadastro;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Fabiano Costa on 09/12/2016.
 */

public class RepositorioCadastro {

    private Context context;
    private SQLiteDatabase db;

    private SQLiteStatement insertStmt;
    private static final String INSERT = "insert into "
            + Cadastro.TABLE_NAME + "(nome,matricula,email,contaGit,curso) values (?,?,?,?,?)";

    public RepositorioCadastro(Context context) {
        this.context = context;
        DataBase dataBase = new DataBase(this.context);
        this.db = dataBase.getWritableDatabase();
        this.insertStmt = this.db.compileStatement(INSERT);
    }

    public long insert(Cadastro cadastro) {
        this.insertStmt.bindString(1, cadastro.getNome());
        this.insertStmt.bindString(2, cadastro.getMatricula());
        this.insertStmt.bindString(3, cadastro.getEmail());
        this.insertStmt.bindString(4, cadastro.getContaGit());
        this.insertStmt.bindString(5, cadastro.getCurso());

        return this.insertStmt.executeInsert();
    }

    public void deleteAll() {
        this.db.delete(Cadastro.TABLE_NAME, null, null);
    }

    public List<Cadastro> selectAll() {
        List<Cadastro> list = new ArrayList<Cadastro>();
        Cursor cursor = this.db.query(Cadastro.TABLE_NAME, new String[] { "nome","matricula","email","contaGit","curso" },
                null, null, null, null, "nome desc");

        if (cursor.moveToFirst()) {
            Cadastro retorno = new Cadastro();
            do {
                retorno.setNome(cursor.getString(0));
                retorno.setMatricula(cursor.getString(1));
                retorno.setEmail(cursor.getString(2));
                retorno.setContaGit(cursor.getString(3));
                retorno.setCurso(cursor.getString(4));
                list.add(retorno);

            } while (cursor.moveToNext());
        }

        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return list;
    }
}