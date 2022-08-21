package br.com.pedroalex.jogodamemoria.controller;

import android.content.Context;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.pedroalex.jogodamemoria.model.Recorde;
import br.com.pedroalex.jogodamemoria.repository.RecordeDao;

public class LerRecordes {
    private static List<Recorde> recordes;

    public static List<Recorde> verificarSeFoiRecorde(Context context, TextView txtNomeJogador, TextView txtPontos, TextView txtTentativas) throws Exception {
        RecordeDao recordeDao = new RecordeDao(context);
        recordes = recordeDao.listarRecordes();                         // RECEBENDO A LISTA DOS RECORDISTAS

        String nome = txtNomeJogador.getText().toString();
        int pontos = Integer.parseInt(txtPontos.getText().toString());
        int tentativas = Integer.parseInt(txtTentativas.getText().toString());

        if (recordes.size() < 5) {                                      // SE EXISTIR MENOS DE 5 RECORDISTAS INCLUIR O NOVO DIRETO
            adicionarNovoRecordista(context, nome, pontos, tentativas);
        } else {
            if (pontos >= recordes.get(4).getPONTOS())                  // SE OS PONTOS DO ÚLTIMO RECORDISTA FOR MENOS QUE O ATUAL, EXCLUIR O ÚLTIMO E ADICIONAR O NOVO
                adicionarNovoRecordista(context, nome, pontos, tentativas);
        }

        return recordes;
    }

    private static void adicionarNovoRecordista(Context context, String nome, int pontos, int tentativas) throws Exception {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (recordes.size() > 0) {                                      // CHECAR SE A TABELA DE RECORDES TEM REGISTROS
            if (recordes.size() >= 5) {                                 // SÓ EXCLUIR O ÚLTIMO RECORDE SE TIVER 5 OU MAIS REGISTROS NA TABELA
                int indiceUltimoRecordista = recordes.size() - 1;       // PEGAR O ÚLTIMO RECORSDITA
                int ID = recordes.get(indiceUltimoRecordista).getID();  // PEGAR O ID DO ÚLTIMO RECORDISTA PARA EXCLUIR ELE DA TABELA DE RECORDES
                RecordeDao recordeDao = new RecordeDao(context);
                recordeDao.excluirRecorde(ID);                          // EXECLUINDO O ÚLTIMO RECORDISTA
            }
        }

        Recorde recorde = new Recorde();                                // CRIANDO O NOVO OBJETO RECORDE QUE SERÁ INCLUÍDO DA TABELA DE RECORDES
        recorde.setNOME(nome);
        recorde.setPONTOS(pontos);
        recorde.setTENTATIVAS(tentativas);
        recorde.setDATA(data);

        RecordeDao recordeDao = new RecordeDao(context);
        recordeDao.gravarRelacionamento(recorde);                   // GRAVANDO NOVO RECORDISTA NA TABELA

        recordeDao = new RecordeDao(context);
        recordes = recordeDao.listarRecordes();                     // ATUALIZANDO A LISTA DOS RECORDISTAS
    }
}