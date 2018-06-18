/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import java.util.ArrayList;
import model.Disciplina;

/**
 *
 * @author Deyvidy
 */
public class DisciplinasDao implements InterfaceDisciplinaDao{
    protected static ArrayList<Disciplina> bancoDeDados = new ArrayList<>();
    
    public void inserir(Disciplina elemento) {
        bancoDeDados.add(elemento);
    }
   
    public ArrayList<Disciplina> listar() {
        return bancoDeDados;
    }
    
    public Disciplina pesquisar(Integer elemento) {
        Disciplina resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
                Disciplina atual = bancoDeDados.get(i);

                if (atual.getId()==elemento) {
                        resultado = atual;
                        break;
                }
        }

        return resultado;
    }

    public Disciplina pesquisar(String nome) {
        Disciplina resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
            Disciplina atual = bancoDeDados.get(i);

            if (atual.getNome()==nome) {
                resultado = atual;
                break;
            }
        }

        return resultado;
    }
    
    public void atualizar(Disciplina elemento) {
        Disciplina pesquisado = pesquisar( elemento.getId());

        pesquisado.setNome(elemento.getNome());
        
    }
    
    public void remover(Disciplina elemento) {
        bancoDeDados.remove(elemento);
    }
}
