package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class SetorInserir extends ItensDoMenu{
    private int quantidade = 1;

    @Override
    public String descricao() {
        return "Cadastra SETOR ";
    }

    @Override
    public boolean executar() {
        String nome = teclado.lerString("NOME: ");
        int id =+ quantidade;        
        
        Setor aluno = new Setor( nome, id );        

        setorDao.inserir(aluno);

        System.out.println("SETOR cadastrado com sucesso!");
        this.quantidade++;
        return false;
    }
    
}
