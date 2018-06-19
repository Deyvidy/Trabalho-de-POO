package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class AdminstrativoExcluir extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Excluir ADMINISTRATIVO";
    }

    @Override
    public boolean executar() {
        String matricula = teclado.lerString("MATRICULA: ");
        Administrativo administrativo = (Administrativo) administracaoDao.pesquisar(matricula);

        if ( administrativo == null) {
            System.out.println("FUNCIONARIO não encontrado!");
        }
        else {
           
            escolaDao.remover(administrativo);
        }

        return false;
    }
    
    
}
