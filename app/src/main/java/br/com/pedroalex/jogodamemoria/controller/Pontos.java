package br.com.pedroalex.jogodamemoria.controller;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import br.com.pedroalex.jogodamemoria.model.Botao;

public class Pontos {
    private static int placarPontuacao;
    private static int placarErros;
    private static int placarAcertos;


    public static class pontos {


        private final Context context = null;


        public pontos(TextView txtNumeroAcertos, TextView txtPontos, TextView txtNumeroErros, Botao botaoClicado, Botao botaoLista) {

            placarPontuacao = 0;
            placarErros = 0;
            placarAcertos = 0;

            if (botaoLista.getNumeroImagemSorteada() !=
                    botaoClicado.getNumeroImagemSorteada()) {

                if (placarPontuacao > 0) {
                    placarPontuacao = placarPontuacao--;
                }
                placarErros = placarErros + 1;
                txtPontos.setText(String.valueOf(placarPontuacao));
                txtNumeroErros.setText(String.valueOf(placarErros));
            }
            if (botaoLista.getNumeroImagemSorteada() ==
                    botaoClicado.getNumeroImagemSorteada()) {

                placarPontuacao = placarPontuacao + 3;
                placarAcertos++;
                txtPontos.setText(String.valueOf(placarPontuacao));
                txtNumeroAcertos.setText(String.valueOf(placarAcertos));

            }
        }
    }
}









