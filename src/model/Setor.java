package model;

public class Setor {
    private int id;
    private String nome;
    
    public Setor(){};
    public Setor(String nome) {
        this.nome = nome;
        this.id += 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
