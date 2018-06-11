package model.Dao;

import java.util.ArrayList;
import model.Curso;

/**
 *
 * @author Deyvidy
 */
public interface InterfaceCursoDao {
    void inserir(Curso aluno);

    ArrayList<Curso> listar();

    Curso pesquisar(int elemento);

    void atualizar(Curso elemento);

    void remover(Curso elemento);
}
