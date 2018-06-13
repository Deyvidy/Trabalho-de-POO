package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class SetorAlterar extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Alterar dados do Setor ";
    }

    @Override
    public boolean executar() {
        int id = teclado.lerInt("Informe o Id: ");
        Setor setor = setorDao.pesquisar(id);

        if (setor == null) {
            System.out.println("Setor não encontrado!");
        }
        else {
            System.out.println("Id: " + setor.getId());
            System.out.println("Nome: " + setor.getNome());            

            String nome = teclado.lerString("Novo nome: ");            

            setor.setNome(nome);            

            setorDao.atualizar(setor);
            
        }

        return false;
    }
    
}
