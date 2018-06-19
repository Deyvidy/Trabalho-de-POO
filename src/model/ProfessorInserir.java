package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */
public class ProfessorInserir extends ItensDoMenu{
    private int quantidade;

    @Override
    public String descricao() {
        return "Cadastra PROFESSORES ";
    }

    @Override
    public boolean executar() {
        Helper helper = new Helper();
        this.quantidade++;
        
        String matricula = teclado.lerString("Informe a MATRICULA: ");
        String nome = teclado.lerString("Informe o NOME: ");        
        float salario = (float) teclado.lerDouble("Informe o SALARIO: ");
        
        Curso curso = helper.validarCurso();        
        if ( curso == null ) return false;
        
        Escolas escola = helper.validarEscolas();        
        if ( escola == null ) return false;
        
        Endereco endereco = helper.preencherEndereco();
        
        Agenda telefone = helper.preencherAgenda();     
                
        Data data = helper.preencherDataAdmissao();        
        
        Professor professor = new Professor( matricula, nome, endereco, telefone, data, salario, escola);        

        professorDao.inserir(professor);
      
        System.out.println("PROFESSORE cadastrado com sucesso!");

        return false;
    }
    
}
