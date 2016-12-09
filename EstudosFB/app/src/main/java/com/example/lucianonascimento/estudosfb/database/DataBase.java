package com.example.lucianonascimento.estudosfb.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Fabiano Costa on 08/12/2016.
 */

public class DataBase extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "AGENDA";
    private static final String TABLE_CURSO = "curso";
    private static final String TABLE_CADASTRO = "cadastro";
    private static final String TABLE_CREATE_CURSO = "create table if not exists curso (curso VARCHAR, aula VARCHAR, exercicio TINYINT "
            + "laboratorio TINYINT);";

    private static final String TABLE_CREATE_CADASTRO = "create table if not exists cadastro (id integer primary key autoincrement, "
            + "nome VARCHAR not null, matricula VARCHAR not null, email VARCHAR not null, contaGit VARCHAR, "
            + "curso VARCHAR, senha VARCHAR);";

    public DataBase(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_CURSO);
        db.execSQL(TABLE_CREATE_CADASTRO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}