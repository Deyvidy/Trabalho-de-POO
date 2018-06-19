package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class CursoInserir extends ItensDoMenu{
    private int quantidade;

    @Override
    public String descricao() {
        return "Cadastra CURSOS: ";
    }

    @Override
    public boolean executar() {
        this.quantidade++;
        Helper helper = new Helper();
        
        String nome = teclado.lerString("Nome: ");
        int id = quantidade;
        
        Escolas escola = helper.validarEscolas();
        
        Curso curso = new Curso( nome, escola );        

        cursoDao.inserir(curso);

        System.out.println("CURSO cadastrado com sucesso!");

        return false;
    }
    
}
