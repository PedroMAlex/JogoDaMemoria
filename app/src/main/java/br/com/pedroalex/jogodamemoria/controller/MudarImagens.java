package br.com.pedroalex.jogodamemoria.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import br.com.pedroalex.jogodamemoria.R;
import br.com.pedroalex.jogodamemoria.model.Botao;
import br.com.pedroalex.jogodamemoria.model.Usuario;
import br.com.pedroalex.jogodamemoria.view.PlayerNameActivity;
import br.com.pedroalex.jogodamemoria.view.SplashScreenActivity;

public class MudarImagens {
    private static final int delay = 1000;                                                  // DEFININDO O TEMPO DE ESPERA QUANDO AS IMAGENS NÃO SÃO IGUAIS ANTES DE DESVIRAR
    private static int botoesComParesEncontrados;                                           // CONTAR A QUANTIDADE DE BOTÕES COM PAR ENCONTRADO PARA SABERMOS O MOMENTO DE FINALIZAR O JOGO
    private List<Usuario> usuarios;
    private MediaPlayer mp;

    public void setImagem(Activity activity, Botao botaoClicado, List<Botao> botoes,
                                 TextView txtPontos, TextView txtNumeroAcertos,
                                 TextView txtNumeroErros, TextView txtTentivas,
                                 TextView txtNomeJogador, List<Usuario> users) {

        usuarios = users;
        mp = MediaPlayer.create(activity, R.raw.click);
        Pontos pontos = new Pontos(txtPontos, txtNumeroAcertos,
                txtNumeroErros, txtTentivas);                                               // INSTANCIANDO A CLASSE DOS PONTOS
        botoesComParesEncontrados = 0;                                                      // INCIALIZADNO A CONTAGEM DOS BOTÕES COM PARES ENCONTRADOS
        if (!botaoClicado.getIvJaClicado()) {                                               // SÓ FAZ ALGUMA COISA SE O BOTÃO NÃO ESTIVER CLICADO
            virarBotao(activity, botaoClicado);                                             // MOSTRAR A IMAGEM NO BOTÃO CONFORME O QUE FOI SORTEADO
            botaoClicado.setIvJaClicado(true);                                              // SETAR O BOTÃO COMO CLICADO PARA QUE CASO SEJA CLICADO NOVAMENTE NÃO PASSE MAIS POR AQUI
            for (Botao botaoLista : botoes) {                                               // PERCORRER A LISTA DE TODOS OS BOTÕES
                if (botaoLista.getParEncontrado())
                    botoesComParesEncontrados++;                                            // CONTA QUANTOS BOTÕES COM PARES ENCONTRADOS JÁ FORAM ENCONTRADOS
                if (botaoLista.getPosicaoBotao() != botaoClicado.getPosicaoBotao()) {       // AQUI ELE SÓ ENTRA SE O BOTÃO DA LISTA NÃO FOI O MESMO BOTÃO QUE FOI CLICADO NO MOMENTO
                    if (botaoLista.getIvJaClicado() &&                                      // CHECAR SE O BOTÃO DA LISTA JÁ FOI CLICADO EM OUTRO MOMENTO, SE NÃO FOI ENCONTRADO O PAR DELE AINDA E SE ELE NÃO É O BOTÃO CLICADO
                            botaoLista.getPosicaoBotao() != botaoClicado.getPosicaoBotao()) {
                        if (!botaoLista.getParEncontrado()) {
                            if (botaoLista.getNumeroImagemSorteada() ==
                                    botaoClicado.getNumeroImagemSorteada()) {               // CASO OS NÚMEROS SORTEADOS DO BOTÃO CLICADO E DO BOTÃO DA LISTA FOREM IGUAIS
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
                                    public void onTick(long millisUntilFinished) { }

                                    @Override
                                    public void onFinish() {
                                        botaoClicado.getImageView().setImageDrawable(activity.getDrawable(R.drawable.itn));
                                        botaoLista.getImageView().setImageDrawable(activity.getDrawable(R.drawable.itn));
                                    }
                                }.start();
                            }
                        }
                    }
                }
            }

            if (botoesComParesEncontrados >= 16) {                                          // SE O JOGO CHEGOU AO SEU FINAL EXIBIR UMA CAIXA DE DIÁLOGO PERGUNTANDO SE QUER JOGAR NOVAMENTE
                if (!Objects.isNull(usuarios)) {
                    if (usuarios.size() < 4) {
                        usuarios = adicionarRecorde(txtNomeJogador, txtPontos, usuarios);
                    } else {
                        for (Usuario u: usuarios) {
                            if (Integer.parseInt(txtPontos.getText().toString()) > u.getPontos())
                                usuarios = adicionarRecorde(txtNomeJogador, txtPontos, usuarios);
                        }
                    }
                } else {
                    usuarios = adicionarRecorde(txtNomeJogador, txtPontos, usuarios);
                }

                AlertDialog.Builder magBox = new AlertDialog.Builder(activity);
                magBox.setTitle("VOCÊ CONCLUIU O JOGO COM SUCESSO MARCANDO " + pontos + " PONTOS");
                magBox.setMessage("DESEJA JOGAR NOVAMENTE?");

                magBox.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {           // REINICIAR O JOGO
                        Intent intent = new Intent(activity, PlayerNameActivity.class);
                        intent.putExtra("usuarios", (Parcelable) usuarios);
                        activity.startActivity(intent);
                        activity.finish();
                    }
                });

                magBox.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int l) {           // FINALIZAR O JOGO
                        activity.finish();
                    }
                });
                magBox.show();
            }
            mp.start();
        } else {                                                                            // SE O BOTÃO JÁ ESTIVER CLICADO AVISAR AO JOGADOR PARA ESCOLHER UM NÃO CLICADO AINDA
            Toast.makeText(activity, "CLIQUE NUM BOTÃO QUE AINDA NÃO FOI VIRADO", Toast.LENGTH_SHORT).show();
        }
    }

    // MÉTODO QUE VIRA OS BOTÕES QUANDO CLICADO MOSTRANDO A IMAGEM QUE FOI ESCOLHIDA NO SORTEIO
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

    // MÉTODO QUE ADICIONA O JOGADOR NA TABELA DE RECORDES DO JOGO
    private static List<Usuario> adicionarRecorde(TextView txtNomeJogador, TextView txtPontos, List<Usuario> usuarios) {
        if (Objects.isNull(usuarios))                                                       // SE A LISTA ESTIVER NULA INSTANCIAR O OBJETO
            usuarios = new ArrayList<>();

        usuarios.add(
            new Usuario(
                    txtNomeJogador.getText().toString(),
                    Integer.parseInt(txtPontos.getText().toString()),
                    LocalDate.now()
            )
        );

        return usuarios;
    }
}