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
public class EscolaDao implements InterfaceEscolaDao {
    protected static ArrayList<Escolas> bancoDeDados = new ArrayList<>();
    
    public void inserir(Escolas elemento) {
        bancoDeDados.add(elemento);
    }
   
    public ArrayList<Escolas> listar() {
        return bancoDeDados;
    }
    
    public Escolas pesquisar(Integer elemento) {
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

    public Escolas pesquisar(String nome) {
        Escolas resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
            Escolas atual = bancoDeDados.get(i);

            if ( atual.getNome() == nome) {
                resultado = atual;
                break;
            }
        }

        return resultado;
    }

    public void atualizar(Escolas elemento) {
        Escolas pesquisado = pesquisar( elemento.getId());

        pesquisado.setNome(elemento.getNome());
        
    }
    
    public void remover(Escolas elemento) {
        bancoDeDados.remove(elemento);
    }
}
