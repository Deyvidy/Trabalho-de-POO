package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class TurmasInserir extends ItensDoMenu{
    private int quantidade;

    @Override
    public String descricao() {
        return "Cadastra escolas ";
    }

    @Override
    public boolean executar() {
        this.quantidade++;
        String nome = teclado.lerString("Nome: ");
        int id = quantidade;        
        
        Escolas escolas = new Escolas( nome, id );        

        escolaDao.inserir(escolas);

        System.out.println("Setor cadastrado com sucesso!");

        return false;
    }
    
}
