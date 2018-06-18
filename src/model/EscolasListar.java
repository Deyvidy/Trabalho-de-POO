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
public class EscolasListar extends ItensDoMenu implements Comparator<Escolas>{

    @Override
    public String descricao() {
        return "Listar escolas em ordem alfabetica";
    }

    @Override
    public boolean executar() {
        ArrayList<Escolas> escolas = escolaDao.listar();

        Collections.sort(escolas, this);

        for (int i = 0; i < escolas.size(); i++) {
                Escolas escola = escolas.get(i);

                if (deveImprimir(escola)) {
                        System.out.println(escola.getId()+ " - " + escola.getNome());
                }
        }

        return false;
        
    }
    

    public boolean deveImprimir(Escolas escola){
        return true;
    }
    
    @Override
    public int compare(Escolas t, Escolas t1) {
        String nome1 = t.getNome();
        String nome2 = t1.getNome();
		
        return nome1.compareTo(nome2);
    }

}
