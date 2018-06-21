package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class EscolasActions extends ItensDoMenu implements Comparator<Escolas> {
            
    @Override
    public boolean inserir(){
       
        String nome = teclado.lerString("NOME: ");
        int id = Id.getIdEscola();
        
        Escolas escolas = new Escolas( nome, id );        

        escolaDao.inserir(escolas);

        System.out.println("ESCOLA cadastrada com sucesso!" + "ID - " + escolas.getId());

        return false;
    }
    
    @Override
    public boolean alterar(){
        int id = teclado.lerInt("Informe o ID: ");
        Escolas escolas = (Escolas) escolaDao.pesquisar(id);

        if (escolas == null) {
            System.out.println("ESCOLA não encontrada!");
        }
        else {
            System.out.println("ID: " + escolas.getId());
            System.out.println("NOME: " + escolas.getNome()); 
            for(int j = 0; j < escolas.getProfessoresQueLecionam().size(); j++) {
                System.out.println("PROFESSOR: " + escolas.getProfessoresQueLecionam().get(j).getNome());
            }
            
            String nome = teclado.lerString("Novo NOME: ");
            escolas.setNome(nome);            
            
            String opInserir = teclado.lerString("Deseja associar PROFESSORES a esta ESCOLA? [S]- SIM [N] - NÃO: ");  
            if( "S".equals(opInserir) || "s".equals(opInserir) ){
                inseriProfessor( escolas );
            }        
            
            String opRemover = teclado.lerString("Deseja remover PROFESSORES associados a esta ESCOLA? [S]- SIM [N] - NÃO: ");  
            if( "S".equals(opRemover) || "s".equals(opRemover) ){
                removerProfessor( escolas );
            }    

            escolaDao.atualizar(escolas);            
        }
        return false;
    }
    
    @Override
    public boolean remover(){
        int id = teclado.lerInt("ID: ");
        Escolas escolas = (Escolas) escolaDao.pesquisar(id);

        if ( escolas == null) {
            System.out.println("ESCOLA não encontrada!");
        }
        else {           
            escolaDao.remover(escolas);
            System.out.println("ESCOLA removida com sucesso!");
        }

        return false;
    }
    
    @Override
    public boolean listar(){
        ArrayList<Escolas> escolas = escolaDao.listar();

        Collections.sort(escolas, this);

        for (int i = 0; i < escolas.size(); i++) {
                Escolas atual = escolas.get(i);

                if (deveImprimir(atual)) {
                    System.out.println("ID: " + atual.getId());
                    System.out.println("NOME: " + atual.getNome());
                    for(int j = 0; j < atual.getProfessoresQueLecionam().size(); j++) {
                        System.out.println("PROFESSOR: " + atual.getProfessoresQueLecionam().get(j).getNome());
                    }                
                    System.out.println("===================");
                }
        }

        return false;
    }

    public boolean deveImprimir(Escolas escolas){
        return true;
    }
    
    @Override
    public int compare(Escolas t, Escolas t1) {
        String nome1 = t.getNome();
        String nome2 = t1.getNome();
		
        return nome1.compareTo(nome2);
    }
    
    public boolean inseriProfessor( Escolas escola ) {
        Helper helper = new Helper();                   
                
        Professor professor = helper.validarProfessor();
        escola.getProfessoresQueLecionam().add(professor);                        
                     
        return false;
    }
    
    public boolean removerProfessor( Escolas escola ) {
        Professor atual;
        String elemento = teclado.lerString("Nome do PROFESSOR que deseja remover: ");
        for(int j = 0; j < escola.getProfessoresQueLecionam().size(); j++) {
                if ( escola.getProfessoresQueLecionam().get(j).getNome().equals(elemento)) {
                    atual = escola.getProfessoresQueLecionam().get(j);
                    escola.getProfessoresQueLecionam().remove(atual);
                } else {
                    break;
                }
        }
        return false;
    }
}
