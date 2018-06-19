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
public class TurmasListar extends ItensDoMenu implements Comparator<Escolas>{

    @Override
    public String descricao() {
        return "Listar TURMAS em ordem alfabetica";
    }

    @Override
    public boolean executar() {
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
