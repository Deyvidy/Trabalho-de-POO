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
public class AdminstrativoListar extends ItensDoMenu implements Comparator<Administrativo>{

    @Override
    public String descricao() {
        return "Listar ADMINISTRATIVO em ordem alfabetica";
    }

    @Override
    public boolean executar() {
        ArrayList<Administrativo> administrativo = administracaoDao.listar();

        Collections.sort(administrativo, this);

        for (int i = 0; i < administrativo.size(); i++) {
                Administrativo atual = administrativo.get(i);

                if (deveImprimir(atual)) {
                    System.out.println(atual.getMatricula() + " - " + atual.getNome()
                            + " - " + atual.getSalario()
                            + " - " + atual.getSetor().getNome()
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
    
    public boolean deveImprimir(Administrativo escolas){
        return true;
    }
    
    @Override
    public int compare(Administrativo t, Administrativo t1) {
        String nome1 = t.getNome();
        String nome2 = t1.getNome();
		
        return nome1.compareTo(nome2);
    }

}
