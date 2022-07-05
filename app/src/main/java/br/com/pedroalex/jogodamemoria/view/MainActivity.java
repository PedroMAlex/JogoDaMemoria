package br.com.pedroalex.jogodamemoria.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.icu.number.IntegerWidth;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;

import br.com.pedroalex.jogodamemoria.R;
import br.com.pedroalex.jogodamemoria.controller.MudarImagens;
import br.com.pedroalex.jogodamemoria.controller.Sorteio;
import br.com.pedroalex.jogodamemoria.model.Botao;

public class MainActivity extends AppCompatActivity {
    private TextView txtJogador;
    private TextView txtNumeroAcertos;
    private TextView txtNumeroErros;
    private TextView txtPontos;
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
    private ImageView iv16;
    private Activity activity;
    private List<Botao> botoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregarComponentes();
    }

    private void carregarComponentes() {
        txtJogador = findViewById(R.id.txtJogador);
        txtNumeroAcertos = findViewById(R.id.txtNumeroAcertos);
        txtNumeroErros = findViewById(R.id.txtNumeroErros);
        txtPontos = findViewById(R.id.txtPontos);
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
        iv16 = findViewById(R.id.iv16);
        activity = this;
        txtJogador.setText(getIntent().getStringExtra("nome"));

        botoes = Sorteio.sorteandoImagens(activity);


        List<Boolean>  mapaImagens=new ArrayList<Boolean>(Arrays.asList(new Boolean[16]));
        Collections.fill(mapaImagens, Boolean.FALSE);


        iv01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv01, botoes.get(0), botoes));
            }
        });

        iv02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv02, botoes.get(1), botoes));            }
        });

        iv03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv03, botoes.get(2), botoes));
            }
        });

        iv04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv04, botoes.get(3), botoes));
            }
        });

        iv05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv05, botoes.get(4), botoes));
            }
        });

        iv06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv06, botoes.get(5), botoes));
            }
        });

        iv07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv07, botoes.get(6), botoes));
            }
        });

        iv08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv08, botoes.get(7), botoes));

            }
        });

        iv09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv09, botoes.get(8), botoes));
            }
        });

        iv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv10, botoes.get(9), botoes));
            }
        });

        iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv11, botoes.get(10), botoes));
            }
        });

        iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv12, botoes.get(11), botoes));
            }
        });

        iv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv13, botoes.get(12), botoes));
            }
        });

        iv14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv14, botoes.get(13), botoes));
            }
        });

        iv15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv15, botoes.get(14), botoes));
            }
        });

        iv16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarBotoes(MudarImagens.setImagem(iv16, botoes.get(15), botoes));
            }
        });
    }

    private void atualizarBotoes(Botao botao){
        botoes.get(botao.getPosicaoBotao()).setIvJaClicado(botao.getIvJaClicado());
        botoes.get(botao.getPosicaoBotao()).setPosicaoBotao(botao.getPosicaoBotao());
        botoes.get(botao.getPosicaoBotao()).setContexto(botao.getContexto());
        botoes.get(botao.getPosicaoBotao()).setParEncontrado(botao.getParEncontrado());
        botoes.get(botao.getPosicaoBotao()).setNumeroImagemSorteada(botao.getNumeroImagemSorteada());
    }
    }






