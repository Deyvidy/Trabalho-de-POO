package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class AlunoInserir extends ItensDoMenu{
    private int quantidade;

    @Override
    public String descricao() {
        return "Cadastrar ALUNOS ";
    }

    @Override
    public boolean executar() {
       Helper helper = new Helper();
        this.quantidade++;
        String matricula = teclado.lerString("Informe a MATRICULA: ");
        String nome = teclado.lerString("Informe o NOME: ");
        
        
        Endereco endereco = helper.preencherEndereco();
        
        Agenda telefone = helper.preencherAgenda();     
        
        Curso curso = helper.validarCurso();
        
        Aluno aluno = new Aluno( matricula, nome, endereco, telefone, curso );        

        alunoDao.inserir(aluno);

        System.out.println("ALUNO cadastrado com sucesso!");

        return false;
    }
    
    
    
}

