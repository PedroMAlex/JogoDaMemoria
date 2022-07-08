package br.com.pedroalex.jogodamemoria.controller;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.pedroalex.jogodamemoria.model.Botao;

public class Sorteio {

    public static List<Botao> sorteandoImagens(Activity contexto) {
        Integer posicao = 0;
        List<Botao> botoes = new ArrayList<>();
        int sorteioImagens;
        while (botoes.size() < 16) {
            sorteioImagens = new Random().nextInt(8);
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
                botoes.add(botao);
                posicao++;
            }
        }
        return botoes;
    }
}