package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class AlunoAlterar extends ItensDoMenu{

    @Override
    public String descricao() {
        return "Alterar dados de ALUNO ";
    }

    @Override
    public boolean executar() {
        String matricula = teclado.lerString("Informe a MATRICULA: ");
        Aluno aluno =  (Aluno) alunoDao.pesquisar(matricula);

        if (aluno == null) {
            System.out.println("ALUNO não encontrado!");
        }
        else {
            System.out.println("===================");
            System.out.println("MATRICULA: " + aluno.getMatricula());
            System.out.println("NOME: " + aluno.getNome()); 
            System.out.println("PAIS: " + aluno.getEndereco().getPais());
            System.out.println("ESTADO: " + aluno.getEndereco().getEstado());
            System.out.println("CIDADE: " + aluno.getEndereco().getCidade());   
            System.out.println("BAIRRO: " + aluno.getEndereco().getBairro());          
            System.out.println("CEP: " + aluno.getEndereco().getCep());          
            System.out.println("RUA: " + aluno.getEndereco().getRua());          
            System.out.println("Nº RESIDENCIA: " + aluno.getEndereco().getNumero());
            System.out.println("TELEFONE: " + aluno.getTelefone().getNumero());
            System.out.println("E-MAIL: " + aluno.getTelefone().getEmail());
            System.out.println("===================");
            
            String nome = teclado.lerString("Novo NOME: "); 
            
            aluno.setNome(nome);            
            
            escolaDao.atualizar(aluno);
            
        }

        return false;
    }
    
}
