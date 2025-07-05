/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kashiki.controller;

import com.kashiki.model.Filme;
import com.kashiki.model.IReserva;
import com.kashiki.model.Reserva;
import java.util.List;

/**
 *
 * @author kashiki
 */
public class ServicoReserva implements IReserva {

    private Reserva reserva;
    private RepositorioReserva repositorio;
    private ServicoFilme servicoFilme;

    public ServicoReserva(ServicoFilme servicoFilme) {
        this.repositorio = new RepositorioReserva();
        this.servicoFilme = servicoFilme;
    }

    @Override
    public boolean Cadastrar(String nomeCliente, int filmeId, int quantidade) {
        if ((!nomeCliente.isEmpty()) && (filmeId > 0) && (quantidade > 0)) {
            Filme filme = servicoFilme.ConsultarPorId(filmeId);

            if (filme != null) {
                reserva = new Reserva(Reserva.NextId++, nomeCliente, filme, quantidade);
                return repositorio.Cadastrar(reserva);
            }
        }
        return false;
    }

    @Override
    public boolean Atualizar(int id, String nomeCliente, int filmeId, int quantidade) {
        if ((id > 0) && (!nomeCliente.isEmpty()) && (filmeId > 0) && (quantidade > 0)) {
            Filme filme = servicoFilme.ConsultarPorId(filmeId);

            if (filme != null) {
                reserva = new Reserva(id, nomeCliente, filme, quantidade);
                return repositorio.Atualizar(reserva);
            }
        }
        return false;
    }

    @Override
    public List<Reserva> Consultar(String nomeCliente) {
        return repositorio.Consultar(nomeCliente);
    }

    @Override
    public List<Reserva> Listar() {
        return repositorio.Listar();
    }

    @Override
    public boolean Remover(int id) {
        return repositorio.Remover(id);
    }

}
