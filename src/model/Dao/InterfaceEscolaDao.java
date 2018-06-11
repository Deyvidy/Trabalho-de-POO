package model.Dao;

import java.util.ArrayList;
import model.Escolas;

/**
 *
 * @author Deyvidy
 */
public interface InterfaceEscolaDao {
    void inserir(Escolas aluno);

    ArrayList<Escolas> listar();

    Escolas pesquisar(int elemento);

    void atualizar(Escolas elemento);

    void remover(Escolas elemento);
}
