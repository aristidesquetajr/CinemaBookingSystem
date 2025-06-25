/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kashiki.model;

/**
 *
 * @author kashiki
 */
public class Reserva {

    private int Id;
    private String NomeCliente;
    private Filme Filme;
    private int Quantidade;
    public static int NextId = 1;

    public Reserva(int id, String nomeCliente, Filme filme, int quantidade) {
        this.Id = id;
        this.NomeCliente = nomeCliente;
        this.Filme = filme;
        this.Quantidade = quantidade;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNomeCliente() {
        return this.NomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.NomeCliente = nomeCliente;
    }

    public Filme getFilme() {
        return this.Filme;
    }

    public void setFilme(Filme filme) {
        this.Filme = filme;
    }

    public int getQuantidade() {
        return this.Quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.Quantidade = quantidade;
    }

    public Object[] toRowTable() {
        return new Object[]{Id, NomeCliente, Filme.getNome(), Quantidade, ""};
    }
}
