package model;

public class Escolas {
    private int id;
    private String nome;

    public Escolas(String nome) {
        this.nome = nome;
        this.id += 1;
    }

    public int getId() {
        return id;
    }		
    public String getNome() {
            return nome;
    }
    public void setNome(String nome) {
            this.nome = nome;
    }	
}
