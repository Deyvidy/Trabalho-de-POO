package model.Dao;

import java.util.ArrayList;
import model.Administrativo;

/**
 *
 * @author Deyvidy
 */
public interface InterfaceAdministracaoDao {
    
    void inserir(Administrativo aluno);

    ArrayList<Administrativo> listar();

    Administrativo pesquisar(String elemento);

    void atualizar(Administrativo elemento);

    void remover(Administrativo elemento);
}
