package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class DisciplinaActions extends ItensDoMenu implements Comparator<Disciplina> {
    private int quantidade;
        
    public boolean inserir(){
        this.quantidade++;
                
        String nome = teclado.lerString("Nome: ");
        int id = quantidade; 
        
        Disciplina disciplina = new Disciplina( nome );        

        disciplinaDao.inserir(disciplina);

        System.out.println("DISCIPLINA cadastrada com sucesso!");

        return false;
    }
    
    public boolean alterar(){
        Helper helper = new Helper();
        
        int id = teclado.lerInt("Informe o ID: ");
        Disciplina disciplina = (Disciplina) disciplinaDao.pesquisar(id);

        if (disciplina == null) {
            System.out.println("DISCIPLINA não encontrada!");
        }
        else {
            System.out.println("ID: " + disciplina.getId());
            System.out.println("NOME: " + disciplina.getNome());
            
            for(int i = 0; i< disciplina.getCursos().size(); i++) {
                System.out.println("CURSOS: " + disciplina.getCursos().get(i));              
            }

            String nome = teclado.lerString("Novo NOME: ");
                        
            Escolas escola = helper.validarEscolas();
           
            disciplina.setNome(nome);
            disciplinaDao.atualizar(disciplina);
            
        }

        return false;
    }
    
    public boolean remover(){
        int id = teclado.lerInt("ID: ");
        Disciplina disciplina = (Disciplina) disciplinaDao.pesquisar(id);

        if ( disciplina == null) {
            System.out.println("DISCIPLINA não encontrada!");
        }
        else {
            cursoDao.remover(disciplina);
        }

        return false;
    }
    
    public boolean listar(){
         ArrayList<Disciplina> disciplina = disciplinaDao.listar();

        Collections.sort(disciplina, this);

        for (int i = 0; i < disciplina.size(); i++) {
                Disciplina atual = disciplina.get(i);

                if (deveImprimir(atual)) {
                    System.out.println(atual.getId()+ " - " + atual.getNome());
                    
                    for(int j = 0; j < atual.getCursos().size(); j++) {
                        System.out.println("CURSOS: " + atual.getCursos().get(j));              
                    }
                }
        }

        return false;
    }

    public boolean deveImprimir(Disciplina disciplina){
        return true;
    }
    
    @Override
    public int compare(Disciplina t, Disciplina t1) {
        String nome1 = t.getNome();
        String nome2 = t1.getNome();
		
        return nome1.compareTo(nome2);
    }
    
    
}
