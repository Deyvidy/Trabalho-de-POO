package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class EscolasAlterar extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Alterar dados da escola ";
    }

    @Override
    public boolean executar() {
        int id = teclado.lerInt("Informe o Id: ");

        Escolas escola = escolaDao.pesquisar(id);

        if (escola == null) {
            System.out.println("Escola não encontrado!");
        }
        else {
            System.out.println("Id: " + escola.getId());
            System.out.println("Nome: " + escola.getNome());

            String nome = teclado.lerString("Novo nome: ");

            escola.setNome(nome);

            escolaDao.atualizar(escola);
            
        }

        return false;
    }
    
}
