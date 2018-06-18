package model;

/*
* O sistema deverá permitir o cadastro/atualização de turmas, armazenando/modificando as
* seguintes informações: código, nome, disciplina (escolhida de uma lista), professor (escolhido de
* uma lista) e alunos (escolhidos de uma lista). O sistema deve permitir a exclusão do cadastro
* através do código
*/

public class Turmas {
    protected int id;
    protected String nome;
    protected Disciplina disciplina;

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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    
}
