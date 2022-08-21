package br.com.pedroalex.jogodamemoria.repository;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.pedroalex.jogodamemoria.model.Recorde;

public class RecordeDao {
    public SQLiteDatabase db;

    public RecordeDao(Context context) {
        ConnectionDatabase conn = new ConnectionDatabase(context);
        db = conn.getWritableDatabase();
    }

    // METODO QUE GRAVA UM RECORDE
    public void gravarRelacionamento(Recorde recorde) throws Exception {
        ContentValues valores = new ContentValues();
        valores.put("NOME", recorde.getNOME());
        valores.put("PONTOS", recorde.getPONTOS());
        valores.put("TENTATIVAS", recorde.getTENTATIVAS());
        valores.put("DATA", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        db.insert("RECORDE", null, valores);
        db.close();
    }

    // METODO QUE EXCLUI UM RECORDE POR ID
    public void excluirRecorde(int id) throws Exception {
        db.delete("RECORDE",  "ID=" + id, null);
        db.close();
    }

    // LISTAR OS RECORDES ORDENADO POR PONTOS (ORDEM DESCRESCENTE)
    @SuppressLint("Range")
    public List<Recorde> listarRecordes() throws Exception {
        List<Recorde> recordes = new ArrayList<>();
        String sql = "SELECT * FROM RECORDE ORDER BY PONTOS DESC ";
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor == null) {
            db.close();
            return null;
        }
        try {
            if (cursor.moveToFirst()) {
                do {
                    Recorde recorde = new Recorde();
                    recorde.setID(cursor.getInt(cursor.getColumnIndex("IDJOGADOR")));
                    recorde.setNOME(cursor.getString(cursor.getColumnIndex("NOME")));
                    recorde.setPONTOS(cursor.getInt(cursor.getColumnIndex("PONTOS")));
                    recorde.setTENTATIVAS(cursor.getInt(cursor.getColumnIndex("TENTATIVAS")));
                    recorde.setDATA(cursor.getString(cursor.getColumnIndex("DATA")));
                    recordes.add(recorde);
                } while (cursor.moveToNext());
            }
        } finally {
            cursor.close();
            db.close();
        }
        return recordes;
    }
}