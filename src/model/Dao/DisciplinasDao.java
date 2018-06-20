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
public class DisciplinasDao implements InterfaceDao<Disciplina>{
    protected static ArrayList<Disciplina> bancoDeDados = new ArrayList<>();
    
    @Override
    public void inserir(Disciplina elemento) {
        bancoDeDados.add(elemento);
    }
   
    @Override
    public ArrayList<Disciplina> listar() {
        return bancoDeDados;
    }
    
    @Override
    public Disciplina pesquisar(int elemento) {
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
    
    @Override
    public Disciplina pesquisar(String elemento) {
        Disciplina resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
                Disciplina atual = bancoDeDados.get(i);

                if (atual.getNome().equals(elemento)) {
                        resultado = atual;
                        break;
                }
        }

        return resultado;
    }
    
    @Override
    public void atualizar(Disciplina elemento) {
        Disciplina pesquisado = pesquisar( elemento.getId());

        pesquisado.setNome(elemento.getNome());
        
    }
    
    @Override
    public void remover(Disciplina elemento) {
        bancoDeDados.remove(elemento);
    }

}
