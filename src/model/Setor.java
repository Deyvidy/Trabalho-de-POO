package model;

/*
* O sistema deverá permitir o cadastro/atualização de aluno, armazenando/modificando as
* seguintes informações: id, nome. O sistema deve permitir a exclusão do cadastro através da
* matrícula.
*/

public class Setor {
    private int id;
    private String nome;
    
    public Setor(){};
    
    public Setor( int id ){
        this(null, id);
    }
    
    public Setor(String nome, int id) {
        this.nome = nome;
        this.id = id;
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
