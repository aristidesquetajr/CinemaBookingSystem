/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kashiki
 */
public class Filme {

    private int Id;
    private String Nome;
    private String Descricao;
    public static int NextId = 1;

    public Filme(int id, String nome, String descricao) {
        this.Id = id;
        this.Nome = nome;
        this.Descricao = descricao;
    }
    
    public Filme(String nome, String descricao) {
        this.Id = Filme.NextId++;
        this.Nome = nome;
        this.Descricao = descricao;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getDescricao() {
        return this.Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }

    @Override
    public String toString() {
        return "Filme: {Id: " + this.Id + ", Nome: " + this.Nome + ", Descricao: " + this.Descricao + "}";
    }

}
