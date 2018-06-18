
package model.Dao;

import java.util.ArrayList;
import model.Curso;

/**
 *
 * @author Deyvidy
 */
public class CursoDao implements InterfaceCursoDao{
    protected static ArrayList<Curso> bancoDeDados = new ArrayList<>();
    
    public void inserir(Curso elemento) {
        bancoDeDados.add(elemento);
    }
   
    public ArrayList<Curso> listar() {
        return bancoDeDados;
    }
    
    public Curso pesquisar(Integer elemento) {
        Curso resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
                Curso atual = bancoDeDados.get(i);

                if (atual.getId()==elemento) {
                        resultado = atual;
                        break;
                }
        }

        return resultado;
    }

    public Curso pesquisar(String nome) {
        Curso resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
            Curso atual = bancoDeDados.get(i);

            if (atual.getNome()==nome) {
                resultado = atual;
                break;
            }
        }

        return resultado;
    }
    
    public void atualizar(Curso elemento) {
        Curso pesquisado = pesquisar( elemento.getId());

        pesquisado.setNome(elemento.getNome());
        
    }
    
    public void remover(Curso elemento) {
        bancoDeDados.remove(elemento);
    }
}
