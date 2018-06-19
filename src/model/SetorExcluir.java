package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class SetorExcluir extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Excluir O SETOR";
    }

    @Override
    public boolean executar() {
        int id = teclado.lerInt("ID: ");
        Setor setor = (Setor) setorDao.pesquisar(id);

        if ( setor == null) {
            System.out.println("SETOR não encontrado!");
        }
        else {            
            setorDao.remover(setor);
            System.out.println("SETOR excluido com sucesso!");
        }

        return false;
    }
    
    
}
