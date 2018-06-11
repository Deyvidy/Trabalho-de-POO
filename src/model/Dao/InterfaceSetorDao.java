package model.Dao;

import java.util.ArrayList;
import model.Setor;

/**
 *
 * @author Deyvidy
 */
public interface InterfaceSetorDao {
    void inserir(Setor aluno);

    ArrayList<Setor> listar();

    Setor pesquisar(int elemento);

    void atualizar(Setor elemento);

    void remover(Setor elemento);
}
