package br.com.pedroalex.jogodamemoria.controller;

import android.widget.TextView;

public class Pontos {
    private TextView txtNumeroAcertos;
    private TextView txtPontos;
    private TextView txtNumeroErros;
    private TextView txtTentativas;

    public Pontos(TextView txtPontos, TextView txtNumeroAcertos, TextView txtNumeroErros, TextView txtTentativas) {
        this.txtNumeroAcertos = txtNumeroAcertos;
        this.txtNumeroErros = txtNumeroErros;
        this.txtPontos = txtPontos;
        this.txtTentativas = txtTentativas;
    }

    public void setPontuacao(boolean foiAcerto) {
        int pontos = Integer.parseInt(txtPontos.getText().toString());
        int acertos = Integer.parseInt(txtNumeroAcertos.getText().toString());
        int erros = Integer.parseInt(txtNumeroErros.getText().toString());
        int tentativas = Integer.parseInt(txtTentativas.getText().toString());

        if (foiAcerto) {
            tentativas++;
            acertos++;
            pontos = pontos + 3;
        } else {
            tentativas++;
            erros++;
            if (pontos > 0) pontos--;
        }

        txtPontos.setText(String.valueOf(pontos));
        txtNumeroErros.setText(String.valueOf(erros));
        txtNumeroAcertos.setText(String.valueOf(acertos));
        txtTentativas.setText(String.valueOf(tentativas));
    }
}