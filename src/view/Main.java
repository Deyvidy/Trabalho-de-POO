package view;

import java.util.Scanner;
import model.EscolasAlterar;
import model.EscolasExcluir;
import model.EscolasInserir;
import model.EscolasListar;
import model.AdministrativoInserir;
import model.SetorAlterar;
import model.SetorExcluir;
import model.SetorInserir;
import model.SetorListar;


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
        String[] back = null;
        ItensDoMenu[] cadastros = new ItensDoMenu[] { 
            new AdministrativoInserir(),
            new EscolasInserir(),
            new SetorInserir(),
            new Voltar()

        };
        
        boolean sair = false;
        
        do {
            for (int i = 0; i < cadastros.length; i++) {
                System.out.println(i + " - " + cadastros[i].descricao());
            }
            System.out.print("Qual a opção desejada: ");
            int opcao = teclado.nextInt();

            sair = cadastros[opcao].executar();
            if (sair){
                main(back);
            }
        } while (!sair);
    }   
    
    public static void listagem ( Scanner teclado ){
        String[] back = null;
        ItensDoMenu[] listagem = new ItensDoMenu[] { 
            new EscolasListar(),
            new SetorListar(),
            new Voltar()
            
        };
        
        boolean sair = false;
        do {
            for (int i = 0; i < listagem.length; i++) {
                System.out.println(i + " - " + listagem[i].descricao());
            }
            System.out.print("Qual a opção desejada: ");
            int opcao = teclado.nextInt();

            sair = listagem[opcao].executar();
            if (sair){
                main(back);
            }
        } while (!sair);
    }      
    
    public static void alteracao ( Scanner teclado ){
        String[] back = null;
        ItensDoMenu[] alteracao = new ItensDoMenu[] { 
            new EscolasAlterar(),
            new SetorAlterar(),
            new Voltar()
            
        };
        
        boolean sair = false;
        do {
            for (int i = 0; i < alteracao.length; i++) {
                System.out.println(i + " - " + alteracao[i].descricao());
            }
            System.out.print("Qual a opção desejada: ");
            int opcao = teclado.nextInt();

            sair = alteracao[opcao].executar();
            if (sair){
                main(back);
            }
        } while (!sair);
    }   
    
    public static void exclusao ( Scanner teclado ){
        String[] back = null;
        ItensDoMenu[] exclusao = new ItensDoMenu[] { 
            new SetorExcluir(),
            new EscolasExcluir(),
            new Voltar()
            
        };
        
        boolean sair = false;
        do {
            for (int i = 0; i < exclusao.length; i++) {
                System.out.println(i + " - " + exclusao[i].descricao());
            }
            System.out.print("Qual a opção desejada: ");
            int opcao = teclado.nextInt();

            sair = exclusao[opcao].executar();
            if (sair){
                main(back);
            }
        } while (!sair);
    }   

}




