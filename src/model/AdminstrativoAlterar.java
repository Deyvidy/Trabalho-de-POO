package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class AdminstrativoAlterar extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Alterar dados das ADMINISTRATIVO ";
    }

    @Override
    public boolean executar() {
        String matricula = teclado.lerString("Informe a MATRICULA: ");
        Administrativo administrativo = (Administrativo) administracaoDao.pesquisar(matricula);

        if (administrativo == null) {
            System.out.println("Setor não encontrado!");
        }
        else {
            System.out.println("Id: " + administrativo.getMatricula());
            System.out.println("Nome: " + administrativo.getNome());            

            String nome = teclado.lerString("Novo nome: ");            

            administrativo.setNome(nome);            

            escolaDao.atualizar(administrativo);
            
        }

        return false;
    }
    
}
