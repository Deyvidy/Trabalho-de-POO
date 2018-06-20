package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class AlunoActions extends ItensDoMenu implements Comparator<Aluno> {
        private int quantidade;
        
        @Override
    public boolean inserir(){
        Helper helper = new Helper();
        this.quantidade++;
        String matricula = teclado.lerString("Informe a MATRICULA: ");
        String nome = teclado.lerString("Informe o NOME: ");
        
        Curso curso = helper.validarCurso();
        if ( curso == null ) return false;
        
        Endereco endereco = helper.preencherEndereco();
        
        Agenda telefone = helper.preencherAgenda();       
        
        Aluno aluno = new Aluno( matricula, nome, endereco, telefone, curso );        

        alunoDao.inserir(aluno);

        System.out.println("ALUNO cadastrado com sucesso!");

        return false;
    }
    
        @Override
    public boolean alterar(){
        Helper helper = new Helper();
        String matricula = teclado.lerString("Informe a MATRICULA: ");
        Aluno aluno =  (Aluno) alunoDao.pesquisar(matricula);

        if (aluno == null) {
            System.out.println("ALUNO não encontrado!");
        }
        else {
            System.out.println("===================");
            System.out.println("MATRICULA: " + aluno.getMatricula());
            System.out.println("NOME: " + aluno.getNome());
            System.out.println("CURSO: " + aluno.getCurso().getNome()); 
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
            
            String opCurso = teclado.lerString("Deseja altera o CURSO? [S]- SIM [N] - NÃO: ");  
            if( "S".equals(opCurso) || "s".equals(opCurso) ){
                Curso curso = helper.validarCurso();
                aluno.setCurso(curso);
            }            
            
            String opEndereco = teclado.lerString("Deseja altera o ENDERECO? [S]- SIM [N] - NÃO: ");            
            if( "S".equals(opEndereco) || "s".equals(opEndereco) ){
                Endereco endereco = helper.preencherEndereco();
                aluno.setEndereco(endereco);
            }
            
            String opTelefone = teclado.lerString("Deseja altera os dados para CONTATO? [S]- SIM [N] - NÃO: ");
            if( "S".equals(opTelefone) || "s".equals(opTelefone) ){
                Agenda telefone = helper.preencherAgenda(); 
                aluno.setTelefone(telefone);
            }  
            
            alunoDao.atualizar(aluno);
            System.out.println("Alteraçoes efetuadas com sucesso!");
        }

        return false;
    }
    
        @Override
    public boolean remover(){
        String matricula = teclado.lerString("MATRICULA: ");
        Aluno aluno = (Aluno) alunoDao.pesquisar(matricula);

        if ( aluno == null) {
            System.out.println("ALUNO não encontrada!");
        }
        else {           
            alunoDao.remover(aluno);
        }

        return false;
    }
    
        @Override
    public boolean listar(){
        ArrayList<Aluno> aluno = alunoDao.listar();

        Collections.sort(aluno, this);

        for (int i = 0; i < aluno.size(); i++) {
                Aluno atual = aluno.get(i);

                if (deveImprimir(atual)) {                        
                        System.out.println("MATRICULA: " + atual.getMatricula());
                        System.out.println("NOME: " + atual.getNome());
                        System.out.println("CURSO: " + atual.getCurso().getNome()); 
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

    public boolean deveImprimir(Aluno escolas){
        return true;
    }
    
    @Override
    public int compare(Aluno t, Aluno t1) {
        String nome1 = t.getNome();
        String nome2 = t1.getNome();
		
        return nome1.compareTo(nome2);
    }
    
}
