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
        
    public boolean inserir(){
        Helper helper = new Helper();
        String matricula = teclado.lerString("MATRICULA: ");
        String nome = teclado.lerString("NOME: ");
        
        Setor setor = helper.validarSetor();
        if ( setor == null ) return false;
        
        Endereco endereco = helper.preencherEndereco();
        
        Agenda agenda = helper.preencherAgenda();
        
        Data admissao = helper.preencherDataAdmissao();
        
        float salario = (float) teclado.lerDouble("Salario: ");        
       

        Administrativo adm = new Administrativo(matricula, nome, endereco, agenda,
                admissao, salario, setor );
        
        administracaoDao.inserir(adm);

        System.out.println("Funcionario do administrativo cadastrado com sucesso!");

        return false;
    }
    
    public boolean alterar(){
        String matricula = teclado.lerString("Informe a MATRICULA: ");
        Administrativo administrativo = (Administrativo) administracaoDao.pesquisar(matricula);

        if (administrativo == null) {
            System.out.println("Setor não encontrado!");
        }
        else {
            System.out.println("Id: " + administrativo.getMatricula());
            System.out.println("Nome: " + administrativo.getNome());            

            String nome = teclado.lerString("Novo nome: ");            

            administrativo.setNome(nome);            

            escolaDao.atualizar(administrativo);
            
        }

        return false;
    }
    
    public boolean remover(){
        String matricula = teclado.lerString("MATRICULA: ");
        Administrativo administrativo = (Administrativo) administracaoDao.pesquisar(matricula);

        if ( administrativo == null) {
            System.out.println("FUNCIONARIO não encontrado!");
        }
        else {
           
            escolaDao.remover(administrativo);
        }

        return false;
    }
    
    public boolean listar(){
        ArrayList<Administrativo> administrativo = administracaoDao.listar();

        Collections.sort(administrativo, this);

        for (int i = 0; i < administrativo.size(); i++) {
                Administrativo atual = administrativo.get(i);

                if (deveImprimir(atual)) {
                    System.out.println(atual.getMatricula() + " - " + atual.getNome()
                            + " - " + atual.getSalario()
                            + " - " + atual.getSetor().getNome()
                            + " - " + "DATA DE ADMISSAO"
                            + " - " + atual.getAdmissao().getAno()
                            + " - " + atual.getAdmissao().getMes()
                            + " - " + atual.getAdmissao().getDia()
                            + " - " + "ENDERECO" + "\n"
                            + " - " + atual.getEndereco().getPais()
                            + " - " + atual.getEndereco().getEstado()
                            + " - " + atual.getEndereco().getCidade()
                            + " - " + atual.getEndereco().getBairro()
                            + " - " + atual.getEndereco().getCep()
                            + " - " + atual.getEndereco().getRua()
                            + " - " + atual.getEndereco().getNumero()
                            + " - " + "CONTATO" + "\n"
                            + " - " + atual.getTelefone().getNumero()
                            + " - " + atual.getTelefone().getEmail()
                    );
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
