package model;

import java.util.ArrayList;


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
    protected Professor professor;
    protected ArrayList<Aluno> Alunos = new ArrayList<>();

    public Turmas(int id, String nome, Disciplina disciplina, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.disciplina = disciplina;
        this.professor = professor;
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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ArrayList<Aluno> getAlunos() {
        return Alunos;
    }

    public void setAlunos(ArrayList<Aluno> Alunos) {
        this.Alunos = Alunos;
    }
    
    
}
