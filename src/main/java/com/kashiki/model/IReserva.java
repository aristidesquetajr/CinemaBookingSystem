/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kashiki.model;

import java.util.List;

/**
 *
 * @author kashiki
 */
public interface IReserva {

    boolean Cadastrar(String nomeCliente, int filmeId, int quantidade);

    boolean Atualizar(int id, String nomeCliente, int filmeId, int quantidade);

    List<Reserva> Consultar(String nomeCliente);

    List<Reserva> Listar();

    boolean Remover(int id);
}
