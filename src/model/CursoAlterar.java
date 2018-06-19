package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class CursoAlterar extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Alterar dados dos CURSOS: ";
    }

    @Override
    public boolean executar() {
        Helper helper = new Helper();
        int id = teclado.lerInt("Informe o ID: ");
        Curso curso = cursoDao.pesquisar(id);

        if (curso == null) {
            System.out.println("CURSO não encontrado!");
        }
        else {
            System.out.println("ID: " + curso.getId());
            System.out.println("NOME: " + curso.getNome());
            System.out.println("ESCOLA: " + curso.getEscola().getNome());                 

            String nome = teclado.lerString("Novo NOME: ");
                        
            Escolas escola = helper.validarEscolas();
            
            curso.setEscola(escola);
            curso.setNome(nome);
            cursoDao.atualizar(curso);
            
        }

        return false;
    }
    
}
