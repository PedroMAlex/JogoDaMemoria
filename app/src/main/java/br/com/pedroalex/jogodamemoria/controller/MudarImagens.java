package br.com.pedroalex.jogodamemoria.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
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
    private static int paresEncontrados;


    public static Botao setImagem(Context context, Botao botaoClicado, List<Botao> botoes) {

        paresEncontrados = 0;                                                               // INCIALIZADNO A CONTAGEM DOS BOTÕES COM PARES ENCONTRADOS

        if (!botaoClicado.getIvJaClicado()) {                                               // SÓ FAZ ALGUMA COISA SE O BOTÃO NÃO ESTIVER CLICADO

            Log.i("meuScript", "Botão clicado: " + botaoClicado.getPosicaoBotao());

            virarBotao(context, botaoClicado);                                              // MOSTRAR A IMAGEM NO BOTÃO CONFORME O QUE FOI SORTEADO

            botaoClicado.setIvJaClicado(true);                                              // SETAR O BOTÃO COMO CLICADO PARA QUE CASO SEJA CLICADO NOVAMENTE NÃO PASSE MAIS POR AQUI

            botoes.forEach(botaoLista -> {                                                  // PERCORRER A LISTA DE TODOS OS BOTÕES

                if (botaoLista.getParEncontrado())
                    paresEncontrados++;                                                     // CONTA QUANTOS BOTÕES COM PARES ENCONTRADOS JÁ FORAM ACHADOS

                if (botaoLista.getPosicaoBotao() != botaoClicado.getPosicaoBotao()) {       // AQUI ELE SÓ ENTRA SE O BOTÃO DA LISTA NÃO FOI O MESMO BOTÃO QUE FOI CLICADO NO MOMENTO

                    if (botaoLista.getIvJaClicado() &&                                      // CHECAR SE O BOTÃO DA LISTA JÁ FOI CLICADO EM OUTRO MOMENTO, SE NÃO FOI ENCONTRADO O PAR DELE AINDA E SE ELE NÃO É O BOTÃO CLICADO
                            botaoLista.getPosicaoBotao() != botaoClicado.getPosicaoBotao()) {

                        if (!botaoLista.getParEncontrado()) {

                            Log.i("'meuScript", "Botão " + botaoLista.getPosicaoBotao() + " da lista sem par ainda e não é o clicado no momento " + botaoClicado.getPosicaoBotao());

                            if (botaoLista.getNumeroImagemSorteada() ==
                                    botaoClicado.getNumeroImagemSorteada()) {               // CASO OS NÚMEROS SORTEADOS DO BOTÃO CLIADO E DO BOTÃO DA LISTA FOREM IGUAIS

                                // CHAMAR AQUI A CLASSE DOS PONTOS E ADICIONAR 3 PONTOS PELO ACERTO
                                Log.i("meuScript", "ACERTOU: Botão Clicado imagem: " + botaoClicado.getNumeroImagemSorteada() + " - Botão da Lista imagem: " + botaoLista.getNumeroImagemSorteada());

                                paresEncontrados = paresEncontrados + 2;

                                botoes.get(botaoLista.getPosicaoBotao())
                                        .setIvJaClicado(true);                              // SETAR O BOTAO CLICADO PARA PAR ENCONTRADO VERDADEIRO

                                botoes.get(botaoLista.getPosicaoBotao())
                                        .setParEncontrado(true);                            // SETAR QUE O BOTAO CLICADO TEVE SEU PAR ENCONTRADO

                                botoes.get(botaoClicado.getPosicaoBotao())
                                        .setIvJaClicado(true);                              // SETAR NA LISTA QUE O BOTÃO CLICADO É VERDADEIRO

                                botoes.get(botaoClicado.getPosicaoBotao())
                                        .setParEncontrado(true);                            // SETAR NA LISTA QUE O BOTÃO CLICADO TEVE SEU PAR ENCONTRADO

                            } else {                                                        // CASO OS NÚMEROS SORTEADOS DO BOTÃO CLICADO E DO BOTÃO DA LISTA NÃO SEJAM IGUAIS

                                // CHAMAR AQUI A CLASSE DOS PONTOS E ABATER 1 PONTO PELO ERRO
                                Log.i("meuScript", "ERROU: Botão Clicado imagem: " + botaoClicado.getNumeroImagemSorteada() + " - Botão da Lista imagem: " + botaoLista.getNumeroImagemSorteada());

                                botoes.get(botaoLista.getPosicaoBotao())
                                        .setIvJaClicado(false);                             // SETAR O BOTAO CLICADO PARA PAR ENCONTRADO FALSO

                                botoes.get(botaoLista.getPosicaoBotao())
                                        .setParEncontrado(false);                           // SETAR QUE O BOTAO CLICADO NÃO TEVE SEU PAR ENCONTRADO

                                botoes.get(botaoClicado.getPosicaoBotao())
                                        .setIvJaClicado(false);                             // SETAR NA LISTA QUE O BOTÃO CLICADO É FALSO

                                botoes.get(botaoClicado.getPosicaoBotao())
                                        .setParEncontrado(false);                           // SETAR NA LISTA QUE O BOTÃO CLICADO NÃO TEVE SEU PAR ENCONTRADO

                                // desvirarBotoes(context, botaoClicado.getImageView(), botaoLista.getImageView());
                            }
                        }
                    }
                }
            });

            Log.i("meuScript", "Botões com pares encontrados: " + paresEncontrados);

            if (paresEncontrados >= 16) {                                                   // CHECAR SE O JOGO CHEGOU AO SEU FINAL
                Log.i("meuScript", "=-=-=-=-=-=-= GAME OVER =-=-=-=-=-=-=");
            }


        } else {                                                                            // SE O BOTÃO JÁ ESTIVER CLICADO AVISAR AO JOGADOR PARA ESCOLHER UM NÃO CLICADO AINDA

            Log.i("meuScript", "Botão já estava virado: " + botaoClicado.getPosicaoBotao());
            Toast.makeText(context, "CLIQUE NUM BOTÃO QUE AINDA NÃO FOI VIRADO", Toast.LENGTH_SHORT).show();

        }

        return botaoClicado;
    }

    private static void desvirarBotoes(Context context, ImageView botaoClicado, ImageView botaoLista) {
        Timer timer = new Timer();                                      // AGUARDAR 2 SEGUNDOS
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {                                 // DESVIRANDO AS IMAGENS
                        botaoClicado.setImageDrawable(context.getResources().getDrawable(R.drawable.i));
                        botaoLista.setImageDrawable(context.getResources().getDrawable(R.drawable.i));
                    }
                });
            }
        }, delay, interval);
    }

    private static void virarBotao (Context context, Botao botaoClicado){
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

