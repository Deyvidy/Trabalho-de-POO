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
public class SetorDao implements InterfaceSetorDao {
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
    
    public Setor buscarObjeto( int elemento ) {
        Setor setor = null;
        for ( int i = 0; i < this.bancoDeDados.size( ); i++ ) {
            if( this.bancoDeDados.get(i).getId() == elemento) {
                setor = this.bancoDeDados.get(i);
            }
        }
        return setor;
    }
    
    public void atualizar(Setor elemento) {
        Setor pesquisado = pesquisar( elemento.getId());

        pesquisado.setNome(elemento.getNome());
        
    }
    
    public void remover(Setor elemento) {
        bancoDeDados.remove(elemento);
    }
}
