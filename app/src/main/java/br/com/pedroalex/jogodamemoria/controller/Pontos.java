package br.com.pedroalex.jogodamemoria.controller;

import android.widget.TextView;

public class Pontos {

    public static void setPontuacao(boolean foiAcerto, TextView txtNumeroAcertos, TextView txtPontos, TextView txtNumeroErros) {
        int pontos = Integer.valueOf(txtPontos.getText().toString());
        int acertos = Integer.valueOf(txtNumeroAcertos.getText().toString());
        int erros = Integer.valueOf(txtNumeroErros.getText().toString());

        if (foiAcerto) {
            acertos++;
            pontos = pontos + 3;
        } else {
            erros++;
            if (pontos > 0) pontos--;
        }

        txtPontos.setText(String.valueOf(pontos));
        txtNumeroErros.setText(String.valueOf(erros));
        txtNumeroAcertos.setText(String.valueOf(acertos));
    }
}