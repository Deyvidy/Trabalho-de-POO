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
public class AdministrativoDao implements InterfaceDao<Administrativo>{
    
    protected static ArrayList<Administrativo> bancoDeDados = new ArrayList<>();
    
    @Override
    public void inserir(Administrativo elemento) {
        bancoDeDados.add(elemento);
    }
   
    @Override
    public ArrayList<Administrativo> listar() {
        return bancoDeDados;
    }
    
    @Override
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
        
    @Override
    public void atualizar(Administrativo aluno) {
        Administrativo pesquisado = pesquisar( aluno.getMatricula());

        pesquisado.setNome(aluno.getNome());
        
    }
    
    @Override
    public void remover(Administrativo elemento) {
        bancoDeDados.remove(elemento);
    }

    @Override
    public Administrativo pesquisar(int param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
