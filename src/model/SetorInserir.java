package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class SetorInserir extends ItensDoMenu{
    private int quantidade;

    @Override
    public String descricao() {
        return "Cadastra Setor ";
    }

    @Override
    public boolean executar() {
        this.quantidade++;
        String nome = teclado.lerString("Nome: ");
        int id = quantidade;        
        
        Setor aluno = new Setor( nome, id );        

        setorDao.inserir(aluno);

        System.out.println("Setor cadastrado com sucesso!");

        return false;
    }
    
}
