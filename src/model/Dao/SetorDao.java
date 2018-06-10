/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import java.util.ArrayList;
import model.Setor;

/**
 *
 * @author Deyvidy
 */
public class SetorDao {
    protected static ArrayList<Setor> bancoDeDados = new ArrayList<>();
    
    public void inserir(Setor elemento) {
        bancoDeDados.add(elemento);
    }
   
    public ArrayList<Setor> listar() {
        return bancoDeDados;
    }
    
    public Setor pesquisar(int elemento) {
        Setor resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
                Setor atual = bancoDeDados.get(i);

                if (atual.getId()==elemento) {
                        resultado = atual;
                        break;
                }
        }

        return resultado;
    }
    
    public void atualizar(Setor setor) {
        Setor pesquisado = pesquisar( setor.getId());

        pesquisado.setNome(setor.getNome());
        
    }
    
    public void remover(Setor elemento) {
        bancoDeDados.remove(elemento);
    }
}
