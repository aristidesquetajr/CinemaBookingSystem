/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Filme;
import Model.IFilme;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author kashiki
 */
public class ServicoFilme implements IFilme {

    private Filme filme;
    private final RepositorioFilme repositorio;

    public ServicoFilme() {
        this.repositorio = new RepositorioFilme();
    }

    @Override
    public boolean Cadastrar(String nome, String descricao, String publicoAlvo, String dataLancamento) {
        if ((!nome.isEmpty()) && (!descricao.isEmpty()) && (!publicoAlvo.isEmpty()) && (!dataLancamento.isEmpty())) {
            if (repositorio.AlreadyExists(nome) != true) {
                filme = new Filme(nome, descricao, publicoAlvo, dataLancamento);
                return repositorio.Cadastrar(filme);
            }
        }
        return false;
    }

    @Override
    public boolean Atualizar(int id, String nome, String descricao, String publicoAlvo, String dataLancamento) {
        if ((id > 0) && (!nome.isEmpty()) && (!descricao.isEmpty()) && (!publicoAlvo.isEmpty()) && (!dataLancamento.isEmpty())) {
            filme = new Filme(id, nome, descricao, publicoAlvo, dataLancamento);
            return repositorio.Atualizar(filme);

        }
        return false;
    }

    @Override
    public List<Filme> Consultar(String nome) {
        return repositorio.Consultar(nome);
    }

    @Override
    public Filme ConsultarPorId(int id) {
        return repositorio.ConsultarPorId(id);
    }

    @Override
    public List<Filme> Listar() {
        List<Filme> filmes = repositorio.Listar();

        if (!filmes.isEmpty()) {
            filmes.sort(Comparator.comparing(Filme::getNome, String.CASE_INSENSITIVE_ORDER));
        }

        return filmes;
    }

    @Override
    public boolean Remover(int id) {
        return repositorio.Remover(id);
    }

}
