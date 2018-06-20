package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Agenda;
import model.Curso;
import model.Dao.SetorDao;
import model.Data;
import model.Endereco;
import model.Escolas;
import model.Helper;
import model.Professor;
import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class ProfessorActions extends ItensDoMenu implements Comparator<Professor> {
    private int quantidade;
        
    public boolean inserir(){
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
    
    public boolean alterar(){
        String matricula = teclado.lerString("Informe a MATRICULA: ");
        Professor professor = (Professor) professorDao.pesquisar(matricula);

        if (professor == null) {
            System.out.println("PROFESSORE não encontrado!");
        }
        else {
            System.out.println("MATRICULA: " + professor.getMatricula());
            System.out.println("NOME: " + professor.getNome());            

            String nome = teclado.lerString("Novo NOME: ");            

            professor.setNome(nome);            

            setorDao.atualizar(professor);
            
        }

        return false;
    }
    
    public boolean remover(){
         String matricula = teclado.lerString("MATRICULA: ");
        Professor professor = (Professor) professorDao.pesquisar(matricula);

        if ( professor == null) {
            System.out.println("PROFESSOR não encontrado!");
        }
        else {            
            setorDao.remover(professor);
            System.out.println("PROFESSOR excluido com sucesso!");
        }

        return false;
    }
    
    public boolean listar(){
        ArrayList<Professor> professor = professorDao.listar();

        Collections.sort(professor, this);

        for (int i = 0; i < professor.size(); i++) {
                Professor atual = professor.get(i);

                if (deveImprimir(atual)) {
                    System.out.println(atual.getMatricula() + " - " + atual.getNome()
                            + " - " + atual.getSalario()
                            + " - " + "DATA DE ADMISSAO"
                            + " - " + atual.getAdmissao().getAno()
                            + " - " + atual.getAdmissao().getMes()
                            + " - " + atual.getAdmissao().getDia()
                            + " - " + "ENDERECO" + "\n"
                            + " - " + atual.getEndereco().getPais()
                            + " - " + atual.getEndereco().getEstado()
                            + " - " + atual.getEndereco().getCidade()
                            + " - " + atual.getEndereco().getBairro()
                            + " - " + atual.getEndereco().getCep()
                            + " - " + atual.getEndereco().getRua()
                            + " - " + atual.getEndereco().getNumero()
                            + " - " + "CONTATO" + "\n"
                            + " - " + atual.getTelefone().getNumero()
                            + " - " + atual.getTelefone().getEmail()
                    );
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
