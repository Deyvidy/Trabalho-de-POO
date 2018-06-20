package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Escolas;
import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class EscolasActions extends ItensDoMenu implements Comparator<Escolas> {
    private int quantidade;
        
    @Override
    public boolean inserir(){
        this.quantidade++;
        String nome = teclado.lerString("NOME: ");
        int id = quantidade;        
        
        Escolas escolas = new Escolas( nome, id );        

        escolaDao.inserir(escolas);

        System.out.println("ESCOLA cadastrada com sucesso!");

        return false;
    }
    
    @Override
    public boolean alterar(){
        int id = teclado.lerInt("Informe o Id: ");
        Escolas escolas = (Escolas) escolaDao.pesquisar(id);

        if (escolas == null) {
            System.out.println("ESCOLA não encontrada!");
        }
        else {
            System.out.println("Id: " + escolas.getId());
            System.out.println("Nome: " + escolas.getNome());            

            String nome = teclado.lerString("Novo nome: ");            

            escolas.setNome(nome);            

            escolaDao.atualizar(escolas);
            
        }

        return false;
    }
    
    @Override
    public boolean remover(){
        int id = teclado.lerInt("id: ");
        Escolas escolas = (Escolas) escolaDao.pesquisar(id);

        if ( escolas == null) {
            System.out.println("Escola não encontrada!");
        }
        else {
           
            escolaDao.remover(escolas);
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
                    System.out.println(atual.getId()+ " - " + atual.getNome());
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
}
