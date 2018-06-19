package model.Dao;

import java.util.ArrayList;
import model.Aluno;

/**
 *
 * @author Deyvidy
 */
public class AlunoDao implements InterfaceDao<Aluno>{
    protected static ArrayList<Aluno> bancoDeDados = new ArrayList<>();
    
    public void inserir(Aluno elemento) {
        bancoDeDados.add(elemento);
    }
   
    public ArrayList<Aluno> listar() {
        return bancoDeDados;
    }
    
    public Aluno pesquisar(String elemento) {
        Aluno resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
                Aluno atual = bancoDeDados.get(i);

                if (atual.getMatricula().equals(elemento)) {
                        resultado = atual;
                        break;
                }
        }

        return resultado;
    }
    
    public void atualizar(Aluno aluno) {
        Aluno pesquisado = pesquisar( aluno.getMatricula());

        pesquisado.setNome(aluno.getNome());
        
    }
    
    public void remover(Aluno elemento) {
        bancoDeDados.remove(elemento);
    }

    @Override
    public Aluno pesquisar(int param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
