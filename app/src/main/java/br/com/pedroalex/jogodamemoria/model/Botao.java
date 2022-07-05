package br.com.pedroalex.jogodamemoria.model;

import android.content.Context;
import android.graphics.drawable.Drawable;

import br.com.pedroalex.jogodamemoria.R;

public class Botao {
    private Integer numeroImagemSorteada;
    private Boolean ivJaClicado;
    private Boolean parEncontrado;
    private Integer posicaoBotao;
    private Context contexto;

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public Integer getNumeroImagemSorteada() {
        return numeroImagemSorteada;
    }

    public void setNumeroImagemSorteada(Integer numeroImagemSorteada) {
        this.numeroImagemSorteada = numeroImagemSorteada;
    }

    public Boolean getIvJaClicado() {
        return ivJaClicado;
    }

    public void setIvJaClicado(Boolean ivJaClicado) {
        this.ivJaClicado = ivJaClicado;
    }

    public Boolean getParEncontrado() {
        return parEncontrado;
    }

    public void setParEncontrado(Boolean parEncontrado) {
        this.parEncontrado = parEncontrado;
    }

    public Integer getPosicaoBotao() {
        return posicaoBotao;
    }

    public void setPosicaoBotao(Integer posicaoBotao) {
        this.posicaoBotao = posicaoBotao;
    }

    public void setImageDrawable(Drawable drawable) {

    }
}
