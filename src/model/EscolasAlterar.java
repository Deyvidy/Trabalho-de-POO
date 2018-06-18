package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class EscolasAlterar extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Alterar dados das escolas ";
    }

    @Override
    public boolean executar() {
        int id = teclado.lerInt("Informe o Id: ");
        Escolas escolas = escolaDao.pesquisar(id);

        if (escolas == null) {
            System.out.println("Setor não encontrado!");
        }
        else {
            System.out.println("Id: " + escolas.getId());
            System.out.println("Nome: " + escolas.getNome());            

            String nome = teclado.lerString("Novo nome: ");            

            escolas.setNome(nome);            

            escolaDao.atualizar(escolas);
            
        }

        return false;
    }
    
}
