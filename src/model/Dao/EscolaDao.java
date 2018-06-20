/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import java.util.ArrayList;
import model.Escolas;

/**
 *
 * @author Deyvidy
 */
public class EscolaDao implements InterfaceDao<Escolas>{
    protected static ArrayList<Escolas> bancoDeDados = new ArrayList<>();
    
    @Override
    public void inserir(Escolas elemento) {
        bancoDeDados.add(elemento);
    }
   
    @Override
    public ArrayList<Escolas> listar() {
        return bancoDeDados;
    }
    
    @Override
    public Escolas pesquisar(int elemento) {
        Escolas resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
                Escolas atual = bancoDeDados.get(i);

                if ( atual.getId() == elemento) {
                        resultado = atual;
                        break;
                }
        }

        return resultado;
    }
    
    @Override
    public Escolas pesquisar(String elemento) {
        Escolas resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
                Escolas atual = bancoDeDados.get(i);

                if ( atual.getNome().equals(elemento) ) {
                    resultado = atual;
                    break;
                }
        }

        return resultado;
    }
    
    @Override
    public void atualizar(Escolas elemento) {
        Escolas pesquisado = pesquisar( elemento.getId());

        pesquisado.setNome(elemento.getNome());
        
    }
    
    @Override
    public void remover(Escolas elemento) {
        bancoDeDados.remove(elemento);
    }
}
