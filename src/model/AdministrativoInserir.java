package model;

import model.Dao.SetorDao;
import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class AdministrativoInserir extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Cadastro de Funcionarios do administrativo";
    }

    @Override
    public boolean executar() {
        String matricula = teclado.lerString("Matr�cula: ");
        String nome = teclado.lerString("Nome: ");
        Endereco endereco = new Endereco ();
        
        Agenda agenda = new Agenda();
        
        Data admissao = new Data();
        
        float salario = (float) teclado.lerDouble("Salario: ");
        
        SetorDao setor = null;
        int idSetor = teclado.lerInt("Informe o id do setor que trabalha");

        Administrativo adm = new Administrativo(matricula, nome, endereco, agenda,
                admissao, salario, setor.buscarObjeto(idSetor) );
        
        administracaoDao.inserir(adm);

        System.out.println("Funcionario do administrativo cadastrado com sucesso!");

        return false;
    }
    
}
