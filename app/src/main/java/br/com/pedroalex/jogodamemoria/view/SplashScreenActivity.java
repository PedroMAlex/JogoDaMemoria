package br.com.pedroalex.jogodamemoria.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.pedroalex.jogodamemoria.R;

public class SplashScreenActivity extends AppCompatActivity {
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Button proximo = findViewById(R.id.btn_proximo);
        TextView txtTitulo = findViewById(R.id.txt_titulo);
        activity = this;

        txtTitulo.setShadowLayer(10, 0, 0, Color.YELLOW);

        proximo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreenActivity.this, PlayerNameActivity.class);
                startActivity(intent);
                activity.finish();
            }
        });
    }
}