package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class ProfessorActions extends ItensDoMenu implements Comparator<Professor> {
            
    @Override
    public boolean inserir(){
        Helper helper = new Helper();
                
        String matricula = Integer.toString(Id.getIdProfessor());
        String nome = teclado.lerString("Informe o NOME: ");        
        float salario = (float) teclado.lerDouble("Informe o SALARIO: ");              
        
        Escolas escola = helper.validarEscolas();        
        if ( escola == null ) return false;
        
        Endereco endereco = helper.preencherEndereco();
        
        Agenda telefone = helper.preencherAgenda();     
                
        Data data = helper.preencherDataAdmissao();        
        
        Professor professor = new Professor( matricula, nome, endereco, telefone, data, salario, escola);        

        professorDao.inserir(professor);
        escola.getProfessoresQueLecionam().add(professor);
        System.out.println("PROFESSORE cadastrado com sucesso!");

        return false;
    }
    
    @Override
    public boolean alterar(){
        Helper helper = new Helper();
        String matricula = teclado.lerString("Informe a MATRICULA: ");
        Professor professor = (Professor) professorDao.pesquisar(matricula);

        if (professor == null) {
            System.out.println("PROFESSORE não encontrado!");
        }
        else {
            System.out.println("===================");
            System.out.println("MATRICULA: " + professor.getMatricula());
            System.out.println("NOME: " + professor.getNome());
            System.out.println("ESCOLA: " + professor.getEscola().getNome());
            System.out.println("SALARIO: " + professor.getSalario());
            System.out.println("DATA DE ADMISSAO: " + professor.getAdmissao().getDia() + "/" 
                    + professor.getAdmissao().getMes() 
                    + "/" + professor.getAdmissao().getAno());
            System.out.println("PAIS: " + professor.getEndereco().getPais());
            System.out.println("ESTADO: " + professor.getEndereco().getEstado());
            System.out.println("CIDADE: " + professor.getEndereco().getCidade());   
            System.out.println("BAIRRO: " + professor.getEndereco().getBairro());          
            System.out.println("CEP: " + professor.getEndereco().getCep());          
            System.out.println("RUA: " + professor.getEndereco().getRua());          
            System.out.println("Nº RESIDENCIA: " + professor.getEndereco().getNumero());
            System.out.println("TELEFONE: " + professor.getTelefone().getNumero());
            System.out.println("E-MAIL: " + professor.getTelefone().getEmail());
            System.out.println("===================");

            String nome = teclado.lerString("Novo NOME: "); 
            professor.setNome(nome);      
            
            String opCurso = teclado.lerString("Deseja altera a ESCOLA? [S]- SIM [N] - NÃO: ");  
            if( "S".equals(opCurso) || "s".equals(opCurso) ){
                Escolas escola = helper.validarEscolas();
                professor.setEscola(escola);
            }       

            String opEndereco = teclado.lerString("Deseja altera o ENDERECO? [S]- SIM [N] - NÃO: ");            
            if( "S".equals(opEndereco) || "s".equals(opEndereco) ){
                Endereco endereco = helper.preencherEndereco();
                professor.setEndereco(endereco);
            }
            
            String opTelefone = teclado.lerString("Deseja altera os dados para CONTATO? [S]- SIM [N] - NÃO: ");
            if( "S".equals(opTelefone) || "s".equals(opTelefone) ){
                Agenda telefone = helper.preencherAgenda(); 
                professor.setTelefone(telefone);
            }  

            professorDao.atualizar(professor);
            System.out.println("Alteraçoes efetuadas com sucesso!");    
        }

        return false;
    }
    
    @Override
    public boolean remover(){
         String matricula = teclado.lerString("MATRICULA: ");
        Professor professor = (Professor) professorDao.pesquisar(matricula);

        if ( professor == null) {
            System.out.println("PROFESSOR não encontrado!");
        }
        else {            
            professorDao.remover(professor);
            System.out.println("PROFESSOR excluido com sucesso!");
        }

        return false;
    }
    
    @Override
    public boolean listar(){
        ArrayList<Professor> professor = professorDao.listar();

        Collections.sort(professor, this);

        for (int i = 0; i < professor.size(); i++) {
                Professor atual = professor.get(i);

                if (deveImprimir(atual)) {
                    System.out.println("MATRICULA: " + atual.getMatricula());
                    System.out.println("NOME: " + atual.getNome());
                    System.out.println("ESCOLA: " + atual.getEscola().getNome());
                    System.out.println("SALARIO: " + atual.getSalario());
                    System.out.println("DATA DE ADMISSAO: " + atual.getAdmissao().getDia() + "/" 
                            + atual.getAdmissao().getMes() 
                            + "/" + atual.getAdmissao().getAno());
                    System.out.println("PAIS: " + atual.getEndereco().getPais());
                    System.out.println("ESTADO: " + atual.getEndereco().getEstado());
                    System.out.println("CIDADE: " + atual.getEndereco().getCidade());   
                    System.out.println("BAIRRO: " + atual.getEndereco().getBairro());          
                    System.out.println("CEP: " + atual.getEndereco().getCep());          
                    System.out.println("RUA: " + atual.getEndereco().getRua());          
                    System.out.println("Nº RESIDENCIA: " + atual.getEndereco().getNumero());
                    System.out.println("TELEFONE: " + atual.getTelefone().getNumero());
                    System.out.println("E-MAIL: " + atual.getTelefone().getEmail());
                    System.out.println("===================");
                }
        }

        return false;
    }

    public boolean deveImprimir(Professor professor){
        return true;
    }
    
    @Override
    public int compare(Professor t, Professor t1) {
        String nome1 = t.getNome();
        String nome2 = t1.getNome();
		
        return nome1.compareTo(nome2);
    }
    
    
}
