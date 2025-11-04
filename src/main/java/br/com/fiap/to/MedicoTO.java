package br.com.fiap.to;

public class MedicoTO {
    private long id;
    private String nome;
    private String area;
    private long telefone;

    public MedicoTO() {}

    public MedicoTO(long id, String nome, String area, long telefone) {
        this.id = id;
        this.nome = nome;
        this.area = area;
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
}
