package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class ProfessorExcluir extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Excluir PROFESSORES";
    }

    @Override
    public boolean executar() {
        String matricula = teclado.lerString("MATRICULA: ");
        Professor professor = (Professor) professorDao.pesquisar(matricula);

        if ( professor == null) {
            System.out.println("PROFESSOR não encontrado!");
        }
        else {            
            setorDao.remover(professor);
            System.out.println("PROFESSOR excluido com sucesso!");
        }

        return false;
    }
    
    
}
