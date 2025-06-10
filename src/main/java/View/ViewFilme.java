/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.ServicoFilme;
import java.util.List;
import Model.Filme;
import Util.ViewBase;

/**
 *
 * @author kashiki
 */
public class ViewFilme extends ViewBase {

    private ServicoFilme servico;

    public ViewFilme(ServicoFilme servico) {
        super();
        this.servico = servico;
    }

    public void menu() {
        final int CADASTRAR = 1, ATUALIZAR = 2, LISTAR = 3, PESQUISAR = 4, REMOVER = 5, VOLTAR = 6, SAIR = 7;

        do {
            System.out.println("\n*****MENU FILMES*****");
            System.out.format("1 - Cadastrar\n2 - Atualizar\n3 - Listar\n4 - Pesquisar\n5 - Remover\n6 - Voltar\n7 - Sair\nEscolha uma opção: ");

            this.option = scan.nextInt();
            this.scan.nextLine();

            switch (this.option) {
                case CADASTRAR ->
                    this.cadastrar();
                case ATUALIZAR ->
                    this.atualizar();
                case LISTAR ->
                    this.listar();
                case PESQUISAR ->
                    this.pesquisar();
                case REMOVER ->
                    this.remover();
                case VOLTAR -> {
                    break;
                }
                case SAIR ->
                    System.exit(0);
                default ->
                    System.out.println("Opção Inválida!");
            }
        } while (this.option != 6);
    }

    private void listar() {
        List<Filme> filmes = this.servico.Listar();

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado");
        } else {
            System.out.println("**** LISTA DE FILMES ****");
            for (Filme filme : filmes) {
                System.out.println(filme);
            }
        }
    }

    private void cadastrar() {
        List<Filme> filmes = this.servico.Listar();

        System.out.print("Digite o nome do filme: ");
        String nome = this.scan.nextLine();

        boolean nomeExiste = filmes.stream().anyMatch(f -> f.getNome().trim().equalsIgnoreCase(nome.trim()));

        if (nomeExiste) {
            System.out.println("ERRO: Já existe um filme cadastrado com o nome '" + nome + "'!");
            return;
        }

        System.out.print("Digite uma descrição: ");
        String descricao = this.scan.nextLine();

        Boolean isSuccess = this.servico.Cadastrar(nome, descricao);

        if (isSuccess) {
            System.out.println("Filme cadastrado com sucesso!");
        } else {
            System.out.println("Filme não cadastrado!");
        }
    }

    private void atualizar() {
        System.out.print("Digite o id: ");
        int id = this.scan.nextInt();
        this.scan.nextLine();

        System.out.print("Digite o nome do filme: ");
        String nome = this.scan.nextLine();

        System.out.print("Digite uma descrição: ");
        String descricao = this.scan.nextLine();

        Boolean isSuccess = this.servico.Atualizar(id, nome, descricao);

        if (isSuccess) {
            System.out.println("Filme atualizado com sucesso!");
        } else {
            System.out.println("Filme não atualizado!");
        }
    }

    private void pesquisar() {
        System.out.print("Digite o nome do filme: ");
        String nome = this.scan.nextLine();

        Filme filme = this.servico.Consultar(nome);

        if (filme != null) {
            System.out.println(filme);
        } else {
            System.out.println("Filme não encontrado!");
        }
    }

    private void remover() {
        System.out.print("Digite o Id do filme: ");
        int id = this.scan.nextInt();
        this.scan.nextLine();

        Boolean isSuccess = this.servico.Remover(id);

        if (isSuccess) {
            System.out.println("Filme removido");
        } else {
            System.out.println("Id inválido");
        }
    }
}
