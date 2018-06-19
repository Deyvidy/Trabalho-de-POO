package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class AlunoAlterar extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Alterar dados de ALUNO ";
    }

    @Override
    public boolean executar() {
        int id = teclado.lerInt("Informe o ID: ");
        Escolas escolas = escolaDao.pesquisar(id);

        if (escolas == null) {
            System.out.println("ALUNO não encontrado!");
        }
        else {
            System.out.println("ID: " + escolas.getId());
            System.out.println("NOME: " + escolas.getNome());            

            String nome = teclado.lerString("Novo NOME: ");            

            escolas.setNome(nome);            

            escolaDao.atualizar(escolas);
            
        }

        return false;
    }
    
}
