package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class SetorActions extends ItensDoMenu implements Comparator<Setor> {
        
    @Override
    public boolean inserir(){        
        String nome = teclado.lerString("NOME: ");
        int id = Id.getIdSetor();
        Setor setor = new Setor( id , nome);
        
        setorDao.inserir(setor);
        System.out.println("SETOR cadastrado com sucesso!" + "ID - " + setor.getId());
        return false;
    }
    
    @Override
    public boolean alterar(){
        int id = teclado.lerInt("Informe o ID: ");
        Setor setor = (Setor) setorDao.pesquisar(id);

        if (setor == null) {
            System.out.println("SETOR não encontrado!");
        }
        else {
            System.out.println("ID: " + setor.getId());
            System.out.println("NOME: " + setor.getNome());            

            String nome = teclado.lerString("Novo NOME: ");            

            setor.setNome(nome);            

            setorDao.atualizar(setor);
            System.out.println("SETOR alterado com sucesso!");
        }

        return false;
       
    }
    
    @Override
    public boolean remover(){
        int id = teclado.lerInt("ID: ");
        Setor setor = (Setor) setorDao.pesquisar(id);

        if ( setor == null) {
            System.out.println("SETOR não encontrado!");
        }
        else {            
            setorDao.remover(setor);
            System.out.println("SETOR excluido com sucesso!");
        }

        return false;
    }
    
    @Override
    public boolean listar(){
         ArrayList<Setor> setor = setorDao.listar();

        Collections.sort(setor, this);

        for (int i = 0; i < setor.size(); i++) {
                Setor atual = setor.get(i);

                if (deveImprimir(atual)) {
                        System.out.println(atual.getId()+ " - " + atual.getNome());
                }
        }

        return false;
        
    }

    public boolean deveImprimir(Setor setor){
        return true;
    }
    
    @Override
    public int compare(Setor t, Setor t1) {
        String nome1 = t.getNome();
        String nome2 = t1.getNome();
		
        return nome1.compareTo(nome2);
    }
      
    
}
