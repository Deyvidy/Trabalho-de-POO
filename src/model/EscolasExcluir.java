package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class EscolasExcluir extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Excluir a escola";
    }

    @Override
    public boolean executar() {
        int id = teclado.lerInt("id: ");
        Escolas escola = escolaDao.pesquisar(id);

        if ( escola == null) {
            System.out.println("Escola não encontrada!");
        }
        else {

            escolaDao.remover(escola);
        }

        return false;
    }
    
    
}
