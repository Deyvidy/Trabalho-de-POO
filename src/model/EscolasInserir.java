package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class EscolasInserir extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Cadastra Escola ";
    }

    @Override
    public boolean executar() {
        String nome = teclado.lerString("Nome: ");
        
        Escolas escola = new Escolas(nome);

        escolaDao.inserir(escola);

        System.out.println("Escola cadastrada com sucesso!");

        return false;
    }
    
}
