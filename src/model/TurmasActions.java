package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Dao.SetorDao;
import model.Escolas;
import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class TurmasActions extends ItensDoMenu implements Comparator<Escolas> {
    private int quantidade;
        
    public boolean inserir(){
        this.quantidade++;
        String nome = teclado.lerString("Nome: ");
        int id = quantidade;        
        
        Escolas escolas = new Escolas( nome, id );        

        escolaDao.inserir(escolas);

        System.out.println("Setor cadastrado com sucesso!");

        return false;
    }
    
    public boolean alterar(){
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
