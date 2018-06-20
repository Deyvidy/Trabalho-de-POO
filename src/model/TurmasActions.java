package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class TurmasActions extends ItensDoMenu implements Comparator<Turmas> {
            
    @Override
    public boolean inserir(){
        Helper helper = new Helper();
        String nome = teclado.lerString("Nome: ");
        
        Disciplina disciplina = helper.validarDisciplina();
        if ( disciplina == null ) return false;
        
        Professor professor = helper.validarProfessor();
        if ( professor == null ) return false;
        
        int id = Id.getIdTurmas();
        
        Turmas turma = new Turmas( id, nome, disciplina, professor);
        
        ArrayList<Aluno> aluno = alunoDao.listar();
        
        for( int i = 0; i <aluno.size(); i++ ) {
            
        }

        turmasDao.inserir(turma);
        System.out.println("Turma cadastrada com sucesso!");
        return false;
    }
    
    @Override
    public boolean alterar(){
        Helper helper = new Helper();
        int id = teclado.lerInt("Informe o ID: ");
        Turmas turma = (Turmas) turmasDao.pesquisar(id);

        if (turma == null) {
            System.out.println("TURMA não encontrada!");
        }
        else {
            System.out.println("===================");
            System.out.println("ID: " + turma.getId());
            System.out.println("NOME: " + turma.getNome());
            System.out.println("===================");            

            String nome = teclado.lerString("Novo NOME: "); 
            turma.setNome(nome); 
            
            String opProf = teclado.lerString("Deseja altera o PROFESSOR? [S]- SIM [N] - NÃO: ");  
            if( "S".equals(opProf) || "s".equals(opProf) ){
                Professor professor = helper.validarProfessor();
                turma.setProfessor(professor);
            } 
            
            turmasDao.atualizar(turma);            
        }

        return false;
    }
    
    @Override
    public boolean remover(){
        int id = teclado.lerInt("ID: ");
        Turmas turma = (Turmas) turmasDao.pesquisar(id);

        if ( turma == null) {
            System.out.println("TURMA não encontrada!");
        }
        else {           
            turmasDao.remover(turma);
            System.out.println("TURMA removida com sucesso!");
        }

        return false;
    }
    
    @Override
    public boolean listar(){
        ArrayList<Turmas> turma = turmasDao.listar();

        Collections.sort(turma, this);

        for (int i = 0; i < turma.size(); i++) {
                Turmas atual = turma.get(i);

                if (deveImprimir(atual)) {
                    System.out.println("ID: " + atual.getId());
                    System.out.println("NOME: " + atual.getNome());
                    System.out.println("PROFESSOR: " + atual.getProfessor().getNome());
                    
                    for ( int j = 0; j < atual.getAlunos().size(); j++ ) {
                        System.out.println("ALUNOS: " + atual.getAlunos().get(j).getNome());
                    }
                    System.out.println("===================");
                    
                }
        }

        return false;
    }

    public boolean deveImprimir(Turmas turmas){
        return true;
    }
    
    @Override
    public int compare(Turmas t, Turmas t1) {
        String nome1 = t.getNome();
        String nome2 = t1.getNome();
		
        return nome1.compareTo(nome2);
    }
    
    public boolean inserirAlunoNaTurma() {
        Helper helper = new Helper();
        int id = teclado.lerInt("Informe o ID da TURMA: ");
        Turmas turma = (Turmas) turmasDao.pesquisar(id);

        if (turma == null) {
            System.out.println("TURMA não encontrada!");
        }
        else {
            System.out.println("===================");
            System.out.println("ID: " + turma.getId());
            System.out.println("NOME: " + turma.getNome());
            System.out.println("===================");
            
            boolean sair = true;
            while( sair ) {                
                String opAluno = teclado.lerString("Deseja cadastra algum ALUNO nessa TURMA? [S]- SIM [N] - NÃO: ");  
                if( "S".equals(opAluno) || "s".equals(opAluno) ){
                    Aluno aluno = helper.validarAluno();
                    turma.getAlunos().add(aluno);
                } else {
                    break;
                }
            }            
            // Falta alterar os alunos da turma
            
            turmasDao.atualizar(turma);            
        }

        return false;
    }
    
}
