/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author kashiki
 */
public interface IFilme {

    boolean Cadastrar(String nome, String descricao);

    boolean Atualizar(int id, String nome, String descricao);

    Filme Consultar(String nome);

    Filme ConsultarPorId(int id);

    List<Filme> Listar();

    boolean Remover(int id);
}
