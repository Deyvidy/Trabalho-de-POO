package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class AlunoExcluir extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Excluir ALUNO";
    }

    @Override
    public boolean executar() {
        String matricula = teclado.lerString("MATRICULA: ");
        Aluno aluno = (Aluno) alunoDao.pesquisar(matricula);

        if ( aluno == null) {
            System.out.println("ALUNO não encontrada!");
        }
        else {           
            alunoDao.remover(aluno);
        }

        return false;
    }
    
    
}
