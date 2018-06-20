package model;
/*
* O sistema deverá permitir o cadastro/atualização de escolas, armazenando/modificando as
* seguintes informações: id, nome da escola. Este módulo deverá permitir a exibição de uma lista
* com todos os professores que lecionam na escola. Ex.: TI, Saúde, RH. O sistema deve permitir,
* ainda, a exclusão do cadastro através do id.
*/

import java.util.ArrayList;

public class Escolas {
    private int id;
    private String nome;
    private ArrayList<Professor> professoresQueLecionam = new ArrayList<>();
    
    
    public Escolas(int id) {
        this.id = id;
    }   

    public Escolas(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
            return nome;
    }
    public void setNome(String nome) {
            this.nome = nome;
    }

    public ArrayList<Professor> getProfessoresQueLecionam() {
        return professoresQueLecionam;
    }
    
    public String listarProfessores( ) {
        String lista= " ";
        
        return lista;  
    }
}
