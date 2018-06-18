package model.Dao;

import java.util.ArrayList;
import model.Turmas;

/**
 *
 * @author Deyvidy
 */

public class TurmasDao implements InterfaceTurmasDao{
    protected static ArrayList<Turmas> bancoDeDados = new ArrayList<>();
    
    public void inserir(Turmas elemento) {
        bancoDeDados.add(elemento);
    }
   
    public ArrayList<Turmas> listar() {
        return bancoDeDados;
    }
    
    public Turmas pesquisar(Integer elemento) {
        Turmas resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
                Turmas atual = bancoDeDados.get(i);

                if (atual.getId()== elemento) {
                        resultado = atual;
                        break;
                }
        }

        return resultado;
    }

    public Turmas pesquisar(String nome) {
        Turmas resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
            Turmas atual = bancoDeDados.get(i);

            if (atual.getNome()== nome) {
                resultado = atual;
                break;
            }
        }

        return resultado;
    }
    
    public void atualizar(Turmas elemento) {
        Turmas pesquisado = pesquisar( elemento.getId());

        pesquisado.setNome(elemento.getNome());
        pesquisado.setDisciplina(elemento.getDisciplina());
    }
    
    public void remover(Turmas elemento) {
        bancoDeDados.remove(elemento);
    }
}
