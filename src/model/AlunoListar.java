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
public class AlunoListar extends ItensDoMenu implements Comparator<Aluno>{

    @Override
    public String descricao() {
        return "Listar ALUNOS em ordem alfabetica";
    }

    @Override
    public boolean executar() {
        ArrayList<Aluno> aluno = alunoDao.listar();

        Collections.sort(aluno, this);

        for (int i = 0; i < aluno.size(); i++) {
                Aluno atual = aluno.get(i);

                if (deveImprimir(atual)) {
                        System.out.println(atual.getMatricula()+ " - " + atual.getNome()
                                + " - " + atual.getCurso().getNome() + "\n" 
                                + " - " + atual.getEndereco().getPais()
                                + " - " + atual.getEndereco().getEstado()
                                + " - " + atual.getEndereco().getCidade()
                                + " - " + atual.getEndereco().getBairro()
                                + " - " + atual.getEndereco().getCep()
                                + " - " + atual.getEndereco().getRua()
                                + " - " + atual.getEndereco().getNumero() + "\n"
                                + " - " + atual.getTelefone().getNumero()
                                + " - " + atual.getTelefone().getEmail()
                        );
                }
        }

        return false;
        
    }
    
    public boolean deveImprimir(Aluno escolas){
        return true;
    }
    
    @Override
    public int compare(Aluno t, Aluno t1) {
        String nome1 = t.getNome();
        String nome2 = t1.getNome();
		
        return nome1.compareTo(nome2);
    }

}
