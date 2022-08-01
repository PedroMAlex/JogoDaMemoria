package br.com.pedroalex.jogodamemoria.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import br.com.pedroalex.jogodamemoria.R;
import br.com.pedroalex.jogodamemoria.model.Usuario;
import br.com.pedroalex.jogodamemoria.util.ButtonEffect;

public class PlayerNameActivity extends AppCompatActivity {
    private Activity activity;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);

        TextView txtNomeJogador = findViewById(R.id.txtNomeDoJogador);
        Button btnSairPlayerName = findViewById(R.id.btnSairSegundaTela);
        Button btnIniciarOJogo = findViewById(R.id.btnIniciarOJogo);
        EditText edtNomeJogador = findViewById(R.id.edtNomeDoJogador);
        activity = this;

        // QUANDO CRIAR O BANCO RETIRAR ISSO
        ArrayList<Usuario> usuarios = getIntent().getParcelableArrayListExtra("usuarios");

        txtNomeJogador.setShadowLayer(10, 0, 0, Color.YELLOW);

        btnIniciarOJogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(activity, R.raw.click);
                mp.start();
                if (edtNomeJogador.getText().length() == 0) {
                    Toast.makeText(activity, "Antes de começar informe seu nome", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(activity, MainActivity.class);

                    // QUANDO CRIAR O BANCO RETIRAR ISSO
                    intent.putParcelableArrayListExtra("usuarios", usuarios);
                    intent.putExtra("nome", edtNomeJogador.getText().toString().toUpperCase());
                    startActivity(intent);
                    activity.finish();
                }
            }
        });

        btnSairPlayerName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(activity, R.raw.click);
                mp.start();
                activity.finish();
            }
        });

        btnIniciarOJogo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return ButtonEffect.play(v, event);
            }
        });

        btnSairPlayerName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return ButtonEffect.play(v, event);
            }
        });
    }
}