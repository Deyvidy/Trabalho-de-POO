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
public class SetorDao implements InterfaceDao<Setor> {
    protected static ArrayList<Setor> bancoDeDados = new ArrayList<>();
    
    @Override
    public void inserir(Setor elemento) {
        bancoDeDados.add(elemento);
    }
   
    @Override
    public ArrayList<Setor> listar() {
        return bancoDeDados;
    }
    
    @Override
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
    
    @Override
    public Setor pesquisar(String elemento) {
        Setor resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
                Setor atual = bancoDeDados.get(i);

                if (atual.getNome().equals(elemento)) {
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
    
    @Override
    public void atualizar(Setor elemento) {
        Setor pesquisado = pesquisar( elemento.getId());

        pesquisado.setNome(elemento.getNome());
        
    }
    
    @Override
    public void remover(Setor elemento) {
        bancoDeDados.remove(elemento);
    }

}
