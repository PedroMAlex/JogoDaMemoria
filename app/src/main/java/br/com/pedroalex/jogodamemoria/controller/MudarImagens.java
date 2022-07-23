package br.com.pedroalex.jogodamemoria.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.pedroalex.jogodamemoria.R;
import br.com.pedroalex.jogodamemoria.model.Botao;


public class MudarImagens {
    private static final int delay = 1000;                                                  // DEFININDO O TEMPO DE ESPERA QUANDO AS IMAGENS NÃO SÃO IGUAIS ANTES DE DESVIRAR

    private static int botoesComParesEncontrados;                                           // CONTAR A QUANTIDADE DE BOTÕES COM PAR ENCONTRADO PARA SABERMOS O MOMENTO DE FINALIZAR O JOGO

    private Context mm;


    public static void setImagem(Context context, Botao botaoClicado, List<Botao> botoes, TextView txtPontos, TextView txtNumeroAcertos, TextView txtNumeroErros, TextView txtTentivas, FrameLayout mensagemDecisao, Button btnReiniciarOJogo, Button btnSairDoJogo) {

        if (botoesComParesEncontrados >= 16) {
            AlertDialog.Builder magBox = new AlertDialog.Builder(context);
            magBox.setTitle("Escolha");
            magBox.setMessage("Deseja jogar novamente?");
            magBox.setPositiveButton("SIM", new DialogInterface.OnClickListener() {

                public DialogInterface.OnClickListener activity;

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    activity = this;
                    Intent intent = new Intent((Intent) activity);
                    context.startActivity(intent);
                    
                }
            });
            magBox.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int l) {
                    Log.d("meuScript", "Saindo...");
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
            magBox.show();
        }
        Pontos pontos = new Pontos(txtPontos, txtNumeroAcertos, txtNumeroErros, txtTentivas);            // INSTANCIANDO A CLASSE DOS PONTOS

        botoesComParesEncontrados = 0;                                                      // INCIALIZADNO A CONTAGEM DOS BOTÕES COM PARES ENCONTRADOS

        if (!botaoClicado.getIvJaClicado()) {                                               // SÓ FAZ ALGUMA COISA SE O BOTÃO NÃO ESTIVER CLICADO

            Log.i("meuScript", "Botão clicado: " + botaoClicado.getPosicaoBotao());

            virarBotao(context, botaoClicado);                                              // MOSTRAR A IMAGEM NO BOTÃO CONFORME O QUE FOI SORTEADO

            botaoClicado.setIvJaClicado(true);                                              // SETAR O BOTÃO COMO CLICADO PARA QUE CASO SEJA CLICADO NOVAMENTE NÃO PASSE MAIS POR AQUI

            for (Botao botaoLista : botoes) {                                               // PERCORRER A LISTA DE TODOS OS BOTÕES

                if (botaoLista.getParEncontrado())
                    botoesComParesEncontrados++;                                            // CONTA QUANTOS BOTÕES COM PARES ENCONTRADOS JÁ FORAM ENCONTRADOS

                if (botaoLista.getPosicaoBotao() != botaoClicado.getPosicaoBotao()) {       // AQUI ELE SÓ ENTRA SE O BOTÃO DA LISTA NÃO FOI O MESMO BOTÃO QUE FOI CLICADO NO MOMENTO

                    if (botaoLista.getIvJaClicado() &&                                      // CHECAR SE O BOTÃO DA LISTA JÁ FOI CLICADO EM OUTRO MOMENTO, SE NÃO FOI ENCONTRADO O PAR DELE AINDA E SE ELE NÃO É O BOTÃO CLICADO
                            botaoLista.getPosicaoBotao() != botaoClicado.getPosicaoBotao()) {


                        if (!botaoLista.getParEncontrado()) {

                            Log.i("'meuScript", "Botão " + botaoLista.getPosicaoBotao() + " da lista sem par ainda e não é o clicado no momento " + botaoClicado.getPosicaoBotao());

                            if (botaoLista.getNumeroImagemSorteada() ==
                                    botaoClicado.getNumeroImagemSorteada()) {               // CASO OS NÚMEROS SORTEADOS DO BOTÃO CLICADO E DO BOTÃO DA LISTA FOREM IGUAIS

                                Log.i("meuScript", "ACERTOU: Botão Clicado imagem: " + botaoClicado.getNumeroImagemSorteada() + " - Botão da Lista imagem: " + botaoLista.getNumeroImagemSorteada());

                                pontos.setPontuacao(true);                                  // MEXENDO NO PLACAR PELO ACERTO

                                botoesComParesEncontrados = botoesComParesEncontrados + 2;

                                botoes.get(botaoLista.getPosicaoBotao())
                                        .setIvJaClicado(true);                              // SETAR O BOTAO CLICADO PARA PAR ENCONTRADO VERDADEIRO

                                botoes.get(botaoLista.getPosicaoBotao())
                                        .setParEncontrado(true);                            // SETAR QUE O BOTAO CLICADO TEVE SEU PAR ENCONTRADO

                                botoes.get(botaoClicado.getPosicaoBotao())
                                        .setIvJaClicado(true);                              // SETAR NA LISTA QUE O BOTÃO CLICADO É VERDADEIRO

                                botoes.get(botaoClicado.getPosicaoBotao())
                                        .setParEncontrado(true);                            // SETAR NA LISTA QUE O BOTÃO CLICADO TEVE SEU PAR ENCONTRADO

                            } else {                                                        // CASO OS NÚMEROS SORTEADOS DO BOTÃO CLICADO E DO BOTÃO DA LISTA NÃO SEJAM IGUAIS

                                Log.i("meuScript", "ERROU: Botão Clicado imagem: " + botaoClicado.getNumeroImagemSorteada() + " - Botão da Lista imagem: " + botaoLista.getNumeroImagemSorteada());

                                pontos.setPontuacao(false);                                 // MEXENDO NO PLACAR PELO ERRO

                                botoes.get(botaoLista.getPosicaoBotao())
                                        .setIvJaClicado(false);                             // SETAR O BOTAO CLICADO PARA PAR ENCONTRADO FALSO

                                botoes.get(botaoLista.getPosicaoBotao())
                                        .setParEncontrado(false);                           // SETAR QUE O BOTAO CLICADO NÃO TEVE SEU PAR ENCONTRADO

                                botoes.get(botaoClicado.getPosicaoBotao())
                                        .setIvJaClicado(false);                             // SETAR NA LISTA QUE O BOTÃO CLICADO É FALSO

                                botoes.get(botaoClicado.getPosicaoBotao())
                                        .setParEncontrado(false);                           // SETAR NA LISTA QUE O BOTÃO CLICADO NÃO TEVE SEU PAR ENCONTRADO

                                new CountDownTimer(delay, delay) {                          // AGUARDAR O DELAY E DESVIRAR AS IMAGENS
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                    }

                                    @Override
                                    public void onFinish() {
                                        botaoClicado.getImageView().setImageDrawable(context.getDrawable(R.drawable.itn));
                                        botaoLista.getImageView().setImageDrawable(context.getDrawable(R.drawable.itn));
                                    }
                                }.start();
                            }
                        }
                    }
                }
            }

            Log.i("meuScript", "Botões com pares encontrados: " + botoesComParesEncontrados);

            if (botoesComParesEncontrados >= 16) {                                          // SE O JOGO CHEGOU AO SEU FINAL EXIBIR UMA CAIXA DE DIÁLOGO PERGUNTANDO SE QUER JOGAR NOVAMENTE
                Log.i("meuScript", "=-=-=-=-=-=-= GAME OVER =-=-=-=-=-=-=");
                Toast.makeText(context, "PARÉBENS... VOCÊ CONCLUI O JOGO COM SUCESSO", Toast.LENGTH_SHORT).show();
            }

        } else {                                                                            // SE O BOTÃO JÁ ESTIVER CLICADO AVISAR AO JOGADOR PARA ESCOLHER UM NÃO CLICADO AINDA

            Log.i("meuScript", "Botão já estava virado: " + botaoClicado.getPosicaoBotao());
            Toast.makeText(context, "CLIQUE NUM BOTÃO QUE AINDA NÃO FOI VIRADO", Toast.LENGTH_SHORT).show();

        }
    }

    private static void virarBotao(Context context, Botao botaoClicado) {
        switch (botaoClicado.getNumeroImagemSorteada()) {
            case 0:
                botaoClicado.getImageView().setImageDrawable(context.getDrawable(R.drawable.i00));
                break;
            case 1:
                botaoClicado.getImageView().setImageDrawable(context.getDrawable(R.drawable.i01));
                break;
            case 2:
                botaoClicado.getImageView().setImageDrawable(context.getDrawable(R.drawable.i02));
                break;
            case 3:
                botaoClicado.getImageView().setImageDrawable(context.getDrawable(R.drawable.i03));
                break;
            case 4:
                botaoClicado.getImageView().setImageDrawable(context.getDrawable(R.drawable.i04));
                break;
            case 5:
                botaoClicado.getImageView().setImageDrawable(context.getDrawable(R.drawable.i05));
                break;
            case 6:
                botaoClicado.getImageView().setImageDrawable(context.getDrawable(R.drawable.i06));
                break;
            case 7:
                botaoClicado.getImageView().setImageDrawable(context.getDrawable(R.drawable.i07));
                break;
        }
    }

}
