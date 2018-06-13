package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class SetorListar extends ItensDoMenu implements Comparator<Setor>{

    @Override
    public String descricao() {
        return "Listar setores em ordem alfabetica";
    }

    @Override
    public boolean executar() {
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
