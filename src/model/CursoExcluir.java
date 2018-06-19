package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class CursoExcluir extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Excluir CURSO: ";
    }

    @Override
    public boolean executar() {
        int id = teclado.lerInt("ID: ");
        Curso curso = (Curso) cursoDao.pesquisar(id);

        if ( curso == null) {
            System.out.println("CURSO não encontrado!");
        }
        else {
            cursoDao.remover(curso);
        }

        return false;
    }
    
    
}
