package br.com.pedroalex.jogodamemoria.controller;

import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.arch.core.internal.FastSafeIterableMap;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import br.com.pedroalex.jogodamemoria.R;
import br.com.pedroalex.jogodamemoria.model.Botao;

public class MudarImagens {

    public static Botao setImagem(ImageView iv, Botao botao, List<Botao> botoes) {

        if (botao.getIvJaClicado()) {
            iv.setImageDrawable(botao.getContexto().getResources().getDrawable(R.drawable.i));
            botao.setIvJaClicado(false);
            botao.setParEncontrado(false);
        } else {
            atribuirImagens(iv, botao);
            botao.setIvJaClicado(true);
            for (Botao b : botoes) {
                if (b.getPosicaoBotao() != botao.getPosicaoBotao()) {
                    if (!botao.getParEncontrado()) {
                        int delay = 2000;
                        int interval = 2000;
                        Timer timer = new Timer();

                        timer.scheduleAtFixedRate(new TimerTask() {
                            public void run() {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        iv.setImageDrawable(botao.getContexto().getResources().getDrawable(R.drawable.i));
                                    }
                                });
                            }
                        }, delay, interval);
                    }
                    if (b.getNumeroImagemSorteada() == botao.getNumeroImagemSorteada()) {
                        Toast.makeText(botao.getContexto(), "ACERTOU", Toast.LENGTH_SHORT).show();
                        botao.setParEncontrado(true);

                    }
                }
            }

        }

        return botao;
    }

            private static void atribuirImagens (ImageView iv, Botao botao){

                switch (botao.getNumeroImagemSorteada()) {
                    case 1:
                        iv.setImageDrawable(botao.getContexto().getResources().getDrawable(R.drawable.i01));
                        break;
                    case 2:
                        iv.setImageDrawable(botao.getContexto().getResources().getDrawable(R.drawable.i02));
                        break;
                    case 3:
                        iv.setImageDrawable(botao.getContexto().getResources().getDrawable(R.drawable.i03));
                        break;
                    case 4:
                        iv.setImageDrawable(botao.getContexto().getResources().getDrawable(R.drawable.i04));
                        break;
                    case 5:
                        iv.setImageDrawable(botao.getContexto().getResources().getDrawable(R.drawable.i05));
                        break;
                    case 6:
                        iv.setImageDrawable(botao.getContexto().getResources().getDrawable(R.drawable.i06));
                        break;
                    case 7:
                        iv.setImageDrawable(botao.getContexto().getResources().getDrawable(R.drawable.i07));
                        break;
                    case 8:
                        iv.setImageDrawable(botao.getContexto().getResources().getDrawable(R.drawable.i08));
                        break;

                }


            }

        }

