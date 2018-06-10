package view;


/**
 *
 * @author Deyvidy
 */
public abstract class ItensDoMenu {    
    
    protected Teclado teclado;
  
    
    public ItensDoMenu(){
        teclado = new Teclado();
               
        
    }

   
    public Teclado getTeclado() {
        return teclado;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }
    
    
    public abstract String descricao();
    public abstract boolean executar();
    
}
