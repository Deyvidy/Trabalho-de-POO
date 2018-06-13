package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class SetorExcluir extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Excluir O setor";
    }

    @Override
    public boolean executar() {
        int id = teclado.lerInt("id: ");
        Setor setor = setorDao.pesquisar(id);

        if ( setor == null) {
            System.out.println("Setor não encontrado!");
        }
        else {
            Setor setorRemover = new Setor(id);

            setorDao.remover(setorRemover);
        }

        return false;
    }
    
    
}
