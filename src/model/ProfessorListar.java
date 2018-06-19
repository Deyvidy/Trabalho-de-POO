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
public class ProfessorListar extends ItensDoMenu implements Comparator<Professor>{

    @Override
    public String descricao() {
        return "Listar PROFESSORES em ordem alfabetica";
    }

    @Override
    public boolean executar() {
        ArrayList<Professor> professor = professorDao.listar();

        Collections.sort(professor, this);

        for (int i = 0; i < professor.size(); i++) {
                Professor atual = professor.get(i);

                if (deveImprimir(atual)) {
                    System.out.println(atual.getMatricula() + " - " + atual.getNome()
                            + " - " + atual.getSalario()
                            + " - " + "DATA DE ADMISSAO"
                            + " - " + atual.getAdmissao().getAno()
                            + " - " + atual.getAdmissao().getMes()
                            + " - " + atual.getAdmissao().getDia()
                            + " - " + "ENDERECO" + "\n"
                            + " - " + atual.getEndereco().getPais()
                            + " - " + atual.getEndereco().getEstado()
                            + " - " + atual.getEndereco().getCidade()
                            + " - " + atual.getEndereco().getBairro()
                            + " - " + atual.getEndereco().getCep()
                            + " - " + atual.getEndereco().getRua()
                            + " - " + atual.getEndereco().getNumero()
                            + " - " + "CONTATO" + "\n"
                            + " - " + atual.getTelefone().getNumero()
                            + " - " + atual.getTelefone().getEmail()
                    );
                }
        }

        return false;
        
    }
    
    public boolean deveImprimir(Professor professor){
        return true;
    }
    
    @Override
    public int compare(Professor t, Professor t1) {
        String nome1 = t.getNome();
        String nome2 = t1.getNome();
		
        return nome1.compareTo(nome2);
    }

}
