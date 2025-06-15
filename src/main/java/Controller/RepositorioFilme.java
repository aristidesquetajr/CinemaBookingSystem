/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Filme;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kashiki
 */
public class RepositorioFilme {

    ArrayList<Filme> filmes = new ArrayList<>();

    public List<Filme> Listar() {
        return this.filmes;
    }

    protected Filme ConsultarPorId(int id) {
        return filmes.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean Cadastrar(Filme filme) {
        if (filme == null) {
            return false;
        }

        filmes.add(filme);
        return true;
    }

    public boolean Atualizar(Filme filme) {
        Filme filmeOld = ConsultarPorId(filme.getId());

        if (filmeOld != null) {
            int indexOf = filmes.indexOf(filmeOld);

            if (indexOf != -1) {
                this.filmes.set(indexOf, filme);
                return true;
            }

        }
        return false;
    }

    public List<Filme> Consultar(String nome) {
        if (nome != null) {
            return this.filmes.stream().filter(prdct -> prdct.getNome().toLowerCase().contains(nome.toLowerCase())).toList();
        }
        return null;
    }

    public boolean Remover(int id) {
        Filme filme = ConsultarPorId(id);

        if (filme != null) {
            this.filmes.remove(filme);
            return true;
        }
        return false;
    }

    public boolean AlreadyExists(String name) {
        if (name != null) {
            return this.filmes.stream().anyMatch(f -> f.getNome().trim().equalsIgnoreCase(name.trim()));
        }

        return false;
    }
}
