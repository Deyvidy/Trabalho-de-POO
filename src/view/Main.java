package view;

import java.util.Scanner;
import model.AdministrativoActions;
import model.AlunoActions;
import model.CursoActions;
import model.DisciplinaActions;
import model.EscolasActions;
import model.ProfessorActions;
import model.SetorActions;
import model.TurmasActions;

public class Main {
    
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);         
               
        System.out.println("Qual a opção desejada: ");
        System.out.println("[1] Cadastros"
                + "\n[2] Listagem"
                + "\n[3] Alteracão "
                + "\n[4] Exclusão"
                + "\n[0] Sair"
        );
        
        boolean sair = false;
        
        int op = teclado.nextInt();
        do {  
            switch (op) {
                case 1:
                    cadastro(teclado);
                break;
                case 2:
                    listagem(teclado);
                break;
                case 3:
                   alteracao(teclado);
                break;
                case 4:
                    exclusao(teclado);
                break;
                case 0:
                    sair = true;                    
                break;
            }                
        } while (!sair);        
    }     
    
    public static void cadastro ( Scanner teclado ){
        String[] back = null;
        AdministrativoActions administrativo = new AdministrativoActions();
        AlunoActions aluno =  new AlunoActions();
        CursoActions curso = new CursoActions();
        DisciplinaActions disciplina = new DisciplinaActions(); 
        EscolasActions escola = new EscolasActions();
        ProfessorActions professor = new ProfessorActions();
        SetorActions setor = new SetorActions();
        TurmasActions turmas = new TurmasActions();
        Voltar voltar = new  Voltar();
                
        boolean sair = false;
        
            System.out.print("Qual a opção desejada: ");
            System.out.println("\n[1] ADMINISTRATIVO "
                + "\n[2] PROFESSORES"
                + "\n[3] ALUNO  "
                + "\n[4] SETOR"
                + "\n[5] TURMA"
                + "\n[6] CURSO"
                + "\n[7] DISCIPLINA"
                + "\n[8] ESCOLA"
                + "\n[0] SAIR"
            );
            
        do {
            int opcao = teclado.nextInt();
             switch (opcao) {
                case 1:
                    administrativo.inserir();
                    main(back);
                break;
                case 2:
                    professor.inserir();
                    main(back);
                break;
                case 3:
                    aluno.inserir();
                    main(back);
                break;
                case 4:
                    setor.inserir();
                    main(back);
                break;
                case 5:
                    turmas.inserir();
                    main(back);
                break;
                case 6:
                    curso.inserir();
                    main(back);
                break;
                case 7:
                    disciplina.inserir();
                    main(back);
                break;
                case 8:
                    escola.inserir();
                    main(back);
                break;
                case 0:
                    sair = voltar.executar();                  
                break;
            }           
            if (sair){
                main(back);
            }            
        } while (!sair);
    }   
    
    public static void listagem ( Scanner teclado ){
        String[] back = null;
        AdministrativoActions administrativo = new AdministrativoActions();
        AlunoActions aluno =  new AlunoActions();
        CursoActions curso = new CursoActions();
        DisciplinaActions disciplina = new DisciplinaActions(); 
        EscolasActions escola = new EscolasActions();
        ProfessorActions professor = new ProfessorActions();
        SetorActions setor = new SetorActions();
        TurmasActions turmas = new TurmasActions();       
        Voltar voltar = new  Voltar();
                
        boolean sair = false;
        
            System.out.print("Qual a opção desejada: ");
            System.out.println("\n[1] ADMINISTRATIVO "
                + "\n[2] PROFESSORES"
                + "\n[3] ALUNO  "
                + "\n[4] SETOR"
                + "\n[5] TURMA"
                + "\n[6] CURSO"
                + "\n[7] DISCIPLINA"
                + "\n[8] ESCOLA"
                + "\n[0] SAIR"
            );
            
        do {
            int opcao = teclado.nextInt();
             switch (opcao) {
                case 1:
                    administrativo.listar();
                    main(back);
                break;
                case 2:
                    professor.listar();
                    main(back);
                break;
                case 3:
                    aluno.listar();
                    main(back);
                break;
                case 4:
                    setor.listar();
                    main(back);
                break;
                case 5:
                    turmas.listar();
                    main(back);
                break;
                case 6:
                    curso.listar();
                    main(back);
                break;
                case 7:
                    disciplina.listar();
                    main(back);
                break;
                case 8:
                    escola.listar();
                    main(back);
                break;
                case 0:
                    sair = voltar.executar();                  
                break;
            }           
            if (sair){
                main(back);
            }            
        } while (!sair);
    }      
    
    public static void alteracao ( Scanner teclado ){
        String[] back = null;
        AdministrativoActions administrativo = new AdministrativoActions();
        AlunoActions aluno =  new AlunoActions();
        CursoActions curso = new CursoActions();
        DisciplinaActions disciplina = new DisciplinaActions(); 
        EscolasActions escola = new EscolasActions();
        ProfessorActions professor = new ProfessorActions();
        SetorActions setor = new SetorActions();
        TurmasActions turmas = new TurmasActions();       
        Voltar voltar = new  Voltar();      
        
        
        boolean sair = false;
        
            System.out.print("Qual a opção desejada: ");
            System.out.println("\n[1] ADMINISTRATIVO "
                + "\n[2] PROFESSORES"
                + "\n[3] ALUNO  "
                + "\n[4] SETOR"
                + "\n[5] TURMA"
                + "\n[6] CURSO"
                + "\n[7] DISCIPLINA"
                + "\n[8] ESCOLA"
                + "\n[0] SAIR"
            );
            
        do {
            int opcao = teclado.nextInt();
             switch (opcao) {
                case 1:
                    administrativo.alterar();
                    main(back);
                break;
                case 2:
                    professor.alterar();
                    main(back);
                break;
                case 3:
                    aluno.alterar();
                    main(back);
                break;
                case 4:
                    setor.alterar();
                    main(back);
                break;
                case 5:
                    turmas.alterar();
                    main(back);
                break;
                case 6:
                    curso.alterar();
                    main(back);
                break;
                case 7:
                    disciplina.alterar();
                    main(back);
                break;
                case 8:
                    escola.alterar();
                    main(back);
                break;
                case 0:
                    sair = voltar.executar();                  
                break;
            }           
            if (sair){
                main(back);
            }            
        } while (!sair);
    }   
    
    public static void exclusao ( Scanner teclado ){
        String[] back = null;        
        AdministrativoActions administrativo = new AdministrativoActions();
        AlunoActions aluno =  new AlunoActions();
        CursoActions curso = new CursoActions();
        DisciplinaActions disciplina = new DisciplinaActions(); 
        EscolasActions escola = new EscolasActions();
        ProfessorActions professor = new ProfessorActions();
        SetorActions setor = new SetorActions();
        TurmasActions turmas = new TurmasActions();       
        Voltar voltar = new  Voltar();
                
        boolean sair = false;
        
            System.out.print("Qual a opção desejada: ");
            System.out.println("\n[1] ADMINISTRATIVO "
                + "\n[2] PROFESSORES"
                + "\n[3] ALUNO  "
                + "\n[4] SETOR"
                + "\n[5] TURMA"
                + "\n[6] CURSO"
                + "\n[7] DISCIPLINA"
                + "\n[8] ESCOLA"
                + "\n[0] SAIR"
            );
            
            
        do {
            int opcao = teclado.nextInt();
             switch (opcao) {
                case 1:
                    administrativo.remover();
                    main(back);
                break;
                case 2:
                    professor.remover();
                    main(back);
                break;
                case 3:
                    aluno.remover();
                    main(back);
                break;
                case 4:
                    setor.remover();
                    main(back);
                break;
                case 5:
                    turmas.remover();
                    main(back);
                break;
                case 6:
                    curso.remover();
                    main(back);
                break;
                case 7:
                    disciplina.remover();
                    main(back);
                break;
                case 8:
                    escola.remover();
                    main(back);
                break;
                case 0:
                    sair = voltar.executar();                  
                break;
            }           
            if (sair){
                main(back);
            }            
        } while (!sair);
    }   

}




