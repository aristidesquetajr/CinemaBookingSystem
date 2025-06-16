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
    private String PublicoAlvo;
    private String DataLancamento;
    public static int NextId = 1;

    public Filme(int id, String nome, String descricao, String publicoAlvo, String dataLancamento) {
        this.Id = id;
        this.Nome = nome;
        this.Descricao = descricao;
        this.PublicoAlvo = publicoAlvo;
        this.DataLancamento = dataLancamento;
    }

    public Filme(String nome, String descricao, String publicoAlvo, String dataLancamento) {
        this.Id = Filme.NextId++;
        this.Nome = nome;
        this.Descricao = descricao;
        this.PublicoAlvo = publicoAlvo;
        this.DataLancamento = dataLancamento;
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

    public String getPublicoAlvo() {
        return this.PublicoAlvo;
    }

    public void setPublicoAlvo(String publicoAlvo) {
        this.PublicoAlvo = publicoAlvo;
    }

    public String getDataLancamento() {
        return this.DataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.DataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return this.Nome;
    }

    public Object[] toObject() {
        return new Object[]{this.getId(), this.getNome(), this.PublicoAlvo, this.DataLancamento, this.getDescricao()};
    }
}
