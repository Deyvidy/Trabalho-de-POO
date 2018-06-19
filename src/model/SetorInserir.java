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
        return "Cadastra SETOR ";
    }

    @Override
    public boolean executar() {
        this.quantidade++;
        String nome = teclado.lerString("NOME: ");
        int id = quantidade;        
        
        Setor aluno = new Setor( nome, id );        

        setorDao.inserir(aluno);

        System.out.println("SETOR cadastrado com sucesso!");

        return false;
    }
    
}
