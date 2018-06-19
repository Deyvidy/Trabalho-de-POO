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

public class CursoListar extends ItensDoMenu implements Comparator<Curso>{

    @Override
    public String descricao() {
        return "Listar CURSOS em ordem alfabetica: ";
    }

    @Override
    public boolean executar() {
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
