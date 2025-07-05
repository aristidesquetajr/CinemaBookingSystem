/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kashiki.controller;

import com.kashiki.model.Reserva;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kashiki
 */
public class RepositorioReserva {

    ArrayList<Reserva> reservas = new ArrayList<>();

    public List<Reserva> Listar() {
        return this.reservas;
    }

    protected Reserva ConsultarPorId(int id) {
        return reservas.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean Cadastrar(Reserva reserva) {
        if (reserva == null) {
            return false;
        }

        reservas.add(reserva);
        return true;
    }

    public boolean Atualizar(Reserva reserva) {
        Reserva reservaOld = ConsultarPorId(reserva.getId());

        if (reservaOld != null) {
            int indexOf = reservas.indexOf(reservaOld);

            if (indexOf != -1) {
                this.reservas.set(indexOf, reserva);
                return true;
            }

        }
        return false;
    }

    public List<Reserva> Consultar(String nomeCliente) {
        if (nomeCliente != null) {
            return this.reservas.stream().filter(prdct -> prdct.getNomeCliente().toLowerCase().contains(nomeCliente.toLowerCase())).toList();
        }
        return null;
    }

    public boolean Remover(int id) {
        Reserva reserva = ConsultarPorId(id);

        if (reserva != null) {
            this.reservas.remove(reserva);
            return true;
        }
        return false;
    }
}
