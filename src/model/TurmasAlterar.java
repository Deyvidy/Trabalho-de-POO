package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class TurmasAlterar extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Alterar dados das TURMAS ";
    }

    @Override
    public boolean executar() {
        int id = teclado.lerInt("Informe o ID: ");
        Escolas escolas = (Escolas) escolaDao.pesquisar(id);

        if (escolas == null) {
            System.out.println("TURMA não encontrada!");
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
