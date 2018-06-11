package view;

import model.Dao.AdministrativoDao;
import model.Dao.AlunoDao;
import model.Dao.CursoDao;
import model.Dao.DisciplinasDao;
import model.Dao.EscolaDao;
import model.Dao.InterfaceAdministracaoDao;
import model.Dao.InterfaceAlunoDao;
import model.Dao.InterfaceCursoDao;
import model.Dao.InterfaceDisciplinaDao;
import model.Dao.InterfaceEscolaDao;
import model.Dao.InterfaceProfessorDao;
import model.Dao.InterfaceSetorDao;
import model.Dao.InterfaceTurmasDao;
import model.Dao.ProfessorDao;
import model.Dao.SetorDao;
import model.Dao.TurmasDao;


/**
 *
 * @author Deyvidy
 */
public abstract class ItensDoMenu {    
    
    protected Teclado teclado;
    protected InterfaceAdministracaoDao administracaoDao;
    protected InterfaceAlunoDao alunoDao; 
    protected InterfaceCursoDao cursoDao;
    protected InterfaceDisciplinaDao disciplinaDao;
    protected InterfaceEscolaDao escolaDao;
    protected InterfaceProfessorDao professorDao;
    protected InterfaceSetorDao setorDao;
    protected InterfaceTurmasDao turmasDao;
            
    public ItensDoMenu(){
        teclado = new Teclado();
        administracaoDao = new AdministrativoDao();
        alunoDao = new AlunoDao();
        cursoDao = new CursoDao();
        disciplinaDao  = new DisciplinasDao();
        escolaDao = new EscolaDao();       
        professorDao = new ProfessorDao();
        setorDao = new SetorDao();       
        turmasDao = new TurmasDao();       
    }
        
    public abstract String descricao();
    public abstract boolean executar();
    
}
