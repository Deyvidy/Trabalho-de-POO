package view;

import java.util.Scanner;

/**
 *
 * @author Deyvidy
 */
public class Teclado {
    private Scanner teclado;
	
    public Teclado() {
            this.teclado = new Scanner(System.in);
    }
    

    public String lerString(String rotulo) {
            System.out.print(rotulo);
            return teclado.nextLine();
    }
    
    public int lerInt(String rotulo) {
            System.out.print(rotulo);
            return teclado.nextInt();
    }
     
    public double lerDouble(String rotulo) {
            return Double.parseDouble(lerString(rotulo));
    }
}
