package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class ProfessorAlterar extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Alterar dados do PROFESSORES ";
    }

    @Override
    public boolean executar() {
        String matricula = teclado.lerString("Informe a MATRICULA: ");
        Professor professor = (Professor) professorDao.pesquisar(matricula);

        if (professor == null) {
            System.out.println("PROFESSORE não encontrado!");
        }
        else {
            System.out.println("MATRICULA: " + professor.getMatricula());
            System.out.println("NOME: " + professor.getNome());            

            String nome = teclado.lerString("Novo NOME: ");            

            professor.setNome(nome);            

            setorDao.atualizar(professor);
            
        }

        return false;
    }
    
}
