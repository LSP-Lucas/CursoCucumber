package org.example.model;

import java.util.Date;

public class NotaAluguel {

    private int preco;
    private Date dataEntrega;
    private int pontuacao;

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date time) {
        this.dataEntrega = time;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }
}
