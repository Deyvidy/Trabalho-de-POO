package view;

import java.util.Scanner;
import model.InserirAdministrativo;


public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
         
        boolean sair = false;
               
        System.out.println("Qual a opção desejada: ");
        System.out.println("[1] Cadastros"
                + "\n[2] Listagem"
                + "\n[3] Alteracão "
                + "\n[4] Exclusão"
                + "\n[0] Sair"
        );
        
        
        
        int op = teclado.nextInt();
        do {                 
            if ( op == 1) {
                cadastro(teclado);
            } else if ( op == 2) {
                listagem(teclado);
            } else if ( op == 3) {
                alteracao(teclado);
            } else if ( op == 4) {
                exclusao(teclado);
            } else if ( op == 0) {
                sair = true;
            }                       
        } while (!sair);
        
    }   
    
    
    public static void cadastro ( Scanner teclado ){

        ItensDoMenu[] cadastros = new ItensDoMenu[] { 
            new InserirAdministrativo(),
            new Sair()

        };
        
        boolean sair = false;
        do {
            for (int i = 0; i < cadastros.length; i++) {
                System.out.println(i + " - " + cadastros[i].descricao());
            }
            System.out.print("Qual a opção desejada: ");
            int opcao = teclado.nextInt();

            sair = cadastros[opcao].executar();
        } while (!sair);
    }   
    
    public static void listagem ( Scanner teclado ){

        ItensDoMenu[] listagem = new ItensDoMenu[] { 
            new InserirAdministrativo(),
            new Sair()
            
        };
        
        boolean sair = false;
        do {
            for (int i = 0; i < listagem.length; i++) {
                System.out.println(i + " - " + listagem[i].descricao());
            }
            System.out.print("Qual a opção desejada: ");
            int opcao = teclado.nextInt();

            sair = listagem[opcao].executar();
        } while (!sair);
    }   
    
    
    public static void alteracao ( Scanner teclado ){

        ItensDoMenu[] alteracao = new ItensDoMenu[] { 
            new InserirAdministrativo(),
            new Sair()
            
        };
        
        boolean sair = false;
        do {
            for (int i = 0; i < alteracao.length; i++) {
                System.out.println(i + " - " + alteracao[i].descricao());
            }
            System.out.print("Qual a opção desejada: ");
            int opcao = teclado.nextInt();

            sair = alteracao[opcao].executar();
        } while (!sair);
    }   
    
    public static void exclusao ( Scanner teclado ){

        ItensDoMenu[] exclusao = new ItensDoMenu[] { 
            new InserirAdministrativo(),
            new Sair()
            
        };
        
        boolean sair = false;
        do {
            for (int i = 0; i < exclusao.length; i++) {
                System.out.println(i + " - " + exclusao[i].descricao());
            }
            System.out.print("Qual a opção desejada: ");
            int opcao = teclado.nextInt();

            sair = exclusao[opcao].executar();
        } while (!sair);
    }   

}




