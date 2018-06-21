package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import view.ItensDoMenu;

/**
 *
 * @author Deyvidy
 */

public class AdministrativoActions extends ItensDoMenu implements Comparator<Administrativo> {
     private int quantidade;
        
     @Override
    public boolean inserir(){
        Helper helper = new Helper();
        String nome = teclado.lerString("NOME: ");
        
        Setor setor = helper.validarSetor();
        if ( setor == null ) return false;        
        
        Endereco endereco = helper.preencherEndereco();
        
        Agenda agenda = helper.preencherAgenda();
        
        Data admissao = helper.preencherDataAdmissao();
        
        int matricula = Id.getIdAdministrativo();
        
        float salario = (float) teclado.lerDouble("SALARIO: "); 

        Administrativo adm = new Administrativo(matricula, nome, endereco, agenda,
                admissao, salario, setor );
        
        administracaoDao.inserir(adm);

        System.out.println("Funcionario do ADMINSITRATIVO cadastrado com sucesso!");

        return false;
    }
    
     @Override
    public boolean alterar(){
        Helper helper = new Helper();
        int matricula = teclado.lerInt("Informe a MATRICULA: ");
        Administrativo administrativo = (Administrativo) administracaoDao.pesquisar(matricula);

        if (administrativo == null) {
            System.out.println("FUNCIONARIO não encontrado!");
        } else {
            System.out.println("===================");
            System.out.println("ID: " + administrativo.getMatricula());
            System.out.println("NOME: " + administrativo.getNome());
            System.out.println("SETOR: " + administrativo.getSetor().getNome());
            System.out.println("SALARIO: " + administrativo.getSalario());
            System.out.println("DATA DE ADMISSAO: " + administrativo.getAdmissao().getDia() + "/" 
                    + administrativo.getAdmissao().getMes() 
                    + "/" + administrativo.getAdmissao().getAno());
            System.out.println("PAIS: " + administrativo.getEndereco().getPais());
            System.out.println("ESTADO: " + administrativo.getEndereco().getEstado());
            System.out.println("CIDADE: " + administrativo.getEndereco().getCidade());   
            System.out.println("BAIRRO: " + administrativo.getEndereco().getBairro());          
            System.out.println("CEP: " + administrativo.getEndereco().getCep());          
            System.out.println("RUA: " + administrativo.getEndereco().getRua());          
            System.out.println("Nº RESIDENCIA: " + administrativo.getEndereco().getNumero());
            System.out.println("TELEFONE: " + administrativo.getTelefone().getNumero());
            System.out.println("E-MAIL: " + administrativo.getTelefone().getEmail());
            System.out.println("===================");

            String nome = teclado.lerString("Novo NOME: ");
            administrativo.setNome(nome);
            
            String opCurso = teclado.lerString("Deseja altera o SETOR? [S]- SIM [N] - NÃO: ");  
            if( "S".equals(opCurso) || "s".equals(opCurso) ){
                Setor setor = helper.validarSetor();
                administrativo.setSetor(setor);
            }       

            String opEndereco = teclado.lerString("Deseja altera o ENDERECO? [S]- SIM [N] - NÃO: ");            
            if( "S".equals(opEndereco) || "s".equals(opEndereco) ){
                Endereco endereco = helper.preencherEndereco();
                administrativo.setEndereco(endereco);
            }
            
            String opTelefone = teclado.lerString("Deseja altera os dados para CONTATO? [S]- SIM [N] - NÃO: ");
            if( "S".equals(opTelefone) || "s".equals(opTelefone) ){
                Agenda telefone = helper.preencherAgenda(); 
                administrativo.setTelefone(telefone);
            }  

            administracaoDao.atualizar(administrativo);
            System.out.println("Alteraçoes efetuadas com sucesso!");            
        }

        return false;
    }
    
     @Override
    public boolean remover(){
        int matricula = teclado.lerInt("MATRICULA: ");
        Administrativo administrativo = (Administrativo) administracaoDao.pesquisar(matricula);

        if ( administrativo == null) {
            System.out.println("FUNCIONARIO não encontrado!");
        }
        else {
           
            administracaoDao.remover(administrativo);
            System.out.println("Remoção efetuadas com sucesso!");
        }

        return false;
    }
    
     @Override
    public boolean listar(){
        ArrayList<Administrativo> administrativo = administracaoDao.listar();

        Collections.sort(administrativo, this);

        for (int i = 0; i < administrativo.size(); i++) {
                Administrativo atual = administrativo.get(i);

                if (deveImprimir(atual)) {
                    System.out.println("ID: " + atual.getMatricula());
                    System.out.println("NOME: " + atual.getNome());
                    System.out.println("SETOR: " + atual.getSetor().getNome());
                    System.out.println("SALARIO: " + atual.getSalario());
                    System.out.println("DATA DE ADMISSAO: " + atual.getAdmissao().getDia() + "/" 
                            + atual.getAdmissao().getMes() 
                            + "/" + atual.getAdmissao().getAno());
                    System.out.println("PAIS: " + atual.getEndereco().getPais());
                    System.out.println("ESTADO: " + atual.getEndereco().getEstado());
                    System.out.println("CIDADE: " + atual.getEndereco().getCidade());   
                    System.out.println("BAIRRO: " + atual.getEndereco().getBairro());          
                    System.out.println("CEP: " + atual.getEndereco().getCep());          
                    System.out.println("RUA: " + atual.getEndereco().getRua());          
                    System.out.println("Nº RESIDENCIA: " + atual.getEndereco().getNumero());
                    System.out.println("TELEFONE: " + atual.getTelefone().getNumero());
                    System.out.println("E-MAIL: " + atual.getTelefone().getEmail());
                    System.out.println("===================");
                }
        }

        return false;
    }

    public boolean deveImprimir(Administrativo setor){
        return true;
    }
    
    @Override
    public int compare(Administrativo t, Administrativo t1) {
        String nome1 = t.getNome();
        String nome2 = t1.getNome();
		
        return nome1.compareTo(nome2);
    }
    
}
