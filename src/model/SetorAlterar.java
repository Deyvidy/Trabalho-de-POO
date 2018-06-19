package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class SetorAlterar extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Alterar dados do SETOR ";
    }

    @Override
    public boolean executar() {
        int id = teclado.lerInt("Informe o ID: ");
        Setor setor = setorDao.pesquisar(id);

        if (setor == null) {
            System.out.println("SETOR não encontrado!");
        }
        else {
            System.out.println("ID: " + setor.getId());
            System.out.println("NOME: " + setor.getNome());            

            String nome = teclado.lerString("Novo NOME: ");            

            setor.setNome(nome);            

            setorDao.atualizar(setor);
            
        }

        return false;
    }
    
}
