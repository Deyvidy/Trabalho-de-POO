package model;

/* O sistema deverá permitir o cadastro/atualização de alunos, armazenando/modificando as
 seguintes informações: matrícula, nome, endereço, telefone, curso (escolhido de uma lista de
 cursos cadastradas). O sistema deve permitir a exclusão do cadastro através da matrícula.
*/

public class Aluno extends Pessoa {
    protected Curso curso;

    public Aluno(int matricula,
                    String nome, Endereco endereco,
                    Agenda telefone, Curso curso) {		

        super();
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
  
    
    
    
}
