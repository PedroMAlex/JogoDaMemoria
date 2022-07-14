package br.com.pedroalex.jogodamemoria.controller;

import android.widget.TextView;

public class Pontos {
    private TextView txtNumeroAcertos;
    private TextView txtPontos;
    private TextView txtNumeroErros;

    public Pontos(TextView txtPontos, TextView txtNumeroAcertos, TextView txtNumeroErros) {
        this.txtNumeroAcertos = txtNumeroAcertos;
        this.txtNumeroErros = txtNumeroErros;
        this.txtPontos = txtPontos;
    }

    public void setPontuacao(boolean foiAcerto) {
        int pontos = Integer.parseInt(txtPontos.getText().toString());
        int acertos = Integer.parseInt(txtNumeroAcertos.getText().toString());
        int erros = Integer.parseInt(txtNumeroErros.getText().toString());

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