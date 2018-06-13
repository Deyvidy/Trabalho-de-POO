package view;

import java.util.Scanner;
import model.Aluno;

/**
 *
 * @author Deyvidy
 */
public class Teclado <T>{
    private Scanner teclado;
	
    public Teclado() {
            this.teclado = new Scanner(System.in);
    }
    

    public String lerString(String rotulo) {
        System.out.print(rotulo);
        return teclado.next();
    }
    
    public int lerInt(String rotulo) {
        System.out.print(rotulo);
        return teclado.nextInt();
    }
     
    public double lerDouble(String rotulo) {
        System.out.print(rotulo);
        return Double.parseDouble(lerString(rotulo));
    }   
    
}
