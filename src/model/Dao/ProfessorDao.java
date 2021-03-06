package model.Dao;

import java.util.ArrayList;
import model.Professor;

public class ProfessorDao implements InterfaceDao<Professor>{
    protected static ArrayList<Professor> bancoDeDados = new ArrayList<>();

    @Override
    public void inserir(Professor aluno) {
        bancoDeDados.add(aluno);
    }

    
    @Override
    public ArrayList<Professor> listar() {
        return bancoDeDados;
    }


    @Override
    public Professor pesquisar(String elemento) {
        Professor resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
                Professor atual = bancoDeDados.get(i);

                if (atual.getNome().equals(elemento)) {
                        resultado = atual;
                        break;
                }
        }

        return resultado;
    }

    @Override
    public Professor pesquisar(int elemento) {
        Professor resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
                Professor atual = bancoDeDados.get(i);

                if (atual.getMatricula() == elemento ) {
                        resultado = atual;
                        break;
                }
        }

        return resultado;
    }

    @Override
    public void atualizar(Professor elemento) {
        Professor pesquisado = pesquisar(elemento.getMatricula());

        pesquisado.setNome(elemento.getNome());           
    }

    @Override
    public void remover(Professor elemento) {
            bancoDeDados.remove(elemento);
    }


}
