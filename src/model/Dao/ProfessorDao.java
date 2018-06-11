package model.Dao;

import java.util.ArrayList;
import model.Professor;

public class ProfessorDao implements InterfaceProfessorDao{
    protected static ArrayList<Professor> bancoDeDados = new ArrayList<>();

    public void inserir(Professor aluno) {
        bancoDeDados.add(aluno);
    }

    
    public ArrayList<Professor> listar() {
        return bancoDeDados;
    }


    public Professor pesquisar(String elemento) {
        Professor resultado = null;

        for (int i = 0; i < bancoDeDados.size(); i++) {
                Professor atual = bancoDeDados.get(i);

                if (atual.getMatricula().equals(elemento)) {
                        resultado = atual;
                        break;
                }
        }

        return resultado;
    }


    public void atualizar(Professor elemento) {
        Professor pesquisado = pesquisar(elemento.getMatricula());

        pesquisado.setNome(elemento.getNome());           
    }

    public void remover(Professor elemento) {
            bancoDeDados.remove(elemento);
    }

}
