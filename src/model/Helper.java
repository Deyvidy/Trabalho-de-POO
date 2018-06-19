package model;

import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class Helper extends ItensDoMenu {
    
    public Curso validarCurso( ){
        boolean ok = true;
        Curso curso = null;
        
        while ( ok ) {
            String nomeCurso = teclado.lerString("Informe o CURSO: ");        
            curso  = cursoDao.pesquisar(nomeCurso);
            
                if ( curso == null ) {
                    System.out.println("CURSO não encontrado...");            
                } else {
                    ok = false;
                    break;                
                }
        }
        return curso;
    }
    
    public Escolas validarEscolas( ){
        boolean ok = true;
        Escolas escola = null;
        
        while ( ok ) {
            String nomeEscola = teclado.lerString("Informe a ESCOLA: ");
            escola  = escolaDao.pesquisar(nomeEscola);
            
                if ( escola == null ) {
                    System.out.println("ESCOLA não encontrada...");          
                } else {
                    ok = false;
                    break;                
                }
        }
        return escola;
    }
    
    public Endereco preencherEndereco(){
        System.out.println("ENDERECO: ");
        
        String pais = teclado.lerString("PAIS: ");
        
        String estado = teclado.lerString("ESTADO: ");
        
        String cidade = teclado.lerString("CIDADE: ");
        
        String cep = teclado.lerString("CEP: ");
        
        String bairro = teclado.lerString("BAIRRO: ");
        
        String rua = teclado.lerString("RUA: ");        
        
        String numero = teclado.lerString("NUMERO DA RESIENCIA: ");     
        
        Endereco endereco = new Endereco(pais, estado, cidade, cep, bairro, rua, numero);        
        
        return endereco;
    }
    
    public Agenda preencherAgenda(){
        System.out.println("Informaçoes para CONTATO: ");
        
        String tel = teclado.lerString("TELEFONE: ");
        String email = teclado.lerString("E-MAIL: ");
        
        Agenda telefone = new Agenda(tel, email);    
        
        return telefone;
    }

    @Override
    public String descricao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean executar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
