package br.com.pedroalex.jogodamemoria.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import br.com.pedroalex.jogodamemoria.R;

public class SplashScreenActivity extends AppCompatActivity {
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Button proximo = findViewById(R.id.btn_proximo);
        Button sair = findViewById(R.id.btn_sair);
        activity = this;

        proximo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreenActivity.this, PlayerNameActivity.class);
                startActivity(intent);
                activity.finish();
            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                activity.finish();
            }
        });
    }
}