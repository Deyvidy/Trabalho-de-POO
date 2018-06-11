package model.Dao;

import java.util.ArrayList;
import model.Disciplina;

/**
 *
 * @author Deyvidy
 */
public interface InterfaceDisciplinaDao {
    void inserir(Disciplina aluno);

    ArrayList<Disciplina> listar();

    Disciplina pesquisar(int elemento);

    void atualizar(Disciplina elemento);

    void remover(Disciplina elemento);
}
