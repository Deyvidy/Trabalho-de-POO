/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import java.util.ArrayList;
import model.Aluno;

/**
 *
 * @author Deyvidy
 */
public interface InterfaceAlunoDao {
    void inserir(Aluno aluno);

    ArrayList<Aluno> listar();

    Aluno pesquisar(String elemento);

    void atualizar(Aluno elemento);

    void remover(Aluno elemento);
}