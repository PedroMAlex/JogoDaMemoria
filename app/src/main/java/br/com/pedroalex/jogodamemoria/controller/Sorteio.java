package br.com.pedroalex.jogodamemoria.controller;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.pedroalex.jogodamemoria.R;
import br.com.pedroalex.jogodamemoria.model.Botao;
import br.com.pedroalex.jogodamemoria.view.MainActivity;

public class Sorteio {

    public static List<Botao> sorteandoImagens(Activity contexto) {
        Integer posicao = 0;
        List<Botao> botoes = new ArrayList<>();
        int sorteioImagens;
        while (botoes.size() < 16) {
            sorteioImagens = new Random().nextInt(8) + 1;
            int quantidadeDeImagens = 0;
            for (Botao botao : botoes) {
                if (botao.getNumeroImagemSorteada().equals(sorteioImagens))
                    quantidadeDeImagens++;
            }
            if (quantidadeDeImagens < 2){
                Botao botao = new Botao();
                botao.setNumeroImagemSorteada(sorteioImagens);
                botao.setPosicaoBotao(posicao);
                botao.setIvJaClicado(false);
                botao.setParEncontrado(false);
                botao.setContexto(contexto);
                botoes.add(botao);
                posicao++;
            }

        }
        return botoes;
    }

}
