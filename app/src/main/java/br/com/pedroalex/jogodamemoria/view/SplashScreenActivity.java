package br.com.pedroalex.jogodamemoria.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.com.pedroalex.jogodamemoria.R;
import br.com.pedroalex.jogodamemoria.model.Usuario;
import br.com.pedroalex.jogodamemoria.util.ButtonEffect;

public class SplashScreenActivity extends AppCompatActivity {
    private Activity activity;

    private ArrayList<Usuario> usuarios;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Button proximo = findViewById(R.id.btn_proximo);
        TextView txtTitulo = findViewById(R.id.txt_titulo);
        activity = this;

        txtTitulo.setShadowLayer(10, 0, 0, Color.YELLOW);

        proximo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return ButtonEffect.play(v, event);
            }
        });

        proximo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreenActivity.this, PlayerNameActivity.class);
                intent.putParcelableArrayListExtra("usuarios", usuarios);
                startActivity(intent);
                activity.finish();
            }
        });
    }
}