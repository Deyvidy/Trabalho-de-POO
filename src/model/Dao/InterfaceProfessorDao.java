package model.Dao;

import java.util.ArrayList;
import model.Professor;

/**
 *
 * @author Deyvidy
 */
public interface InterfaceProfessorDao {
    void inserir(Professor aluno);

    ArrayList<Professor> listar();

    Professor pesquisar(String elemento);

    void atualizar(Professor elemento);

    void remover(Professor elemento);
}
