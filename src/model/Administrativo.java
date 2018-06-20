package model;
/*
* O sistema deverá permitir o cadastro/atualização de funcionários administrativos e
* professores, armazenando/modificando as seguintes informações: matrícula, nome, endereço,
* telefone, data de admissão e salário. Caso seja administrativo: setor (escolhido de uma lista de
* setrores cadastrados). Caso seja professor: escola (escolhida de uma lista de escolas cadastradas). O
* sistema deve permitir a exclusão do cadastro através da matrícula.
*/
public class Administrativo extends Funcionarios{
    private Setor setor;

    public Administrativo(int matricula,
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

    public Data getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Data admissao) {
        this.admissao = admissao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    
    
}
