package com.finansoft.poodesafio.model.entities;

import com.finansoft.poodesafio.model.interfaces.AparelhoTelefonico;
import com.finansoft.poodesafio.model.interfaces.NavegadorInternet;
import com.finansoft.poodesafio.model.interfaces.ReprodutorMusical;

public class IPhone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {

    @Override
    public void tocar() {
        System.out.println("TOCANDO MUSICA");
    }

    @Override
    public void pausar() {
        System.out.println("PAUSANDO MUSICA");
    }

    @Override
    public void selecionarMusica() {
        System.out.println("SELECIONANDO MUSICA");
    }

    @Override
    public void ligar() {
        System.out.println("REALIZANDO LIGACAO");
    }

    @Override
    public void atender() {
        System.out.println("ATENDENDO LIGACAO");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("INICIANDO CORREIO DE VOZ");
    }

    @Override
    public void exibirPagina() {
        System.out.println("EXIBIR PAGINA");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("ADICIONANDO NOVA ABA");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("ATUALIZANDO PAGINA");
    }

}
