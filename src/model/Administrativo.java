package model;

public class Administrativo extends Funcionarios{
    private Setor setor;

    public Administrativo(String matricula,
                    String nome, Endereco endereco,
                    Agenda telefone, Data admissao,
                    float salario, Setor setor) {		

            super();
            this.matricula = matricula;
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
            this.admissao = admissao;		
            this.salario = salario;
            this.setor = setor;
    }

    public Setor getSetor() {
            return setor;
    }

    public void setSetor(Setor setor) {
            this.setor = setor;
    }

    
    
}