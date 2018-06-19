package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class AdminstrativoExcluir extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Excluir ESCOLAS";
    }

    @Override
    public boolean executar() {
        int id = teclado.lerInt("id: ");
        Escolas escolas = escolaDao.pesquisar(id);

        if ( escolas == null) {
            System.out.println("Escola não encontrada!");
        }
        else {
           
            escolaDao.remover(escolas);
        }

        return false;
    }
    
    
}
