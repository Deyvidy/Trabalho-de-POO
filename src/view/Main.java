package view;

import java.util.Scanner;
import model.Sair;


public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        ItensDoMenu[] principal = new ItensDoMenu[] { 
            new Sair()
            
        };

        boolean sair = false;
        do {
            for (int i = 0; i < principal.length; i++) {
                    System.out.println(i + " - " + principal[i].descricao());
            }
            System.out.print("Qual a opção desejada: ");
            int opcao = Integer.parseInt(console.nextLine());

            sair = principal[opcao].executar();
        } while (!sair);
    }

}
