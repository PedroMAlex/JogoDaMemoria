package br.com.pedroalex.jogodamemoria.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.pedroalex.jogodamemoria.R;
import br.com.pedroalex.jogodamemoria.view.MainActivity;

public class PlayerNameActivity extends AppCompatActivity {
    private EditText edtNomeJogador;
    private Button btnIniciarOJogo;
    private TextView txtNome;
    private Button btnSairPlayerName;
    private Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);
        activity = this;
        btnIniciarOJogo = findViewById(R.id.btnIniciarOJogo);
        txtNome = findViewById(R.id.txtNomeDoJogador);
        btnSairPlayerName = findViewById(R.id.btnSairSegundaTela);
        edtNomeJogador = findViewById(R.id.edtNomeDoJogador);

        btnIniciarOJogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (txtNome.getText().length() == 0) {
                    Toast.makeText(activity, "Antes de começar informe seu nome", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(activity, MainActivity.class);
                    intent.putExtra("nome", edtNomeJogador.getText().toString());
                    startActivity(intent);
                }
            }
        });

        btnSairPlayerName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View F) { // adiciondei um evento de clique.
                finish();
            }
        });
    }
}







