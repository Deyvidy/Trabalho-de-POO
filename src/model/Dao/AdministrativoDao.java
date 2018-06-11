/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import java.util.ArrayList;
import model.Administrativo;

/**
 *
 * @author Deyvidy
 */
public class AdministrativoDao implements InterfaceAdministracaoDao{
    
    protected static ArrayList<Administrativo> bancoDeDados = new ArrayList<>();
    
    public void inserir(Administrativo elemento) {
        bancoDeDados.add(elemento);
    }
   
    public ArrayList<Administrativo> listar() {
        return bancoDeDados;
    }
    
    public Administrativo pesquisar(String elemento) {
        Administrativo resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
                Administrativo atual = bancoDeDados.get(i);

                if (atual.getMatricula().equals(elemento)) {
                        resultado = atual;
                        break;
                }
        }

        return resultado;
    }
    
    public void atualizar(Administrativo aluno) {
        Administrativo pesquisado = pesquisar( aluno.getMatricula());

        pesquisado.setNome(aluno.getNome());
        
    }
    
    public void remover(Administrativo elemento) {
        bancoDeDados.remove(elemento);
    }
    
}
