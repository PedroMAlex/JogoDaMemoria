package br.com.pedroalex.jogodamemoria.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.pedroalex.jogodamemoria.R;

public class SplashScreenActivity extends AppCompatActivity {
    private TextView titulo;
    private Button proximo;
    private Button sair;
    private ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        titulo = findViewById(R.id.txt_titulo);
        proximo = findViewById(R.id.btn_proximo);
        sair = findViewById(R.id.btn_sair);
        imagem = findViewById(R.id.img_imagemTelaInicial);

        proximo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { // adciondei um evento de clique.
                Intent intent = new Intent(SplashScreenActivity.this, PlayerNameActivity.class);
                startActivity(intent);
            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View F) { // adciondei um evento de clique.
                finish();
            }
        });
    }
}






