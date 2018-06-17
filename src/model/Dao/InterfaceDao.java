package model.Dao;

import java.util.ArrayList;

public interface InterfaceDao<Objeto> {

    public void inserir(Objeto objeto);

    public void atualizar(Objeto objeto);

    public void remover(Objeto objeto);

    public Objeto pesquisar(String param);

    public Objeto pesquisar(Integer param);

    public ArrayList<Objeto> listar();

}
