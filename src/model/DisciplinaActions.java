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
            
    @Override
    public boolean inserir(){
                        
        String nome = teclado.lerString("Nome: ");
        
        int id = Id.getIdDisciplina();
                        
        Disciplina disciplina = new Disciplina( id, nome ); 
        
        inseriCursos(disciplina);

        disciplinaDao.inserir(disciplina);

        System.out.println("DISCIPLINA cadastrada com sucesso!");

        return false;
    }
    
    @Override
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
                System.out.println("CURSOS: " + disciplina.getCursos().get(i).getNome());              
            }

            String nome = teclado.lerString("Novo NOME: ");           
            disciplina.setNome(nome);
            
            String op = teclado.lerString("Deseja REMOVER um DISCIPLINA  associado a este CURSO "
                    + "[S] - Sim [N] - Não ?");
            if ("S".equals(op) || "s".equals(op)) {
                removerCurso(disciplina);
            }
            
            inseriCursos(disciplina);
            
            disciplinaDao.atualizar(disciplina);
            
        }

        return false;
    }
    
    @Override
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
    
    @Override
    public boolean listar(){
         ArrayList<Disciplina> disciplina = disciplinaDao.listar();

        Collections.sort(disciplina, this);

        for (int i = 0; i < disciplina.size(); i++) {
                Disciplina atual = disciplina.get(i);

                if (deveImprimir(atual)) {
                    System.out.println("ID: " + atual.getId());
                    System.out.println("NOME: " + atual.getNome());
                    
                    for(int j = 0; j < atual.getCursos().size(); j++) {
                        System.out.println("CURSOS: " + atual.getCursos().get(j).getNome());              
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
    
    public boolean inseriCursos( Disciplina disciplina ){        
        Helper helper = new Helper();
        boolean sair = true;
            while( sair ) {                
                String opCurso = teclado.lerString("Deseja informa quais CURSOS posuem essa DISCIPLINA? [S]- SIM [N] - NÃO: ");  
                if( "S".equals(opCurso) || "s".equals(opCurso) ){
                    Curso curso = helper.validarCurso();
                    disciplina.getCursos().add(curso);
                } else {
                    break;
                }
            }            
        return false;
    }
    
    public boolean removerCurso(Disciplina disciplina) {
        Curso atual = null;
        String elemento = teclado.lerString("Nome do CURSO que deseja remover");
        for(int j = 0; j < disciplina.getCursos().size(); j++) {
                if ( disciplina.getCursos().get(j).getNome().equals(elemento)) {
                    atual = disciplina.getCursos().get(j);
                    disciplina.getCursos().remove(atual);
                } else {
                    break;
                }
        }
        return false;
    }
    
    
    
    
}
