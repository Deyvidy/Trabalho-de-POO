package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Agenda;
import model.Aluno;
import model.Curso;
import model.Endereco;
import model.Helper;
import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class AlunoActions extends ItensDoMenu implements Comparator<Aluno> {
        private int quantidade;
        
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
    
    public boolean alterar(){
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
    
    public boolean listar(){
        ArrayList<Aluno> aluno = alunoDao.listar();

        Collections.sort(aluno, this);

        for (int i = 0; i < aluno.size(); i++) {
                Aluno atual = aluno.get(i);

                if (deveImprimir(atual)) {
                        System.out.println(atual.getMatricula()+ " - " + atual.getNome()
                                + " - " + atual.getCurso().getNome() + "\n" 
                                + " - " + atual.getEndereco().getPais()
                                + " - " + atual.getEndereco().getEstado()
                                + " - " + atual.getEndereco().getCidade()
                                + " - " + atual.getEndereco().getBairro()
                                + " - " + atual.getEndereco().getCep()
                                + " - " + atual.getEndereco().getRua()
                                + " - " + atual.getEndereco().getNumero() + "\n"
                                + " - " + atual.getTelefone().getNumero()
                                + " - " + atual.getTelefone().getEmail()
                        );
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
