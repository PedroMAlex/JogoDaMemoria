package br.com.pedroalex.jogodamemoria.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.pedroalex.jogodamemoria.R;
import br.com.pedroalex.jogodamemoria.controller.MudarImagens;
import br.com.pedroalex.jogodamemoria.controller.Sorteio;
import br.com.pedroalex.jogodamemoria.model.Botao;

public class MainActivity extends AppCompatActivity {
    private List<Botao> botoes;
    private Activity activity;

    private ImageView iv00;
    private ImageView iv01;
    private ImageView iv02;
    private ImageView iv03;
    private ImageView iv04;
    private ImageView iv05;
    private ImageView iv06;
    private ImageView iv07;
    private ImageView iv08;
    private ImageView iv09;
    private ImageView iv10;
    private ImageView iv11;
    private ImageView iv12;
    private ImageView iv13;
    private ImageView iv14;
    private ImageView iv15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;

        carregarComponentes();
    }

    private void carregarComponentes() {
        TextView txtNumeroAcertos = findViewById(R.id.txtNumeroAcertos);
        TextView txtNumeroErros = findViewById(R.id.txtNumeroErros);
        TextView txtPontos = findViewById(R.id.txtPontos);
        TextView txtJogador = findViewById(R.id.txtJogador);
        TextView txtTentativas = findViewById(R.id.txtTentativas);
        txtJogador.setText(getIntent().getStringExtra("nome"));

        iv00 = findViewById(R.id.iv00);
        iv01 = findViewById(R.id.iv01);
        iv02 = findViewById(R.id.iv02);
        iv03 = findViewById(R.id.iv03);
        iv04 = findViewById(R.id.iv04);
        iv05 = findViewById(R.id.iv05);
        iv06 = findViewById(R.id.iv06);
        iv07 = findViewById(R.id.iv07);
        iv08 = findViewById(R.id.iv08);
        iv09 = findViewById(R.id.iv09);
        iv10 = findViewById(R.id.iv10);
        iv11 = findViewById(R.id.iv11);
        iv12 = findViewById(R.id.iv12);
        iv13 = findViewById(R.id.iv13);
        iv14 = findViewById(R.id.iv14);
        iv15 = findViewById(R.id.iv15);
        botoes = Sorteio.sorteandoImagens(activity);
        atribuirImageViewAosBotoes(botoes);

        // SETANDO OS CLIQUES DOS BOTÕES
        iv00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(0), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });

        iv01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(1), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });

        iv02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(2), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });

        iv03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(3), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });

        iv04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(4), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });

        iv05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(5), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });

        iv06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(6), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });

        iv07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(7), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });

        iv08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(8), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);

            }
        });

        iv09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(9), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });

        iv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(10), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });

        iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(11), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });

        iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(12), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });

        iv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(13), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });

        iv14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(14), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });

        iv15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MudarImagens.setImagem(activity, botoes.get(15), botoes, txtPontos,
                        txtNumeroAcertos, txtNumeroErros, txtTentativas);
            }
        });
    }

    private void atribuirImageViewAosBotoes(List<Botao> botoes) {
        botoes.get(0).setImageView(iv00);
        botoes.get(1).setImageView(iv01);
        botoes.get(2).setImageView(iv02);
        botoes.get(3).setImageView(iv03);
        botoes.get(4).setImageView(iv04);
        botoes.get(5).setImageView(iv05);
        botoes.get(6).setImageView(iv06);
        botoes.get(7).setImageView(iv07);
        botoes.get(8).setImageView(iv08);
        botoes.get(9).setImageView(iv09);
        botoes.get(10).setImageView(iv10);
        botoes.get(11).setImageView(iv11);
        botoes.get(12).setImageView(iv12);
        botoes.get(13).setImageView(iv13);
        botoes.get(14).setImageView(iv14);
        botoes.get(15).setImageView(iv15);
    }
}