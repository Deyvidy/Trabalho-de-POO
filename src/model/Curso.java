package model;

/*
* O sistema deverá permitir o cadastro/atualização de cursos, armazenando/modificando as
* seguintes informações: código, nome do curso e escola a qual pertence (escolhida de uma lista de
* escolas cadastradas). O sistema deve permitir a exclusão do cadastro através do código.
*/


public class Curso {
    protected int id;
    protected String nome;
    protected Escolas escola;

    public Curso(int id,String nome, Escolas escola) {
        this.id = id;
        this.nome = nome;
        this.escola = escola;
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

    public Escolas getEscola() {
        return escola;
    }

    public void setEscola(Escolas escola) {
        this.escola = escola;
    }
    
    

}
