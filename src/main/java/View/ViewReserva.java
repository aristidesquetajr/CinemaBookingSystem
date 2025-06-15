/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.ServicoFilme;
import Controller.ServicoReserva;
import java.util.List;
import Model.Filme;
import Model.Reserva;
import Util.ViewBase;

/**
 *
 * @author kashiki
 */
public class ViewReserva extends ViewBase {

    private final ServicoReserva servico;
    private final ServicoFilme servicoFilme;

    public ViewReserva(ServicoFilme servicoFilme) {
        super();
        this.servicoFilme = servicoFilme;
        this.servico = new ServicoReserva(servicoFilme);
    }

    public void menu() {
        final int CRIAR = 1, ATUALIZAR = 2, LISTAR = 3, PESQUISAR = 4, DELETAR = 5, TOTAL = 6, VOLTAR = 7, SAIR = 8;

        do {
            System.out.println("\n*****MENU RESERVAS*****");
            System.out.format("1 - Criar\n2 - Atualizar\n3 - Listar\n4 - Pesquisar\n5 - Deletar\n6 - Total de reservas do sistema \n7 - Voltar\n8 - Sair\nEscolha uma opção: ");

            this.option = this.scan.nextInt();
            this.scan.nextLine();

            switch (this.option) {
                case CRIAR ->
                    this.criar();
                case ATUALIZAR ->
                    this.atualizar();
                case LISTAR ->
                    this.listar();
                case PESQUISAR ->
                    this.pesquisar();
                case DELETAR ->
                    this.deletar();
                case TOTAL ->
                    this.calcularTotalReservas();
                case VOLTAR -> {
                    break;
                }
                case SAIR ->
                    System.exit(0);
                default ->
                    System.out.println("Opção Inválida!");
            }
        } while (this.option != 7);
    }

    private void listar() {
        List<Reserva> reservas = this.servico.Listar();

        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva criada");
        } else {
            System.out.println("**** LISTA DE RESERVAS ****");
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }

    private void criar() {
        List<Filme> filmes = servicoFilme.Listar();

        if (filmes.isEmpty()) {
            System.out.println("ERRO: Não tem nenhum filme disponivel!");
            return;
        }

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = this.scan.nextLine();

        for (Filme filme : filmes) {
            System.out.println(filme.getId() + " - " + filme.getNome());
        }

        System.out.print("Escolhe um filme: ");
        int filmeId = this.scan.nextInt();
        this.scan.nextLine();

        System.out.print("Digite a quatidade de bilhetes: ");
        int quantidade = this.scan.nextInt();
        this.scan.nextLine();

        Boolean isSuccess = this.servico.Cadastrar(nomeCliente, filmeId, quantidade);

        if (isSuccess) {
            System.out.println("Reserva cadastrada com sucesso!");
        } else {
            System.out.println("Reserva não cadastrada!");
        }
    }

    private void atualizar() {
        System.out.print("Digite o id: ");
        int id = this.scan.nextInt();
        this.scan.nextLine();

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = this.scan.nextLine();

        for (Filme filme : servicoFilme.Listar()) {
            System.out.println(filme.getId() + " - " + filme.getNome());
        }

        System.out.print("Escolhe um filme: ");
        int filmeId = this.scan.nextInt();
        this.scan.nextLine();

        System.out.print("Digite a quatidade de bilhetes: ");
        int quantidade = this.scan.nextInt();
        this.scan.nextLine();

        Boolean isSuccess = this.servico.Atualizar(id, nomeCliente, filmeId, quantidade);

        if (isSuccess) {
            System.out.println("Reserva atualizada com sucesso!");
        } else {
            System.out.println("Reserva não atualizada!");
        }
    }

    private void pesquisar() {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = this.scan.nextLine();

        Reserva reserva = this.servico.Consultar(nomeCliente);

        if (reserva != null) {
            System.out.println(reserva);
        } else {
            System.out.println("Reserva não encontrada!");
        }
    }

    private void deletar() {
        System.out.print("Digite o Id da reserva: ");
        int id = this.scan.nextInt();
        this.scan.nextLine();

        Boolean isSuccess = this.servico.Remover(id);

        if (isSuccess) {
            System.out.println("Reserva eliminada");
        } else {
            System.out.println("Id inválido");
        }
    }

    private void calcularTotalReservas() {
        List<Reserva> reservas = this.servico.Listar();

        int total = reservas.stream().mapToInt(Reserva::getQuantidade).sum();

        System.out.println("=== TOTAL DE RESERVAS NO SISTEMA: " + total + " ===");
    }
}
