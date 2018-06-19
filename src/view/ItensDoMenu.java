package view;

import model.Dao.AdministrativoDao;
import model.Dao.AlunoDao;
import model.Dao.CursoDao;
import model.Dao.DisciplinasDao;
import model.Dao.EscolaDao;
import model.Dao.InterfaceDao;
import model.Dao.ProfessorDao;
import model.Dao.SetorDao;
import model.Dao.TurmasDao;

/**
 *
 * @author Deyvidy
 */
public abstract class ItensDoMenu {    
    
    protected Teclado teclado;
    protected InterfaceDao administracaoDao;
    protected InterfaceDao alunoDao; 
    protected InterfaceDao cursoDao;
    protected InterfaceDao disciplinaDao;
    protected InterfaceDao escolaDao;
    protected InterfaceDao professorDao;
    protected InterfaceDao setorDao;
    protected InterfaceDao turmasDao;
            
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
