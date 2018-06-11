package model.Dao;

import java.util.ArrayList;
import model.Turmas;

/**
 *
 * @author Deyvidy
 */

public interface InterfaceTurmasDao {
    void inserir(Turmas aluno);

    ArrayList<Turmas> listar();

    Turmas pesquisar(int elemento);

    void atualizar(Turmas elemento);

    void remover(Turmas elemento);
}
