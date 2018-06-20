package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Curso;
import model.Escolas;
import model.Helper;
import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class CursoActions extends ItensDoMenu implements Comparator<Curso> {
    private int quantidade;
        
    public boolean inserir(){
        this.quantidade++;
        Helper helper = new Helper();
        
        String nome = teclado.lerString("Nome: ");
        int id = quantidade;
        
        Escolas escola = helper.validarEscolas();
        if (escola == null) return false;
        
        Curso curso = new Curso( nome, escola );        

        cursoDao.inserir(curso);

        System.out.println("CURSO cadastrado com sucesso!");

        return false;
    }
    
    public boolean alterar(){
        Helper helper = new Helper();
        int id = teclado.lerInt("Informe o ID: ");
        Curso curso = (Curso) cursoDao.pesquisar(id);

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
    
    public boolean remover(){
        int id = teclado.lerInt("ID: ");
        Curso curso = (Curso) cursoDao.pesquisar(id);

        if ( curso == null) {
            System.out.println("CURSO não encontrado!");
        }
        else {
            cursoDao.remover(curso);
        }

        return false;
    }
    
    public boolean listar(){
         ArrayList<Curso> curso = cursoDao.listar();

        Collections.sort(curso, this);

        for (int i = 0; i < curso.size(); i++) {
                Curso atual = curso.get(i);

                if (deveImprimir(atual)) {
                    System.out.println(atual.getId()+ " - " + atual.getNome() + " - " + atual.escola.getNome());
                }
        }

        return false;
    }

    public boolean deveImprimir(Curso curso){
        return true;
    }
    
    @Override
    public int compare(Curso t, Curso t1) {
        String nome1 = t.getNome();
        String nome2 = t1.getNome();
		
        return nome1.compareTo(nome2);
    }
    
}
