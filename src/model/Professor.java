package model;

import view.ItensDoMenu;

/*
 * O sistema dever� permitir o cadastro/atualiza��o de funcion�rios administrativos e
 * professores, armazenando/modificando as seguintes informa��es: matr�cula, nome, endere�o,
 * telefone, data de admiss�o e sal�rio. Caso seja administrativo: setor (escolhido de uma lista de
 * setrores cadastrados). Caso seja professor: escola (escolhida de uma lista de escolas cadastradas). O
 * sistema deve permitir a exclus�o do cadastro atrav�s da matr�cula.
 */

public class Professor extends Funcionarios {
    private Escolas escola;         
    
    public Professor (String matricula ){
        this(matricula, null);
    }
    
    public Professor(String matricula, String nome) {
		this(matricula, nome, null, null,null,0.0f,null);
	}
	
    public Professor(String matricula,
                    String nome, Endereco endereco,
                    Agenda telefone, Data admissao,
                    float salario, Escolas escola) {		

            super();
            this.matricula = matricula;
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
            this.admissao = admissao;		
            this.salario = salario;
            this.escola = escola;
    }

    public Escolas getEscola() {
            return escola;
    }

    public void setEscola(Escolas escola) {
            this.escola = escola;
    }    		

}
