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
        return "Cadastro ADMINISTRATIVOS";
    }

    @Override
    public boolean executar() {
        Helper helper = new Helper();
        String matricula = teclado.lerString("MATRICULA: ");
        String nome = teclado.lerString("NOME: ");
        
        Setor setor = helper.validarSetor();
        if ( setor == null ) return false;
        
        Endereco endereco = helper.preencherEndereco();
        
        Agenda agenda = helper.preencherAgenda();
        
        Data admissao = helper.preencherDataAdmissao();
        
        float salario = (float) teclado.lerDouble("Salario: ");        
       

        Administrativo adm = new Administrativo(matricula, nome, endereco, agenda,
                admissao, salario, setor );
        
        administracaoDao.inserir(adm);

        System.out.println("Funcionario do administrativo cadastrado com sucesso!");

        return false;
    }
    
}
