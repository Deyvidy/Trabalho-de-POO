package model;

import java.util.ArrayList;

/*
* O sistema deverá permitir o cadastro/atualização de disciplinas, armazenando/modificando
* as seguintes informações: código, nome da disciplina, cursos* (escolhido de uma lista de cursos
* cadastrados).
* A disciplina pode ser de vários cursos (Ex: Algoritmos em Eng. Civil e Algortimos em SI)
*/

public class Disciplina {
    protected int id;
    protected String nome;
    protected ArrayList<Curso> cursos = new ArrayList<>();

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

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

   
   
    

}
