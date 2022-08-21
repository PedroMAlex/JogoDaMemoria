package br.com.pedroalex.jogodamemoria.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConnectionDatabase extends SQLiteOpenHelper {
	private static final String BD_NOME = "JOGOMEMORIA";
	private static final int BD_VERSAO  = 10;
	private String sql;

	public ConnectionDatabase(Context context) {
		super(context, BD_NOME, null, BD_VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		sql = "CREATE TABLE RECORDE " +
				"(IDJOGADOR INTEGER PRIMARY KEY, " +
				" NOME TEXT, " +
				" PONTOS INTEGER, " +
				"TENTATIVAS INTEGER, " +
				" DATA TEXT);";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (newVersion > oldVersion) {
			sql = "DROP TABLE RECORDE;";
			db.execSQL(sql);
			onCreate(db);
		}
	}
}