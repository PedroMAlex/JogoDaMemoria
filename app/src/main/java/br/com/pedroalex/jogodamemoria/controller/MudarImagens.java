package br.com.pedroalex.jogodamemoria.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import br.com.pedroalex.jogodamemoria.R;
import br.com.pedroalex.jogodamemoria.model.Botao;

public class MudarImagens {
    private static final int delay = 3000;
    private static final int interval = 3000;


    public static Botao setImagem(Context context, Botao botaoClicado, List<Botao> botoes) {

        if (!botaoClicado.getIvJaClicado()) {                                           // SÓ FAZ ALGUMA COISA SE O BOTÃO NÃO ESTIVER CLICADO

            atribuirImagens(context, botaoClicado);                                     // MOSTRAR A IMAGEM NO BOTÃO CONFORME O QUE FOI SORTEADO

            botaoClicado.setIvJaClicado(true);                                          // SETAR O BOTÃO COMO CLICADO PARA QUE CASO SEJA CLICADO NOVAMENTE NÃO PASSE MAIS POR AQUI

            botoes.forEach(botaoLista -> {                                              // PERCORRER A LISTA DE TODOS OS BOTÕES

                if (botaoLista.getPosicaoBotao() != botaoClicado.getPosicaoBotao()) {   // AQUI ELE SÓ ENTRA SE O BOTÃO DA LISTA NÃO FOI O MESMO BOTÃO QUE FOI CLICADO NO MOMENTO

                    if (botaoLista.getIvJaClicado() &&
                            !botaoLista.getParEncontrado() &&
                            botaoLista.getPosicaoBotao() !=
                                    botaoClicado.getPosicaoBotao()) {                   // CHECAR SE O BOTÃO DA LISTA JÁ FOI CLICADO EM OUTRO MOMENTO, SE NÃO FOI ENCONTRADO O PAR DELE AINDA E SE ELE NÃO É O BOTÃO CLICADO

                        if (botaoLista.getNumeroImagemSorteada() ==
                                botaoClicado.getNumeroImagemSorteada()) {               // CASO OS NÚMEROS SORTEADOS DO BOTÃO CLIADO E DO BOTÃO DA LISTA FOREM IGUAIS

                            Toast.makeText(context, "ACERTOU", Toast.LENGTH_SHORT).show();

                            botoes.get(botaoLista.getPosicaoBotao())
                                    .setIvJaClicado(true);                             // SETAR O BOTAO CLICADO PARA PAR ENCONTRADO VERDADEIRO

                            botoes.get(botaoLista.getPosicaoBotao())
                                    .setParEncontrado(true);                           // SETAR QUE O BOTAO CLICADO TEVE SEU PAR ENCONTRADO

                            botoes.get(botaoClicado.getPosicaoBotao())
                                    .setIvJaClicado(true);                              // SETAR NA LISTA QUE O BOTÃO CLICADO É VERDADEIRO

                            botoes.get(botaoClicado.getPosicaoBotao())
                                    .setParEncontrado(true);                            // SETAR NA LISTA QUE O BOTÃO CLICADO TEVE SEU PAR ENCONTRADO

                        } else {                                                        // CASO OS NÚMEROS SORTEADOS DO BOTÃO CLICADO E DO BOTÃO DA LISTA NÃO SEJAM IGUAIS

                            Toast.makeText(context, "ERROU", Toast.LENGTH_SHORT).show();

                            botoes.get(botaoLista.getPosicaoBotao())
                                    .setIvJaClicado(false);                             // SETAR O BOTAO CLICADO PARA PAR ENCONTRADO FALSO

                            botoes.get(botaoLista.getPosicaoBotao())
                                    .setParEncontrado(false);                           // SETAR QUE O BOTAO CLICADO NÃO TEVE SEU PAR ENCONTRADO

                            botoes.get(botaoClicado.getPosicaoBotao())
                                    .setIvJaClicado(false);                             // SETAR NA LISTA QUE O BOTÃO CLICADO É FALSO

                            botoes.get(botaoClicado.getPosicaoBotao())
                                    .setParEncontrado(false);                           // SETAR NA LISTA QUE O BOTÃO CLICADO NÃO TEVE SEU PAR ENCONTRADO

                            Timer timer = new Timer();                                  // AGUARDAR 2 SEGUNDOS
                            timer.scheduleAtFixedRate(new TimerTask() {
                                public void run() {
                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                        @Override
                                        public void run() {                             // DESVIRANDO AS IMAGENS
                                            botaoClicado.getImageView().setImageDrawable(context.getResources().getDrawable(R.drawable.i));
                                            botaoLista.getImageView().setImageDrawable(context.getResources().getDrawable(R.drawable.i));
                                        }
                                    });
                                }
                            }, delay, interval);

                        }
                    }
                }
            });


        } else {                                                                        // SE O BOTÃO JÁ ESTIVER CLICADO AVISAR AO JOGADOR PARA ESCOLHER UM NÃO CLICADO AINDA

            Toast.makeText(context, "Clique somente em botões com ?", Toast.LENGTH_SHORT).show();

        }

        return botaoClicado;
    }

    private static void atribuirImagens (Context context, Botao botaoClicado){

        switch (botaoClicado.getNumeroImagemSorteada()) {
            case 0:
                botaoClicado.getImageView().setImageDrawable(context.getResources().getDrawable(R.drawable.i00));
                break;
            case 1:
                botaoClicado.getImageView().setImageDrawable(context.getResources().getDrawable(R.drawable.i01));
                break;
            case 2:
                botaoClicado.getImageView().setImageDrawable(context.getResources().getDrawable(R.drawable.i02));
                break;
            case 3:
                botaoClicado.getImageView().setImageDrawable(context.getResources().getDrawable(R.drawable.i03));
                break;
            case 4:
                botaoClicado.getImageView().setImageDrawable(context.getResources().getDrawable(R.drawable.i04));
                break;
            case 5:
                botaoClicado.getImageView().setImageDrawable(context.getResources().getDrawable(R.drawable.i05));
                break;
            case 6:
                botaoClicado.getImageView().setImageDrawable(context.getResources().getDrawable(R.drawable.i06));
                break;
            case 7:
                botaoClicado.getImageView().setImageDrawable(context.getResources().getDrawable(R.drawable.i07));
                break;
        }
    }
}

