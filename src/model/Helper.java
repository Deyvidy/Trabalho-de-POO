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
        int tentativas = 0;
       
        while ( ok ) {
            String nomeCurso = teclado.lerString("Informe o CURSO: ");        
            curso  = (Curso) cursoDao.pesquisar(nomeCurso);
            
                if ( curso == null ) {
                    tentativas++;
                    System.out.println("CURSO não encontrado..." + "tentativa: " + tentativas);
                    if (tentativas == 3){
                        break;
                    }
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
        int tentativas = 0;
        
        while ( ok ) {
            String nomeEscola = teclado.lerString("Informe a ESCOLA: ");
            escola  = (Escolas) escolaDao.pesquisar(nomeEscola);
            
                if ( escola == null ) {
                    tentativas++;
                    System.out.println("ESCOLA não encontrada..." + "tentativa: " + tentativas);
                    if (tentativas == 3){
                        break;
                    }
                } else {
                    ok = false;
                    break;                
                }
        }
        return escola;
    }
    
    public Setor validarSetor( ){
        boolean ok = true;
        Setor setor = null;
        int tentativas = 0;
        
        while ( ok ) {
            String nomeEscola = teclado.lerString("Informe o Setor: ");
            setor  = (Setor) setorDao.pesquisar(nomeEscola);
            
                if ( setor == null ) {
                    tentativas++;
                    System.out.println("SETOR não encontradp..." + "tentativa: " + tentativas);
                    if (tentativas == 3){
                        break;
                    }
                } else {
                    ok = false;
                    break;                
                }
        }
        return setor;
    }
    
    public Disciplina validarDisciplina( ){
        boolean ok = true;
        Disciplina disciplina = null;
        int tentativas = 0;
        
        while ( ok ) {
            String nomeDisciplina = teclado.lerString("Informe a DISCIPLINA: ");
            disciplina  = (Disciplina) disciplinaDao.pesquisar(nomeDisciplina);
            
                if ( disciplina == null ) {
                    tentativas++;
                    System.out.println("DISCIPLINA não encontrada..." + "Tentativa: " + tentativas);
                    if (tentativas == 3){
                        break;
                    }
                } else {
                    ok = false;
                    break;                
                }
        }
        return disciplina;
    }
    
    public Professor validarProfessor( ){
        boolean ok = true;
        Professor professor = null;
        int tentativas = 0;
        
        while ( ok ) {
            String nomeDisciplina = teclado.lerString("Informe o PROFESSOR: ");
            professor  = (Professor) professorDao.pesquisar(nomeDisciplina);
            
                if ( professor == null ) {
                    tentativas++;
                    System.out.println("PROFESSOR não encontrado..." + "Tentativa: " + tentativas);
                    if (tentativas == 3){
                        break;
                    }
                } else {
                    ok = false;
                    break;                
                }
        }
        return professor;
    }
    
    public Aluno validarAluno( ){
        boolean ok = true;
        Aluno aluno = null;
        int tentativas = 0;
        
        while ( ok ) {
            String nomeDisciplina = teclado.lerString("Informe o ALUNO: ");
            aluno  = (Aluno) alunoDao.pesquisar(nomeDisciplina);
            
                if ( aluno == null ) {
                    tentativas++;
                    System.out.println("ALUNO não encontrado..." + "Tentativa: " + tentativas);
                    if (tentativas == 3){
                        break;
                    }
                } else {
                    ok = false;
                    break;                
                }
        }
        return aluno;
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
    
    public Data preencherDataAdmissao(){
        System.out.println("Data da ADMISSAO: ");
        
        int dia = teclado.lerInt("DIA: ");
        int mes = teclado.lerInt("MES: ");
        int ano = teclado.lerInt("ANO: ");
        
        Data data = new Data(dia,mes,ano);    
        
        return data;
    }

    
    @Override
    public boolean inserir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
